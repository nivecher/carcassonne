/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.board;

import java.util.*;

import carcassonne.basic.tiles.Edge;
import carcassonne.features.IFeature;
import carcassonne.features.ISegment;
import carcassonne.followers.Follower;
import carcassonne.tiles.EdgeUtils;
import carcassonne.tiles.ITile;

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
    
    private final EdgeUtils edgeUtils = new EdgeUtils(); // TODO inject EdgeUtils
	
	private final List<ITilePlacementListener> listeners = new ArrayList<>();
    
    /**
     * Construct a new tile placement
     * @param tile tile to place
     * @param position placement's position
     */
    public TilePlacement (ITile tile, Position position) {
        this.tile = tile;
        this.position = position;
    }
    
    /**
     * Creates a tile placement next to this placement at the specified edge
     * @param newTile tile to add next to this tile placement
     * @param edge direction to add new tile
     * @return tile placement of new tile
     */
    @Override
    public ITilePlacement connectTile(ITile newTile, Edge edge) {
        if (edgeMap.containsKey(edge)) {
            throw new IllegalStateException(edge + " edge of tile '" + tile.getId() + 
                    "' occupied! - " + edgeMap.get(edge));
        }
        Position newPos = EdgeUtils.relativePosition(position, edge);
        TilePlacement placement = new TilePlacement(newTile, newPos);
        edgeMap.put(edge, placement);
        
        Edge opposite = edgeUtils.getOpposite(edge);
        placement.edgeMap.put(opposite, this); // link opposite edge
        
		fireTilePlaced(placement);
		
        return placement;
    }
    
    /**
     * A tile can be linked if the edge is vacant and the edge features are
     * compatible
     * @param newTile
     * @param edge
     * @return true if the new tile can be linked, false otherwise
     */
    @Override
    public boolean canConnectTile(ITile newTile, Edge edge) {
        if (edgeMap.containsKey(edge)) {
            return false; // edge occupied
        }
        ISegment edgeFeature = tile.getFeature(edge);
        // TODO handle multiple features per edge
        ISegment newFeature = newTile.getFeature(edgeUtils.getOpposite(edge));
        // TODO Verify edge segments
        return edgeFeature.getClass().isAssignableFrom(newFeature.getClass());
    }
    
    /**
     * Returns the tile next to this tile on the specified edge
     * @param edge
     * @return 
     */
    @Override
    public ITilePlacement getConnectedTile(Edge edge) {
        return edgeMap.get(edge);
    }
    
    @Override
    public void deployFollower(Follower follower, IFeature feature) {
        if (!tile.getFeatures().contains(feature)) {
            throw new IllegalArgumentException("Feature not on tile: " + feature);
        }
        feature.addFollower(follower);
    }
    
    @Override
    public List<ISegment> getSegments() {
        List<ISegment> segs = new ArrayList<>();
        for (IFeature f : tile.getFeatures()) {
			if (f instanceof ISegment) {
				segs.add((ISegment) f);
			}
        }
        return segs;
    }
	
    @Override
    public List<IFeature> getDeployedFeatures() {
        List<IFeature> deployed = new ArrayList<>();
        for (IFeature f : tile.getFeatures()) {
            if (f.hasFollowers()) {
               deployed.add(f);
            }
        }
        return deployed;
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
    public ISegment getFeature(Edge e) {
        return tile.getFeature(e);
    }
    
    @Override
    public List<IFeature> getFeatures() {
        return tile.getFeatures();
    }

    @Override
    public String toString() {
        return "TilePlacement{" + "tile=" + tile + '}';
    }

	@Override
	public void addTileListener(ITilePlacementListener listener) {
		listeners.add(listener);
	}

	@Override
	public void removeTileListener(ITilePlacementListener listener) {
		listeners.remove(listener);
	}
	
	private void fireTilePlaced(ITilePlacement placement) {
		for (ITilePlacementListener l : listeners) {
			l.tilePlaced(placement);
		}
	}

	@Override
	public String getId() {
		return tile.getId();
	}

}
