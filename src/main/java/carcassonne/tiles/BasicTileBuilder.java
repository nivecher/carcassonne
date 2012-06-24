/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.tiles;

import carcassonne.basic.tiles.Feature;
import carcassonne.basic.tiles.Tile;
import carcassonne.basic.tiles.TileSet;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;

/**
 *
 * @author Morgan
 */
public class BasicTileBuilder {

    private static final Logger LOGGER = Logger.getLogger(BasicTileBuilder.class.getName());

    public TileSet loadTiles(String xmlFilename) throws Exception {

        try {
            URL xmlURL = getClass().getResource(xmlFilename);
            JAXBContext context = JAXBContext.newInstance(TileSet.class);
            Object ts = context.createUnmarshaller().unmarshal(xmlURL);
            return (TileSet) ts;
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, null, ex);
            throw new Exception("Failed to load TileSet from: " + xmlFilename, ex);
        }
    }
    
    private BasicTile buildTile(Tile tile) {
        List<JAXBElement<? extends Feature>> tileFeatures = tile.getFeature();
        BasicTile basicTile = new BasicTile(tile.getId());
        for (int n = 0; n < tile.getInstances(); n++) {
            for (int i = 0; i < tileFeatures.size(); i++) {
                Feature f = tileFeatures.get(i).getValue();
                basicTile.addFeature(f);
            }
        }
        return basicTile;
    }
}
