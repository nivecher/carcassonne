package carcassonne.board;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import carcassonne.features.FeatureBuilder;
import carcassonne.features.IFeature;
import carcassonne.tiles.ITile;

/**
 * Play area implementation that maps tile placements by tile and by position
 *
 * Also listens for
 *
 * @author Morgan
 */
public class PlayArea implements IPlayArea, ITilePlacementListener {
    
    private final Map<ITile, ITilePlacement> placementMap = new HashMap<>();
    private final Map<Position, ITilePlacement> positionMap = new HashMap<>();
    
    @Override
    public ITilePlacement setStartTile(ITile startTile) {
        return placeTile(startTile, Position.BASE);
    }
    
    @Override
    public final ITilePlacement placeTile(ITile tile, Position position) {
        if (positionMap.containsKey(position)) {
            throw new IllegalStateException("Position " + position +
                    " already occupied by " + positionMap.get(position));
        }
        
        ITilePlacement placement = new TilePlacement(tile, position);
		placement.addTileListener(this);
        placementMap.put(tile, placement);
        positionMap.put(position, placement);
        return placement;
    }

    /**
     * Removes a tile from the board
     *
     * @param tile tile to remove
     * @return ITilePlacement placement containing the removed tile which was
     *         removed from the play area or null if tile was not in the play area
     */
    @Override
    public ITilePlacement removeTile(ITile tile) {
        ITilePlacement placement = findTile(tile);
        if (placement == null) {
            return null; // tile not found
        }
        placementMap.remove(tile);
        positionMap.remove(placement.getPosition());
        return placement;
    }

    @Override
    public final ITilePlacement getPlacement(Position position) {
        return positionMap.get(position);
    }
    
    @Override
    public final ITilePlacement findTile(ITile tile) {
        return placementMap.get(tile);
    }

	@Override
	public void tilePlaced(ITilePlacement tile) {
		checkCompleted();
	}

	// TODO - find completed features
	private void checkCompleted() {
		Set<ITilePlacement> processed = new HashSet<>();
		FeatureBuilder fb = new FeatureBuilder(this);
		
		for (ITilePlacement placement : placementMap.values()) {
			if (processed.contains(placement)) {
				continue; // already processed
			}
			
			for (IFeature f : fb.buildFeatures(placement)) {
				if (f.isComplete()) {
					System.out.println("Feature complete: " + f);
				}
			}
			
			processed.add(placement);
		}
	}
}
