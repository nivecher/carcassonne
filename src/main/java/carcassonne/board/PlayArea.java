/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.board;

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
        
        ITilePlacement placement = new TilePlacement(tile, loc);
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

}
