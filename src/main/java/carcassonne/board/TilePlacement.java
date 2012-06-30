/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.board;

import carcassonne.basic.tiles.Edge;
import carcassonne.features.IFeature;
import carcassonne.followers.Follower;
import carcassonne.tiles.ITile;
import java.util.*;

/**
 * Decorator around a tile that gives it a placement relative to other tiles.
 * @author Morgan
 */
public class TilePlacement implements ITile, ITilePlacement {
    
    private final ITile tile;

    @Override
    public ITile getBaseTile() {
        return tile;
    }
    private final Map<Edge, ITile> edgeMap = new HashMap<>();
    
    /**
     * Deployed follower
     */
    private Follower deployedFollower;
    
    public TilePlacement (ITile tile) {
        this.tile = tile;
        // TODO add "self"?
//        this.tileMap.put(Edge.Unspecified, centerTile);
    }
    
    /**
     * Adds a tile next to the current tile position based on the specified
     * direction
     * @param tile
     * @param edge 
     */
    @Override
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
    @Override
    public ITile getTile(Edge edge) {
        return edgeMap.get(edge);
    }
    
    @Override
    public Follower getDeployedFollower() {
        return deployedFollower;
    }

    @Override
    public String getId() {
        return tile.getId();
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
        if (!Objects.equals(this.tile, other.tile)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public List<IFeature> getFeatures() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}
