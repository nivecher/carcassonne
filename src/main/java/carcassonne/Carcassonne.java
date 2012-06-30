/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne;

import carcassonne.basic.tiles.Tile;
import carcassonne.basic.tiles.TileSet;
import carcassonne.tiles.BasicTileBuilder;
import carcassonne.tiles.EdgeUtils;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;

/**
 *
 * @author Morgan
 */
public class Carcassonne {

    private static final Logger LOGGER = Logger.getLogger(Carcassonne.class.getName());
    private static final String BASIC_TILES_XML = "/basic-tiles.xml";
    private static final String INNS_CATHEDRALS_XML = "/expansions/inns-cathedrals-tiles.xml";

    private final EdgeUtils edgeUtils;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Carcassonne carcassonne = new Carcassonne(new EdgeUtils());
        try {
            carcassonne.start();
        } catch (Exception ex) {
            carcassonne.shutdown();
            Logger.getLogger(Carcassonne.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    private Carcassonne(EdgeUtils edgeUtils) {
        this.edgeUtils = edgeUtils;
    }

    public void start() throws Exception {
        BasicTileBuilder builder = new BasicTileBuilder();

        TileSet basicSet = builder.loadTiles(BASIC_TILES_XML, 
                JAXBContext.newInstance("carcassonne.basic.tiles"));
        LOGGER.log(Level.INFO, "Loading basic tiles");
        int basicTiles = 0;
        for (Tile t : basicSet.getTile()) {
            LOGGER.log(Level.INFO, "Loading tile: {0}", t.getId());
            for (int i = 0; i < t.getInstances(); i++) {
                edgeUtils.validateEdges(builder.buildTile(t));
                basicTiles++;
            }
        }
        LOGGER.log(Level.INFO, "{0} basic tiles created", basicTiles);
        
        TileSet icSet = builder.loadTiles(INNS_CATHEDRALS_XML,
                JAXBContext.newInstance("carcassonne.inns_cathedrals.tiles"));
        LOGGER.log(Level.INFO, "Loading Inns & Cathedrals tiles");
        int icTiles = 0;
        for (Tile t : icSet.getTile()) {
            LOGGER.log(Level.INFO, "Loading tile: {0}", t.getId());
            for (int i = 0; i < t.getInstances(); i++) {
                edgeUtils.validateEdges(builder.buildTile(t));
                icTiles++;
            }
        }
        LOGGER.log(Level.INFO, "{0} Inns & Cathedrals tiles created", 
                icTiles);

        // TODO add more expansions
    }

    public void shutdown() {
        // TODO implements shutdown logic
    }
}
