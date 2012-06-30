/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.features.basic;

import carcassonne.features.AbsSegmentedFeature;
import carcassonne.followers.Role;

/**
 * City feature containing followers that are playing the role of knights
 * @author Morgan
 */
public class City extends AbsSegmentedFeature<CitySegment> {
    
    /**
     * Number of penants
     */
    private int pennants;
    
    // TODO walls
    
    public City() {
        super(Role.Knight);
    }
    
}
