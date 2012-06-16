/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.tiles.features;

import carcassonne.followers.Role;

/**
 * City feature containing followers that are playing the role of knights
 * @author Morgan
 */
public class City extends AbsSegmentedFeature<City> {

    public static final int POINTS_PER_PENNANT = 2; // TODO verify
    
    /**
     * Number of penants
     */
    private final int pennants;
    
    // TODO walls
    
    public City(int pennants) {
        super(Role.Knight);
        this.pennants = pennants;
    }
    
    public City() {
        this(0);
    }

    /**
     * Comlete
     * @return 
     */
    @Override
    public boolean isComplete() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Returns the number of pennants in the city
     * @return 
     */
    public int getPennantCount() {
        return pennants;
    }
    
}
