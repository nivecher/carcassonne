/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.tiles.features;

import carcassonne.followers.Role;

/**
 *
 * @author Morgan
 */
public class Field extends AbsSegmentedFeature<Field> {

    public Field() {
        super(Role.Farmer);
    }

    /**
     * Returns whether the field is completely shut off from adding new
     * segments
     * @return true if complete, false otherwise
     */
    @Override
    public boolean isComplete() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
