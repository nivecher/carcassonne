/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.expansions.inns_cathedrals;

import carcassonne.basic.tiles.Feature;
import carcassonne.features.IFeature;
import carcassonne.features.basic.CitySegment;
import carcassonne.features.basic.RoadSegment;
import carcassonne.inns_cathedrals.tiles.Cathedral;
import carcassonne.inns_cathedrals.tiles.Road;
import carcassonne.tiles.BasicTileBuilder;

/**
 *
 * @author Morgan
 */
public class ICTileBuilder extends BasicTileBuilder {

	@Override
	protected IFeature buildFeature(Feature f) {
        IFeature newFeature;
        if (f instanceof Cathedral) {
            newFeature = createCathedral((Cathedral) f);
        } else if (f instanceof Road) {
            newFeature = createRoadWithInn((Road) f);
        } else {
            newFeature = super.buildFeature(f);
        }
        return newFeature;
    }
	
	protected CitySegment createCathedral(Cathedral cathedral) {
		// TODO
		CitySegment seg = new CitySegment();
        seg.setPennants(cathedral.getPennant().size());
        addEdges(seg, cathedral);
        return seg;
    }
	
	protected RoadSegment createRoadWithInn(Road road) {
		// TODO
		RoadSegment seg = new RoadSegment();
		road.getInn();
		addEdges(seg, road);
		return seg;
	}
	
}
