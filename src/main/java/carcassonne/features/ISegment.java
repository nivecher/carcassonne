/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.features;

import java.util.List;

import carcassonne.basic.tiles.Edge;

/**
 *
 * @author Morgan
 */
public interface ISegment extends IFeature {
    
    /**
     * The open edges of a feature
     * @return
     */
    List<Edge> getEdges();
    
}
