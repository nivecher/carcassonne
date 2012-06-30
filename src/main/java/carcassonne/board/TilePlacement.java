/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.board;

import carcassonne.basic.tiles.Edge;
import carcassonne.features.IFeature;
import carcassonne.features.IFeatureSegment;
import carcassonne.followers.Follower;
import carcassonne.tiles.EdgeUtils;
import carcassonne.tiles.ITile;
import java.util.*;

/**
 * Decorator around a tile that gives it a placement relative to other tiles.
 * @author Morgan
 */
public class TilePlacement implements ITilePlacement {
    
    private final ITile tile;
    private final Position position;

    @Override
    public ITile getTile() {
        return tile;
    }
    private final Map<Edge, ITilePlacement> edgeMap = new HashMap<>();
    
    private final EdgeUtils edgeUtils = new EdgeUtils(); // TODO inject
    
    /**
     * Construct a new tile placement
     * @param tile 
     * @param position
     */
    public TilePlacement (ITile tile, Position position) {
        this.tile = tile;
        this.position = position;
    }
    
    /**
     * Deployed follower
     */
    private Follower deployedFollower;
    
    /**
     * Adds a tile next to the current tile position based on the specified
     * direction
     * @param newTile
     * @param edge 
     */
    @Override
    public ITilePlacement addTile(ITile newTile, Edge edge) {
        if (edgeMap.containsKey(edge)) {
            throw new IllegalStateException(edge + " edge of tile '" + getId() + 
                    "' occupied! - " + edgeMap.get(edge));
        }
        Position newPos = edgeUtils.relativePosition(position, edge);
        ITilePlacement placement = new TilePlacement(newTile, newPos);
        edgeMap.put(edge, placement);
        return placement;
    }
    
    /**
     * A tile can be added if the edge is vacant and the edge features are
     * compatible
     * @param newTile
     * @param edge
     * @return true if the new tile can be added, false otherwise
     */
    @Override
    public boolean canAddTile(ITile newTile, Edge edge) {
        if (edgeMap.containsKey(edge)) {
            return false; // occupied
        }
        IFeatureSegment edgeFeature = tile.getFeature(edge);
        IFeatureSegment newFeature = newTile.getFeature(edgeUtils.getOpposite(edge));
        return edgeFeature.getClass().equals(newFeature.getClass());
    }
    
    /**
     * Returns the tile next to this tile on the specified edge
     * @param edge
     * @return 
     */
    @Override
    public ITilePlacement getAdjacentTile(Edge edge) {
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
    public Position getPosition() {
        return position;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public IFeatureSegment getFeature(Edge e) {
        return tile.getFeature(e);
    }
    
    @Override
    public List<IFeature> getFeatures() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String toString() {
        return "TilePlacement{" + "tile=" + tile + '}';
    }
    
}
