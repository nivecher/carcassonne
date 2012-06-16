/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassone.followers;

import carcassone.features.IFeature;
import carcassone.followers.Role;

/**
 * Playing piece that is placed on features within tiles
 * @author Morgan
 */
public class Follower {
    
    /**
     * Follower's color
     */
    private final Color color;
    
    /**
     * The follower's "value" within a feature.  Default is
     * one "follower"
     */
    private final int value = 1;
    
    /**
     * Currently deployed role (if any)
     */
    private Role role;
    
    /**
     * Create a follower
     * @param color follower's color
     */
    public Follower(final Color color) {
        this.color = color;
    }
    
    public Color getColor() {
        return this.color;
    }
    
    /**
     * Return the follower's currently deployed role (if any)
     * @return role or null if not currently deployed
     */
    public Role getRole() {
        return role;
    }
    
    public void deploy(IFeature feature) {
        
        if (this.role != null) {
            throw new IllegalStateException("Follower already deployed as role: " +
                    this.role);
        }
        this.role = feature.getFollowerRole();
    }
}
