/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.features;

import carcassonne.followers.Follower;
import carcassonne.followers.Role;

/**
 *
 * @author Morgan
 */
public interface IFollowerDeployable {

    void addFollower(Follower follower);

    void removeFollower(Follower follower);

    Role getFollowerRole();

    boolean hasFollowers();

}
