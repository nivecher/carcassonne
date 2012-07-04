/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.features;

import java.util.Set;

/**
 * Segmented feature
 * @param <S> segment type
 * @author Morgan
 */
public interface ISegmentedFeature<S extends ISegment> extends IFeature {

    /**
     * Returns the number of tile segements
     *
     * @return
     */
    int getNumSegments();
	
	/**
	 * Returns a set of segments
	 * @return 
	 */
	Set<S> getSegments();

    /**
     * Returns the list of tiles that contain the segments of the feature
     * @param segment feature segment to add
	 * @return true if segment added, false otherwise
     */
    boolean addSegment(S segment);
    
	/**
	 * Adds all the segments to the feature
	 * @param segments
	 */
	void include(Set<S> segments);
}
