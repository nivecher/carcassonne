/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne;

import carcassonne.basic.tiles.Feature;
import carcassonne.basic.tiles.Tile;
import carcassonne.basic.tiles.TileSet;
import carcassonne.tiles.BasicTileBuilder;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBElement;

/**
 *
 * @author Morgan
 */
public class Carcassonne {

    private static final Logger LOGGER = Logger.getLogger(Carcassonne.class.getName());
    private static final String BASIC_TILES_XML = "/basic-tiles.xml";
    private static final String INNS_CATHEDRALS_XML = "/expansions/inns-cathedrals-tiles.xml";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Carcassonne carcassonne = new Carcassonne();
        try {
            carcassonne.start();
        } catch (Exception ex) {
            carcassonne.shutdown();
            Logger.getLogger(Carcassonne.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void start() throws Exception {
        BasicTileBuilder reader = new BasicTileBuilder();

        TileSet basicSet = reader.loadTiles(BASIC_TILES_XML);
        LOGGER.log(Level.INFO, "Loading basic tiles");
        for (Tile t : basicSet.getTile()) {
            LOGGER.log(Level.INFO, "Loading tile: {0}", t.getId());
            List<JAXBElement<? extends Feature>> features = t.getFeature();
            for (int i = 0; i < t.getFeature().size(); i++) {
                Feature f = features.get(i).getValue();
                f.getDescription();
            }
        }

        TileSet icSet = reader.loadTiles(INNS_CATHEDRALS_XML);
        LOGGER.log(Level.INFO, "Loading Inns & Cathedrals tiles");
        for (Tile t : icSet.getTile()) {
            LOGGER.log(Level.INFO, "Loading tile: {0}", t.getId());
        }

        // TODO add expansions
    }

    public void shutdown() {
        // TODO implements shutdown logic
    }
}
