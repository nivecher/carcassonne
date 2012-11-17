package carcassonne.features;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import carcassonne.basic.tiles.Edge;
import carcassonne.followers.Role;

/**
 * Segment contained on a single tile of a feature that spans one or more tiles.
 * Segments are joined at the "open" edges to define a contiguous feature.
 * @author Morgan
 */
public abstract class AbsFeatureSegment extends AbsDeployableFeature {

    /**
     * Tile edges touched by the feature
     */
    private final Set<Edge> edges = new HashSet<>();

    protected AbsFeatureSegment(Role role) {
        super(role);
    }

    /**
     * Complete if no edges are exposed and feature is fully contain
     * within the tile boundary
     * @return true if complete, false otherwise
     * TODO move complete logic to feature?
     */
    @Override
    public boolean isComplete() {
        return edges.isEmpty();
    }

    /**
     * Return edges of the tile touched by the feature.  If a feature only
     * touches an <code>EdgeSegment</code>, the corresponding edge(s) touched
     * by the <code>EdgeSegment</code> are returned
     * @return list of tile edges touched by the feature
     */
    public List<Edge> getEdges() {
        return new ArrayList<>(edges);
    }

    /**
     * TODO add edges during construction?
     * @param e edge to add
     */
    public void addEdge(Edge e) {
        edges.add(e);
    }
}
