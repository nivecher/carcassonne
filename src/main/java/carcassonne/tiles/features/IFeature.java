/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.tiles.features;

import carcassonne.followers.Follower;
import carcassonne.followers.Role;

/**
 *
 * @author Morgan
 */
public interface IFeature {
    
    void addFollower(Follower follower);
    
    void removeFollower(Follower follower);

    Role getFollowerRole();
    
    int getPoints();
    
    boolean hasFollowers();
    
    boolean isComplete();
}
