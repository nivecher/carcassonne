/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.followers;

import carcassonne.board.Position;

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
     * Follower's deployed position
     */
    private Position position = null;
    
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
    
    /**
     * Sets or clears the follower's role
     * @param role 
     */
    public void setRole(Role role) {
        this.role = role;
    }

    public Position getPosition() {
        return this.position;
    }

    public  void setPosition(Position position) {
        this.position = position;
    }
}
