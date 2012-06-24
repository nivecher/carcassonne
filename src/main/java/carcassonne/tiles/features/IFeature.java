/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.tiles.features;

/**
 *
 * @author Morgan
 */
public interface IFeature extends IFollowerPlaceable {
    
    int getPoints();
    
    boolean isComplete();
}
