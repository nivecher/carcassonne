/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassone.players;

import carcassone.features.IFeature;
import carcassone.followers.Color;
import carcassone.followers.Follower;
import java.util.List;

/**
 *
 * @author Morgan
 */
public interface IPlayer {

    /**
     * Adds points to the player's score
     * @param points
     * @return score after points have been added
     */
    int addPoints(int points);

    void deployFollower(IFeature feature);

    Color getColor();

    List<Follower> getFollowers();

    /**
     * Returns the player's current score
     * @return
     */
    int getScore();

    /**
     * Resets the player's score to zero
     */
    void resetScore();

    void setColor(Color color);

    void returnFollowers(Follower... followers);
    
}
