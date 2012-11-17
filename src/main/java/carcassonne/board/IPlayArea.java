/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.board;

import carcassonne.tiles.ITile;

/**
 * Play area where tiles are placed in positions
 * @author Morgan
 */
public interface IPlayArea {

    /**
     * Find title in play area
     * @param tile tile to find
     * @return tile placement containing tile or null if tile is not
     * in play area
     */
    ITilePlacement findTile(ITile tile);

    /**
     * Get the tile placement at the specified position
     * @param position position to check
     * @return tile placement if position is within play area
     */
    ITilePlacement getPlacement(Position position);

    /**
     * Places the tile at the specified position
     * @param tile tile to place
     * @param position position to place tile
     * @return tile placement
     * @throws IllegalStateException if tile is already placed in
     * the specified position
     */
    ITilePlacement placeTile(ITile tile, Position position);

    /**
     * Removes a tile from the board
     * @param tile tile to remove
     * @return ITilePlacement placement containing the removed tile which was
     * removed from the play area or null if tile was not in the play area
     */
    ITilePlacement removeTile(ITile tile);

    /**
     * Places the start tile at the initial position
     * @param startTile tile to place at the starting position
     * @return tile placement
     * @throws IllegalStateException if the starting position already
     * contains a tile
     */
    ITilePlacement setStartTile(ITile startTile);
}
