/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.tiles;

import carcassonne.features.IFeature;
import carcassonne.features.ISegment;
import carcassonne.followers.Follower;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Landscape tile
 * @author Morgan
 */
public class LandscapeTile extends Tile {
    
    /**
     * Map of segments by tile position
     */
    private Map<Direction, ISegment> segmentMap = new HashMap<>();

    LandscapeTile(String id) {
        super(id);
    }

    public List<IFeature> getFeatures() {
        throw new UnsupportedOperationException();
    }
    
    public List<ISegment> getSegments() {
        return new ArrayList<>(segmentMap.values());
    }

    public ISegment getSegment(Direction loc) {
        return segmentMap.get(loc);
    }
    
    @Override
    public List<Follower> getFollowers() {
        List<Follower> followers = new ArrayList<>();
        for (ISegment segment : segmentMap.values()) {
            followers.add(segment.getFollower());
        }
        return followers; // TODO only one follower per tile?
    }
    
    void addSegment(ISegment segment) {
        addSegment(segment, Direction.Unspecified);
    }

    void addSegment(ISegment segment, Direction loc) {
        segmentMap.put(loc, segment);
    }
}
