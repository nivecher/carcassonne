/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.features;

import carcassonne.followers.Follower;
import java.util.List;

/**
 * Segment of a feature
 * @param <F> feature type
 * @author Morgan
 */
public interface ISegment<F extends IFeature> {
    
    /**
     * Returns the feature represented by the segment
     * @return 
     */
    F getFeature();
    
    /**
     * Returns the deployed follower on that segment
     * @return deployed follower or null
     */
    Follower getFollower();
}
