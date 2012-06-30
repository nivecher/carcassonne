/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.board;

import carcassonne.basic.tiles.Edge;
import carcassonne.followers.Follower;
import carcassonne.tiles.ITile;

/**
 *
 * @author Morgan
 */
public interface ITilePlacement {

    /**
     * Adds a tile next to the current tile position based on the specified
     * direction
     * @param tile
     * @param edge
     * @return new tile placement 
     */
    ITilePlacement addTile(ITile tile, Edge edge);

    ITile getTile();

    Follower getDeployedFollower();

    /**
     * Returns the tile next to this tile on the specified edge
     * @param edge
     * @return
     */
    ITilePlacement getTile(Edge edge);
    
}
