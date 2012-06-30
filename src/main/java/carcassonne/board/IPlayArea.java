/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.board;

import carcassonne.tiles.ITile;

/**
 *
 * @author Morgan
 */
public interface IPlayArea {

    ITilePlacement findTile(ITile tile);

    ITilePlacement getPlacement(Position loc);

    ITilePlacement placeTile(ITile tile, Position loc);

    ITilePlacement setStartTile(ITile startTile);
}
