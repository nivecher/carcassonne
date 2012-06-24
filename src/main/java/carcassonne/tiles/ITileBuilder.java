/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.tiles;

/**
 * AbsTile builder interface 
 * @param <T> 
 * @author Morgan
 */
public interface ITileBuilder<T extends ITile> {
    
    T build ();
    
}
