/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.features;

/**
 *
 * @author Morgan
 */
public interface IFeature extends IFollowerDeployable {
    
    int getPoints();
    
    boolean isComplete();
}
