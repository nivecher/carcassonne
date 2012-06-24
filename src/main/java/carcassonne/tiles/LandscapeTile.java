/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.tiles;

import carcassonne.basic.tiles.Edge;
import carcassonne.basic.tiles.Feature;
import carcassonne.basic.tiles.Segment;
import carcassonne.basic.tiles.Tile;
import carcassonne.tiles.features.IFeature;
import carcassonne.tiles.features.ISegment;
import carcassonne.followers.Follower;
import carcassonne.tiles.ITile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.xml.bind.JAXBElement;

/**
 * Landscape tile
 *
 * @author Morgan
 */
public class LandscapeTile implements ITile {

	private final Tile basicTile;
	
	/**
	 * Map of segments by tile position
	 */
	private final Map<Edge, ISegment> segmentMap = new HashMap<>();
	
	private final List<IFeature> features = new ArrayList<>();
	private final List<javax.swing.text.Segment> segments = new ArrayList<>();
	/**
	 * AbsTile identifier
	 */
	private final String id;

	LandscapeTile(Tile basicTile) {
		super(basicTile.getId());
		this.basicTile = basicTile;
		
		processFeatures();
	}
	
	private void processFeatures() {
		List<JAXBElement<? extends Feature>> tileFeatures = basicTile.getFeature();
			for (int i = 0; i < tileFeatures.size(); i++) {
				Feature f = tileFeatures.get(i).getValue();
				if (f instanceof Segment) {
					mapSegment((Segment) f);
				} else {
//					tileFeatures.add(new LandscapeFeature(f)); TODO
				}
			}
	}
	
	private void mapSegment(Segment s) {
		for (Edge e : s.getEdge()) {
//			segmentMap.put(e, new FeatureSegment(s)); TODO
		}
	}

	public List<ISegment> getSegments() {
		return new ArrayList<>(segmentMap.values());
	}

	public ISegment getSegment(Direction loc) {
		return segmentMap.get(loc);
	}

	public void placeFollower(Follower f, ISegment seg) {
		throw new UnsupportedOperationException("Not implemented");
	}
	
	@Override
	public List<Follower> getFollowers() {
		List<Follower> followers = new ArrayList<>();
		for (ISegment segment : segmentMap.values()) {
			followers.add(segment.getFollower());
		}
		return followers; // TODO only one follower per tile?
	}

	void addSegment(ISegment segment) {
		addSegment(segment, Direction.Unspecified);
	}

	void addSegment(ISegment segment, Direction loc) {
		segmentMap.put(loc, segment);
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final AbsTile other = (AbsTile) obj;
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		return hash;
	}

	@Override
	public List<Follower> getFollowers() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public List<IFeature> getFeatures() {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
}
