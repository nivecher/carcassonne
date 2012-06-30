/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.tiles;

import java.util.List;

import carcassonne.features.IFeature;

/**
 *
 * @author Morgan
 */
public interface ITile {
    
    String getId();
    
    List<IFeature> getFeatures();
    
}
