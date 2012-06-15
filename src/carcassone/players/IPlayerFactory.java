/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassone.players;

import carcassone.followers.Color;

/**
 *
 * @author Morgan
 */
public interface IPlayerFactory {
    Player createPlayer(Color color);
}
