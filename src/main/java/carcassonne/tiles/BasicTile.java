/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.tiles;

import carcassonne.basic.tiles.Edge;
import carcassonne.features.IFeature;
import carcassonne.features.IFeatureSegment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
    private final Map<Edge, IFeatureSegment> segmentMap = new HashMap<>();
    private final List<IFeature> features = new ArrayList<>();

    BasicTile(String id) {
        this.id = id;
    }

    private void mapSegment(IFeatureSegment s) {
        for (Edge e : s.getEdges()) {
            segmentMap.put(e, s);
        }
    }

    public List<IFeatureSegment> getSegments() {
        return new ArrayList<>(segmentMap.values());
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
        if (!Objects.equals(this.id, other.id)) {
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
        return new ArrayList<>(features);
    }

    void addFeature(IFeature f) {
        features.add(f);
        if (f instanceof IFeatureSegment) {
            mapSegment((IFeatureSegment) f);
        }
    }
}
