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
public interface IFollowerPlaceable {

	void addFollower(Follower follower);

	Role getFollowerRole();

	boolean hasFollowers();

	void removeFollower(Follower follower);
	
}
