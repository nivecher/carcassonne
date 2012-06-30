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
    ITilePlacement findTile(Follower f);

    ITilePlacement getPlacement(ITile tile);

    ITilePlacement getTile(Position loc);

    ITilePlacement placeTile(ITile tile, Position loc);

    ITilePlacement setStartTile(ITile startTile);
}
