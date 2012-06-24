/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.players;

import carcassonne.followers.Color;

/**
 *
 * @author Morgan
 */
public interface IPlayerFactory {
    Player createPlayer(Color color);
}
