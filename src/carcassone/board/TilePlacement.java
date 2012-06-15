/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassone.board;

import carcassone.followers.Follower;
import carcassone.tiles.ITile;
import carcassone.tiles.ITile.Edge;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Decorator around a tile that gives it a placement relative to other tiles.
 * @author Morgan
 */
public class TilePlacement implements ITile {
    
    private final ITile baseTile;

    public ITile getBaseTile() {
        return baseTile;
    }
    private final Map<Edge, ITile> edgeMap = new HashMap<>();
    
    public TilePlacement (ITile baseTile) {
        this.baseTile = baseTile;
        // TODO add "self"?
//        this.tileMap.put(Edge.Unspecified, centerTile);
    }
    
    /**
     * Adds a tile next to the current tile position based on the specified
     * direction
     * @param tile
     * @param edge 
     */
    public void addTile(ITile tile, Edge edge) {
        if (edgeMap.containsKey(edge)) {
            throw new IllegalStateException(edge + " edge occupied! - " + 
                    edgeMap.get(edge));
        }
        edgeMap.put(edge, tile);
    }
    
    /**
     * Returns the tile next to this tile on the specified edge
     * @param edge
     * @return 
     */
    public ITile getTile(Edge edge) {
        return edgeMap.get(edge);
    }
    
    /**
     * TODO can NW, NE, SW, SE be figured out?  See "o" below:
     * 
     *   x x x x
     *   x o   x
     *       o x
     * 
     * @param direction
     * @return 
     */
    public ITile getTile(Direction direction) {
        switch (direction) {
            case N:
                return getTile(Edge.Top);
            case E:
                return getTile(Edge.Right);
            case S:
                return getTile(Edge.Bottom);
            case W:
                return getTile(Edge.Left);
            default:
                throw new IllegalArgumentException("Invalid direction: " +
                        direction);
        }
    }

    @Override
    public List<Follower> getFollowers() {
        return baseTile.getFollowers();
    }

    @Override
    public String getId() {
        return baseTile.getId();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TilePlacement other = (TilePlacement) obj;
        if (!Objects.equals(this.baseTile, other.baseTile)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }
    
    
}
