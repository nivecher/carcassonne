/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.features;

import carcassonne.followers.Role;

/**
 *
 * @author Morgan
 */
public class Road extends AbsSegmentedFeature {

    public Road() {
        super(Role.Thieve);
    }

    /**
     * A road is complete once both ends hit another item/feature on a tile.
     * @return true if complete, false otherwise
     */
    @Override
    public boolean isComplete() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
