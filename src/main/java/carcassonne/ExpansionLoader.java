/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne;

import javax.xml.bind.JAXBContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import carcassonne.basic.tiles.TileSet;
import carcassonne.game.BasicGame;
import carcassonne.tiles.EdgeUtils;
import carcassonne.tiles.ITile;
import carcassonne.tiles.ITileBuilder;

/**
 *
 * @author Morgan
 */
public class ExpansionLoader {
	
	private static final Logger LOGGER = Logger.getLogger(ExpansionLoader.class.getName());

	private final Properties props;
	// TODO inject EdgeUtils
	private final EdgeUtils edgeUtils = new EdgeUtils();
	
	public ExpansionLoader(Properties props) {
		this.props = props;
	}
	
	public void loadExpansions(BasicGame game) throws Exception {
		String expansions = props.getProperty("expansions");
		for (String exp : expansions.split(",")) {
			loadExpansion(exp.trim(), game);
		}
	}
	
	private void loadExpansion(String exp, BasicGame game) throws Exception {
		String title = props.getProperty(exp + ".title");
		String tilesFile = props.getProperty(exp + ".tiles.xml");
		String tilesBuilder = props.getProperty(exp + ".tiles.builder");
		String tilesPackage = props.getProperty(exp + ".tiles.package");
		Class builderClass = Class.forName(tilesBuilder);
		if (builderClass == null) {
			throw new IllegalArgumentException("Failed to load class: " +
					tilesBuilder);
		}
		ITileBuilder tileBuilder = (ITileBuilder) builderClass.newInstance();
		
		List<ITile> tiles = new ArrayList<>();
		
		TileSet icSet = tileBuilder.loadTiles(tilesFile,
                JAXBContext.newInstance(tilesPackage));
        LOGGER.log(Level.INFO, "Loading {0} tiles", title);
        int icTiles = 0;
        for (carcassonne.basic.tiles.Tile t : icSet.getTile()) {
            LOGGER.log(Level.INFO, "Loading tile: {0}", t.getId());
            for (int i = 0; i < t.getInstances(); i++) {
                ITile tile = tileBuilder.buildTile(t);
                edgeUtils.validateEdges(tile);
                tiles.add(tile);
                icTiles++;
            }
        }
        LOGGER.log(Level.INFO, "{0} Inns & Cathedrals tiles created", 
                icTiles);
		game.addTiles(tiles);
	}
}
