/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.board;

import carcassonne.followers.Follower;
import carcassonne.tiles.ITile;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Morgan
 */
public class PlayArea implements IPlayArea {
    
    private final Map<ITile, TilePlacement> placementMap = new HashMap<>();
    private final Map<Position, TilePlacement> positionMap = new HashMap<>();
    
    public PlayArea(ITile baseTile) {
        placeTile(baseTile, Position.BASE);
    }
    
    @Override
    public final ITile placeTile(ITile tile, Position loc) {
        if (positionMap.containsKey(loc)) {
            throw new IllegalArgumentException("Position " + loc +
                    " already occupied by " + positionMap.get(loc));
        }
        
        TilePlacement placement = new TilePlacement(tile);
        placementMap.put(tile, placement);
        positionMap.put(loc, placement);
        return placement;
    }
    
    @Override
    public final ITile getTile(Position loc) {
        TilePlacement placement = positionMap.get(loc);
        if (placement != null) {
            return placement.getBaseTile();
        }
        return positionMap.get(loc);
    }
    
    @Override
    public final TilePlacement getPlacement(ITile tile) {
        return placementMap.get(tile);
    }
    
    /**
     * Finds the tile containing a certain follower
     * @param f follower to find
     * @return tile found or null if follower not found
     */
    @Override
    public ITile findTile(Follower f) {
        for (TilePlacement t : positionMap.values()) {
            if (f.equals(t.getDeployedFollower())) {
                return t;
            }
        }
        return null; // not found
    }

}
