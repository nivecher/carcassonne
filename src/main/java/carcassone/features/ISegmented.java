/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassone.features;

import carcassone.tiles.Tile;
import java.util.List;

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
     *
     * @param segment feature segment to add
     */
    void addSegment(ISegment<F> segment);
    
}
