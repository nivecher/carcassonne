/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package carcassonne

/**
 *
 * @author Morgan
 */
class Tile {
    String id
    List features
}

class TilePlacement extends Tile {
    def followers = []
}