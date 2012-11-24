/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.expansions.inns_cathedrals;

import carcassonne.basic.tiles.Feature;
import carcassonne.features.IFeature;
import carcassonne.inns_cathedrals.tiles.Cathedral;
import carcassonne.inns_cathedrals.tiles.RoadWithInn;
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
        } else if (f instanceof RoadWithInn) {
            newFeature = createRoadWithInn((RoadWithInn) f);
        } else {
            newFeature = super.buildFeature(f);
        }
        return newFeature;
    }
	
	protected carcassonne.expansions.inns_cathedrals.Cathedral createCathedral(Cathedral cathedral) {
		carcassonne.expansions.inns_cathedrals.Cathedral seg = 
				new carcassonne.expansions.inns_cathedrals.Cathedral();
        seg.setPennants(cathedral.getPennant().size());
        addEdges(seg, cathedral);
        return seg;
    }
	
	protected RoadWithInnSegment createRoadWithInn(RoadWithInn road) {
		RoadWithInnSegment seg = new RoadWithInnSegment(road.getInn());
		addEdges(seg, road);
		return seg;
	}
	
}
