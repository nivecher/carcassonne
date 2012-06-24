/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.tiles.features;

import carcassonne.followers.Follower;
import carcassonne.followers.Role;
import java.util.ArrayList;
import java.util.List;

/**
 * Feature that is made up of multiple segments
 * @param <F> feature type
 * @author Morgan
 */
public abstract class AbsSegmentedFeature<F extends IFeature> extends AbsFeature
        implements IFollowerPlaceable, ISegmented<F> {

    private final List<ISegment<F>> segments = new ArrayList<>();

    public AbsSegmentedFeature(Role followerRole) {
        super(followerRole);
    }

    public int getPoints(int pointsPerSegment) {
        return getNumSegments() * pointsPerSegment;
    }

    @Override
    public void addSegment(ISegment<F> segment) {
        segments.add(segment);
        Follower newFollower = segment.getFollower();
        if (newFollower != null) {
            if (canAddFollower(newFollower)) {
                addFollower(newFollower);
            } else {
                throw new RuntimeException("Cannot add follower "
                        + newFollower + " to " + this.toString());
            }
        }
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
}
