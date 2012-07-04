/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.features.basic;

import carcassonne.features.AbsSegmentedFeature;
import carcassonne.followers.Role;

/**
 *
 * @author Morgan
 */
public class Road extends AbsSegmentedFeature<RoadSegment> {

    public Road() {
        super(Role.Thieve);
    }

	@Override
	public String toString() {
		return "Road{" + '}';
	}
    
}
