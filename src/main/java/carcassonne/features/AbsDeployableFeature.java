/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.features;

import carcassonne.followers.Follower;
import carcassonne.followers.Role;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Morgan
 */
public abstract class AbsDeployableFeature implements IFeature, IFollowerDeployable {

    protected final List<Follower> followers = new ArrayList<>();
    
    private final Role followerRole;

    private int points = 0;

    
    public AbsDeployableFeature(Role followerRole) {
        this.followerRole = followerRole;
    }
    
    public List<Follower> getFollowers() {
        return new ArrayList<>(followers);
    }

    @Override
    public int getPoints() {
        return points;
    }
    
    @Override
    public void addFollower(Follower follower) {
        this.followers.add(follower);
    }
    
    @Override
    public void removeFollower(Follower follower) {
        this.followers.remove(follower);
    }
    
    @Override
    public boolean hasFollowers() {
        return !this.followers.isEmpty();
    }
    
    @Override
    public Role getFollowerRole() {
        return this.followerRole;
    }
    
    public int getNumFollowers() {
        return followers.size();
    }
    
}