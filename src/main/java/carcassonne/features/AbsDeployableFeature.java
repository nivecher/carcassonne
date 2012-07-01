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
        
        if (follower.getRole() != null) {
            throw new IllegalStateException("Follower already deployed as role: " +
                    follower.getRole());
        }
        this.followers.add(follower);
        follower.setRole(followerRole);
    }
    
    @Override
    public void removeFollower(Follower follower) {
        if (!this.followers.contains(follower)) {
            throw new IllegalArgumentException("Unknown follower: " + follower);
        }
        follower.setRole(null);
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