/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.features;

/**
 * Segmented feature
 * @param <S> segment type
 * @author Morgan
 */
public interface ISegmented<S extends IFeatureSegment> {

    /**
     * Returns the number of tile segements
     *
     * @return
     */
    int getNumSegments();

    /**
     * Returns the list of tiles that contain the segments of the feature
     * @param segment feature segment to add
     */
    void addSegment(S segment);
    
}
