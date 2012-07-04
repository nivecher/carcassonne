/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.tiles;

import carcassonne.basic.tiles.Edge;
import carcassonne.features.IFeature;
import carcassonne.features.ISegment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Landscape tile
 *
 * @author Morgan
 */
public class BasicTile implements ITile {

    private final String id;
    
    /**
     * Map of segments by tile position
     */
    private final Map<Edge, ISegment> edgeMap = new HashMap<>();
    private final List<IFeature> features = new ArrayList<>();

    BasicTile(String id) {
        this.id = id;
    }

    private void mapSegment(ISegment s) {
        for (Edge e : s.getEdges()) {
            edgeMap.put(e, s);
        }
    }

	@Override
    public List<ISegment> getSegments() {
        return new ArrayList<>(edgeMap.values());
    }

    @Override
    public String getId() {
        return id;
    }

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final BasicTile other = (BasicTile) obj;
		return true;
	}

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public List<IFeature> getFeatures() {
        return new ArrayList<>(features);
    }

    @Override
    public ISegment getFeature(Edge e) {
        return edgeMap.get(e);
    }
    
    void addFeature(IFeature f) {
        features.add(f);
        if (f instanceof ISegment) {
            mapSegment((ISegment) f);
        }
    }

    @Override
    public String toString() {
        return "BasicTile{" + "id=" + id + '}';
    }

}
