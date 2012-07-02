/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.tiles;

import carcassonne.basic.tiles.Edge;
import java.util.List;

import carcassonne.features.IFeature;
import carcassonne.features.IFeatureSegment;

/**
 *
 * @author Morgan
 */
public interface ITile {
    
    String getId();
    
    List<IFeature> getFeatures();

    IFeatureSegment getFeature(Edge edge);
	
	List<IFeatureSegment> getSegments();
}
