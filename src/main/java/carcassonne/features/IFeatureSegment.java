/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.features;

import carcassonne.basic.tiles.Edge;
import java.util.List;

/**
 *
 * @author Morgan
 */
public interface IFeatureSegment {
    
    /**
     * The open edges of a feature
     * @return
     */
    List<Edge> getEdges();
    
}
