/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassone.board;

import carcassone.followers.Follower;
import carcassone.tiles.ITile;
import carcassone.tiles.ITile.Direction;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Morgan
 */
public class PlayArea {
    
    private final Map<ITile, TilePlacement> placementMap = new HashMap<>();
    private final Map<Position, TilePlacement> positionMap = new HashMap<>();
    
    public PlayArea(ITile baseTile) {
        placeTile(baseTile, Position.BASE);
    }
    
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
    
    public final ITile getTile(Position loc) {
        TilePlacement placement = positionMap.get(loc);
        if (placement != null) {
            return placement.getBaseTile();
        }
        return positionMap.get(loc);
    }
    
    public final TilePlacement getPlacement(ITile tile) {
        return placementMap.get(tile);
    }
    
    /**
     * Finds the tile containing a certain follower
     * @param f follower to find
     * @return tile found or null if follower not found
     */
    public ITile findTile(Follower f) {
        for (ITile t : positionMap.values()) {
            if (t.getFollowers().contains(f)) {
                return t;
            }
        }
        return null; // not found
    }
    
    // TODO use this
    private Position getRelativePosition(Position pos, Direction dir) {
        return pos.getRelative(dir.relativePosition());
    }
}
