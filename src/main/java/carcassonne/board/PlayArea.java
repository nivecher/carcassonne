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
        
        ITilePlacement placement = new TilePlacement(tile);
        placementMap.put(tile, placement);
        positionMap.put(loc, placement);
        return placement;
    }
    
    @Override
    public final ITilePlacement getTile(Position loc) {
        return positionMap.get(loc);
    }
    
    @Override
    public final ITilePlacement getPlacement(ITile tile) {
        return placementMap.get(tile);
    }
    
    /**
     * Finds the tile containing a certain follower
     * @param f follower to find
     * @return tile found or null if follower not found
     */
    @Override
    public ITilePlacement findTile(Follower f) {
        for (ITilePlacement t : positionMap.values()) {
            if (f.equals(t.getDeployedFollower())) {
                return t;
            }
        }
        return null; // not found
    }

}
