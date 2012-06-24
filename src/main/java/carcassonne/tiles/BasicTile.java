/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.tiles;

import carcassonne.basic.tiles.Edge;
import carcassonne.basic.tiles.Feature;
import carcassonne.basic.tiles.Segment;
import carcassonne.basic.tiles.Tile;
import carcassonne.features.IFeature;
import carcassonne.features.ISegment;
import carcassonne.followers.Follower;
import carcassonne.tiles.ITile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.xml.bind.JAXBElement;

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
    private final Map<Edge, ISegment> segmentMap = new HashMap<>();
    private final List<IFeature> features = new ArrayList<>();
    private final List<javax.swing.text.Segment> segments = new ArrayList<>();

    BasicTile(String id) {
        this.id = id;
    }

    private void mapSegment(Segment s) {
        for (Edge e : s.getEdge()) {
//			segmentMap.put(e, new FeatureSegment(s)); TODO
        }
    }

    public List<ISegment> getSegments() {
        return new ArrayList<>(segmentMap.values());
    }

    public void placeFollower(Follower f, ISegment seg) {
        throw new UnsupportedOperationException("Not implemented");
    }

    // TODO move this
    public List<Follower> getFollowers() {
        List<Follower> followers = new ArrayList<>();
        for (ISegment segment : segmentMap.values()) {
            followers.add(segment.getFollower());
        }
        return followers; // TODO only one follower per tile?
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

    void addFeature(Feature f) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
