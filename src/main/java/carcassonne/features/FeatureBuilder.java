/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.features;

import carcassonne.basic.tiles.Edge;
import carcassonne.board.IPlayArea;
import carcassonne.board.ITilePlacement;
import carcassonne.features.basic.City;
import carcassonne.features.basic.CitySegment;
import carcassonne.features.basic.Field;
import carcassonne.features.basic.FieldSegment;
import carcassonne.features.basic.Road;
import carcassonne.features.basic.RoadSegment;
import carcassonne.tiles.EdgeUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Morgan
 */
public class FeatureBuilder {

	// TODO use playArea?
	private final IPlayArea playArea;
	// TODO inject
	private final EdgeUtils edgeUtils = new EdgeUtils();

	public FeatureBuilder(IPlayArea playArea) {
		this.playArea = playArea;
	}

	@SuppressWarnings("unchecked")
	public List<IFeature> buildFeatures(ITilePlacement placement) {
		List<IFeature> features = new ArrayList<>();

		for (ISegment seg : placement.getSegments()) {
			ISegmentedFeature feature = createFeature(seg);
			// add connected segments to feature
			Set<ISegment> segments = new HashSet<>();
			feature.include(addConnected(placement, segments, seg));
			features.add(feature);
		}

		return features;
	}

	/**
	 * Returns the segments connected to the feature
	 * @param placement
	 * @param seg
	 * @return 
	 */
	@SuppressWarnings("unchecked")
	private Set<ISegment> addConnected(ITilePlacement placement,
		Set<ISegment> segments,	ISegment seg) {
		
		segments.add(seg); // add this segment then add connected
		
		// Process each edge of the segment
		for (Edge e : seg.getEdges()) {
			ITilePlacement connectedTile = placement.getConnectedTile(e);
			if (connectedTile != null) {
				Edge relEdge = edgeUtils.getOpposite(e);
				ISegment connectedSeg = connectedTile.getTile().getFeature(relEdge);
				if (!segments.contains(connectedSeg)) {
					segments.addAll(addConnected(connectedTile, segments,
							connectedSeg));
				}
			} else {
				// TODO open feature
			}
		}
		return segments;
	}

	@SuppressWarnings("unchecked")
	private ISegmentedFeature createFeature(ISegment seg) {
		ISegmentedFeature feature;
		if (seg instanceof CitySegment) {
			feature = new City();
		} else if (seg instanceof FieldSegment) {
			feature = new Field();
		} else if (seg instanceof RoadSegment) {
			feature = new Road();
		} else {
			throw new UnsupportedOperationException(
					"Feature segment not supported: " + seg);
		}
		feature.addSegment(seg);
		return feature;
	}
}
