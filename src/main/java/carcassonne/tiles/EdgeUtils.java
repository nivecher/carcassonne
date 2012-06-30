/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.tiles;

import carcassonne.basic.tiles.Edge;
import static carcassonne.basic.tiles.Edge.*;
import carcassonne.basic.tiles.EdgeSegment;
import static carcassonne.basic.tiles.EdgeSegment.*;
import carcassonne.features.IFeature;
import carcassonne.features.IFeatureSegment;
import java.util.EnumMap;
import java.util.EnumSet;

/**
 *
 * @author Morgan
 */
public class EdgeUtils {

    private final EnumMap<Edge, EnumSet<EdgeSegment>> segmentMap = 
            new EnumMap<>(Edge.class);

    public EdgeUtils () {
        buildSegmentMap();
    }
    
    private void buildSegmentMap() {
        segmentMap.put(NORTH, EnumSet.of(NORTH_EAST, NORTH_WEST));
        segmentMap.put(EAST, EnumSet.of(EAST_NORTH, EAST_SOUTH));
        segmentMap.put(SOUTH, EnumSet.of(SOUTH_EAST, SOUTH_WEST));
        segmentMap.put(WEST, EnumSet.of(WEST_NORTH, WEST_SOUTH));
    }
    
    /**
     * Returns the partial segments that make up an edge
     * @param edge
     * @return 
     */
    public EnumSet<EdgeSegment> getSegments(Edge edge) {
        return segmentMap.get(edge);
    }
    
    public void validateEdges(ITile t) {
        EnumMap<Edge, IFeature> edgeMap = new EnumMap<>(Edge.class);
        for (IFeature f : t.getFeatures()) {
            if (f instanceof IFeatureSegment) {
                IFeatureSegment seg = (IFeatureSegment) f;
                for (Edge e : seg.getEdges()) {
                    if (edgeMap.containsKey(e)) {
                        throw new RuntimeException("Tile '" + t.getId() + "' " +
                                e + " edge already populated by: " + seg);
                    }
                    edgeMap.put(e, f);
                }
            }
        }
        
        for (Edge e : Edge.values()) {
            if (!edgeMap.containsKey(e)) {
                throw new RuntimeException("Tile '" + t.getId() + "' " + e + 
                        " edge not populated");
            }
        }
    }
    
    public Edge getOpposite(Edge e) {
        switch (e) {
            case NORTH:
                return SOUTH;
            case EAST:
                return WEST;
            case SOUTH:
                return NORTH;
            case WEST:
                return EAST;
            default:
                throw new IllegalArgumentException("Invalid edge: " + e);
        }
    }
}
