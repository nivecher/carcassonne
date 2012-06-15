/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassone.tiles;

import carcassone.features.IFeature;
import carcassone.tiles.ITile.Direction;

/**
 * AbsTile builder interface 
 * @param <T> 
 * @author Morgan
 */
public interface ITileBuilder<T extends ITile> {
    
    T build ();
    
    ITileBuilder<T> addFeature(IFeature feature, Direction... locactions);
    
}
