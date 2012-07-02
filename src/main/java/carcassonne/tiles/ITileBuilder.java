/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.tiles;

import carcassonne.basic.tiles.Tile;
import carcassonne.basic.tiles.TileSet;
import javax.xml.bind.JAXBContext;

/**
 *
 * @author Morgan
 */
public interface ITileBuilder {

	BasicTile buildTile(Tile tile);

	TileSet loadTiles(String xmlFilename, JAXBContext context) throws Exception;
	
}
