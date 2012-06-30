/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.features.basic;

import carcassonne.features.AbsFeatureSegment;
import carcassonne.features.IFeatureSegment;
import carcassonne.followers.Role;

/**
 *
 * @author Morgan
 */
public class CitySegment extends AbsFeatureSegment implements IFeatureSegment {

    private int pennants = 0;
    
    public CitySegment() {
        super(Role.Knight);
    }
    
    public void setPennants(int pennants) {
        this.pennants = pennants;
    }
    
    public int getPennatns() {
        return pennants;
    }
}
