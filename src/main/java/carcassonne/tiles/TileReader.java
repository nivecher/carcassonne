/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.tiles;

import carcassonne.basic.tiles.TileSet;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;

/**
 *
 * @author Morgan
 */
public class TileReader {

    private static final Logger LOGGER = Logger.getLogger(TileReader.class.getName());

    public TileSet readTiles(String xmlFilename) throws Exception {

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
}
