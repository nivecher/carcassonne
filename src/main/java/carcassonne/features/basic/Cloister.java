/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.features.basic;

import carcassonne.features.AbsDeployableFeature;
import carcassonne.followers.Role;

/**
 *
 * @author Morgan
 */
public class Cloister extends AbsDeployableFeature {
    
    public Cloister() {
        super(Role.Monk);
    }

    /**
     * Returns whether the cloister is completely surrounded by tiles
     * @return true if complete, false otherwise
     */
    @Override
    public boolean isComplete() {
        // TODO determine if tile is surrounded
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
