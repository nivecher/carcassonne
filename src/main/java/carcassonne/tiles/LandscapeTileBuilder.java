/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.tiles;

import carcassonne.board.Position;
import carcassonne.features.IFeature;
import carcassonne.features.ISegment;
import carcassonne.tiles.ITile.Direction;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Morgan
 */
public class LandscapeTileBuilder implements ITileBuilder<LandscapeTile> {

    private final Map<Direction, ISegment> segmentMap = new HashMap<>();
    
    private class FeatureBuilder<F extends IFeature> {
        private final ITileBuilder<LandscapeTile> tileBuilder;
        private final F feature;

        FeatureBuilder(ITileBuilder<LandscapeTile> tileBuilder, F feature) {
            this.tileBuilder = tileBuilder;
            this.feature = feature;
        }

        FeatureBuilder<F> addSegment(Direction loc) {
//  TODO          this.tileBuilder.placeSegment(loc);
            return this;
        }

        ITileBuilder<LandscapeTile> toPosition(Position loc) {
            return tileBuilder;
        }

    }
    
    @Override
    public LandscapeTile build() {
        String id = processMap();
        LandscapeTile t = new LandscapeTile(id);
        t.addSegment(null);
        return t;
    }

    public <F extends IFeature> FeatureBuilder<F> addFeature(F feature) {
        return new FeatureBuilder<>(this, feature);
    }
    
    /**
     * Processes the segment map
     * @return 
     */
    private String processMap() {
        return "ID"; // TODO
    }
 
    
}
