/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.features;

import java.util.HashSet;
import java.util.Set;

import carcassonne.followers.Follower;
import carcassonne.followers.Role;

/**
 * Feature that is made up of multiple segments
 *
 * @param <S> segment type that can be added to this feature
 * @author Morgan
 */
public abstract class AbsSegmentedFeature<S extends ISegment>
        extends AbsDeployableFeature
        implements ISegmentedFeature<S> {

    /**
     * Set of unique segments that comprises the feature
     */
    private final Set<S> segments = new HashSet<>();

    private boolean complete = false;

    public AbsSegmentedFeature(Role followerRole) {
        super(followerRole);
    }

    /**
     * Returns the point value for the feature based on the number of
     * segments and points per segment
     * @param pointsPerSegment points per segment
     * @return feature points
     */
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
     * @param follower follower to check if it can be added
     * @return true if the follower can be added to the feature, false otherwise
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
	
	@Override
    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
