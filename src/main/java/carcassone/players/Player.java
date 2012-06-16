/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassone.players;

import carcassone.features.IFeature;
import carcassone.followers.Color;
import carcassone.followers.Follower;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Carcassone player
 * @author Morgan
 */
public class Player implements IPlayer {
    
    /**
     * Player's color
     */
    private Color color;
    
    /**
     * Player's score
     */
    private int score;

    /**
     * Player's supply of followers
     */
    private final List<Follower> supply;
    
    /**
     * Construct a new player
     * @param color
     * @param supply initial supply of followers 
     */
    public Player(Color color, List<Follower> supply) {
        this.color = color;
        this.supply = supply;
    }
    
    @Override
    public Color getColor() {
        return this.color;
    }
    
    @Override
    public void setColor(Color color) {
        this.color = color;
    }
    
    /**
     * Returns the player's current score
     * @return 
     */
    @Override
    public int getScore() {
        return score;
    }
    
    /**
     * Adds points to the player's score
     * @param points
     * @return score after points have been added
     */
    @Override
    public int addPoints(int points) {
        this.score += points;
        return this.score;
    }

    /**
     * Resets the player's score to zero
     */
    @Override
    public void resetScore() {
        this.score = 0;
    }
    
    @Override
    public List<Follower> getFollowers() {
        return new ArrayList<>(supply);
    }
    
    /**
     * Remove a follower from the player's supply and add it to the feature
     * @param feature feature accepting new followers
     */
    @Override
    public void deployFollower(IFeature feature) {
        Follower f = supply.remove(0);
        feature.addFollower(f);
    }
    
    /**
     * Return the follower(s) to the player's supply
     * @param followers returning followers
     */
    @Override
    public void returnFollowers(Follower... followers) {
        supply.addAll(Arrays.asList(followers));
    }
    
    @Override
    public String toString() {
        return this.color.toString();
    }
}
