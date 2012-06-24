/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.features;

/**
 *
 * @param <F> type of feature segments contained
 * @author Morgan
 */
public interface ISegmented<F extends IFeature> {

    /**
     * Returns the number of tile segements
     *
     * @return
     */
    int getNumSegments();

    /**
     * Returns the list of tiles that contain the segments of the feature
     * TODO ?
     * @param segment feature segment to add
     */
    void addSegment(ISegment<F> segment);
    
}
