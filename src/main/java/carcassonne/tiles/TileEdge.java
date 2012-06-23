/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.tiles;

import carcassonne.basic.tiles.Edge;

/**
 * Tile edges
 * @author Morgan
 */
public enum TileEdge {
    North(Edge.NORTH),
    East(Edge.EAST),
    South(Edge.SOUTH),
    West(Edge.WEST);
    
    private final Edge edge;
    
    TileEdge(Edge edge) {
        this.edge = edge;
    }
    
    Edge edge() {
        return this.edge;
    }
}
