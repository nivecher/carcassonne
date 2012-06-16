/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassone.players;

import carcassone.followers.Color;
import carcassone.followers.Follower;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Morgan
 */
public class PlayerFactory implements IPlayerFactory {
    
    /**
     * Default number of followers per player (8 - 1 for scoring = 7)
     */
    public static final int DEFAULT_NUM_FOLLOWERS = 7;

    /**
     * Creates a player of the specified color with the default number of 
     * followers
     * @param color player's color
     * @return 
     */
    @Override
    public Player createPlayer(Color color) {
        List<Follower> followers = new ArrayList<>(DEFAULT_NUM_FOLLOWERS);
        for (int i = 0; i < DEFAULT_NUM_FOLLOWERS; i++) {
            followers.add(new Follower(color));
        }
        return new Player(color, followers);
    }
    
}
