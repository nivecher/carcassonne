/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.board;

import carcassonne.followers.Follower;
import carcassonne.tiles.ITile;

/**
 *
 * @author Morgan
 */
public interface IPlayArea {

    /**
     * Finds the tile containing a certain follower
     * @param f follower to find
     * @return tile found or null if follower not found
     */
    ITile findTile(Follower f);

    TilePlacement getPlacement(ITile tile);

    ITile getTile(Position loc);

    ITile placeTile(ITile tile, Position loc);
    
}
