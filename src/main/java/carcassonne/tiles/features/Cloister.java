/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.tiles.features;

import carcassonne.followers.Role;
import carcassonne.tiles.Tile;

/**
 *
 * @author Morgan
 */
public class Cloister extends AbsFeature {
    
    // TODO use tile group/position?
    private final Tile centerTile;
    
    public Cloister(Tile centerTile) {
        super(Role.Monk);
        this.centerTile = centerTile;
    }

    /**
     * Returns whether the cloister is completely surrounded by tiles
     * @return true if complete, false otherwise
     */
    @Override
    public boolean isComplete() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
