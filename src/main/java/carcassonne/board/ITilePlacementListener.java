/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.board;

/**
 *
 * @author Morgan
 */
public interface ITilePlacementListener {
	void tilePlaced(ITilePlacement tile);
	
	// TODO allow tiles to be removed?
//	void tileRemoved(ITilePlacement tile);
}
