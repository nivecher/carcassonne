/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.expansions.inns_cathedrals;

import carcassonne.features.basic.RoadSegment;
import carcassonne.inns_cathedrals.tiles.Inn;

/**
 *
 * @author Morgan
 */
public class RoadWithInnSegment extends RoadSegment {

	private final Inn inn;

	public Inn getInn() {
		return inn;
	}
	
	public RoadWithInnSegment(Inn inn) {
		this.inn = inn;
	}
	
	@Override
	public String toString() {
		return "RoadWithInnSegment{" + '}';
	}
	
}
