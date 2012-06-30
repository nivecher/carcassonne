/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.features;

import carcassonne.basic.tiles.Edge;
import carcassonne.followers.Role;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Morgan
 */
public abstract class AbsFeatureSegment extends AbsDeployableFeature {
    
    private final List<Edge> edges = new ArrayList<>();
    
    protected AbsFeatureSegment(Role role) {
        super(role);
    }
    
    @Override
    public boolean isComplete() {
        return false; // partial by definition
    }
    
    public List<Edge> getEdges() {
        return new ArrayList<>(edges);
    }
    
    public void addEdge(Edge e) {
        edges.add(e);
    }
}
