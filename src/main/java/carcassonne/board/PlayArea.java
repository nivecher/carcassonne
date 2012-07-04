/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.board;

import carcassonne.features.FeatureBuilder;
import carcassonne.features.IFeature;
import carcassonne.tiles.ITile;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
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
    public final ITilePlacement placeTile(ITile tile, Position loc) {
        if (positionMap.containsKey(loc)) {
            throw new IllegalArgumentException("Position " + loc +
                    " already occupied by " + positionMap.get(loc));
        }
        
        ITilePlacement placement = new TilePlacement(tile, loc);
		placement.addTileListener(this);
        placementMap.put(tile, placement);
        positionMap.put(loc, placement);
        return placement;
    }
    
    @Override
    public final ITilePlacement getPlacement(Position loc) {
        return positionMap.get(loc);
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
				continue;
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
