/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.tiles;

import carcassonne.basic.tiles.TileSet;
import carcassonne.basic.tiles.Tile;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Morgan
 */
public class BasicTileBuilder implements ITileBuilder {

    private final List<Tile> tiles = new ArrayList<>();
    
    BasicTileBuilder(TileSet set) {
        buildTiles(set);
    }
    
    private void buildTiles(TileSet set) {
        for (LandscapeTile t : set.getTile()) {
            tiles.add(createTile(t));
        }
    }
    
    @Override
    public ITile build() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
