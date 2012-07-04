/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.features;

import carcassonne.followers.Follower;
import carcassonne.followers.Role;
import java.util.HashSet;
import java.util.Set;

/**
 * Feature that is made up of multiple segments
 *
 * @param <S> segment type
 * @author Morgan
 */
public abstract class AbsSegmentedFeature<S extends ISegment>
        extends AbsDeployableFeature
        implements ISegmentedFeature<S> {

    private final Set<S> segments = new HashSet<>();

    public AbsSegmentedFeature(Role followerRole) {
        super(followerRole);
    }

    public int getPoints(int pointsPerSegment) {
        return getNumSegments() * pointsPerSegment;
    }

    @Override
    public boolean addSegment(S segment) {
		return segments.add(segment);
        // TODO add followers
//        Follower newFollower = segment.getFollower();
//        if (newFollower != null) {
//            if (canAddFollower(newFollower)) {
//                addFollower(newFollower);
//            } else {
//                throw new RuntimeException("Cannot add follower "
//                        + newFollower + " to " + this.toString());
//            }
//        }
    }

    /**
     * Returns whether a follower
     *
     * @param follower
     * @return
     */
    public boolean canAddFollower(Follower follower) {
        return followers.isEmpty()
                && getFollowerRole().equals(follower.getRole());
    }

    @Override
    public int getNumSegments() {
        return segments.size();
    }
	
	@Override
	public Set<S> getSegments() {
		return new HashSet<>(segments);
	}

	@Override
	public void include(Set<S> segments) {
		for (S seg : segments) {
			addSegment(seg);
		}
	}
	
    public boolean isComplete() {
        throw new UnsupportedOperationException("Not implemented");
    }
}
