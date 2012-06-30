package carcassonne;

import carcassonne.basic.tiles.Edge;
import carcassonne.basic.tiles.Tile;
import carcassonne.basic.tiles.TileSet;
import carcassonne.board.IPlayArea;
import carcassonne.board.ITilePlacement;
import carcassonne.board.PlayArea;
import carcassonne.tiles.BasicTileBuilder;
import carcassonne.tiles.EdgeUtils;
import carcassonne.tiles.ITile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
    private static final String START_TILE_ID = "D";

    private final EdgeUtils edgeUtils;
    private final BasicTileBuilder builder;
    private ITile startTile = null;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO setup injection
        Carcassonne carcassonne = new Carcassonne(new EdgeUtils(), new BasicTileBuilder());
        try {
            carcassonne.start();
        } catch (Exception ex) {
            carcassonne.shutdown();
            Logger.getLogger(Carcassonne.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    private Carcassonne(EdgeUtils edgeUtils, BasicTileBuilder builder) {
        this.edgeUtils = edgeUtils;
        this.builder = builder;
    }

    public void start() throws Exception {
        List<ITile> tiles = createTiles();
        LOGGER.info("Creating play area");
        IPlayArea pArea = new PlayArea();
        LOGGER.log(Level.INFO, "Placing start tile: {0}", startTile);
        tiles.remove(startTile);
        LOGGER.info("Shuffling tiles");
        Collections.shuffle(tiles);
        ITilePlacement placement = pArea.setStartTile(startTile);
        // TODO temporary
        // Place all tiles 
        while (!tiles.isEmpty()) {
            ITile t = tiles.remove(0);
            Edge edge = Edge.EAST;
            if (placement.canAddTile(t, edge)) {
                LOGGER.log(Level.INFO, "Placing tile ''{0}'' ''{1}'' of ''{2}''", 
                        new Object[]{t.getId(), edge, placement.getTile().getId()});
                placement = placement.addTile(t, edge);
            }
        }
    }
    
    private List<ITile> createTiles() throws Exception {
        
        List<ITile> tiles = new ArrayList<>();
        
        TileSet basicSet = builder.loadTiles(BASIC_TILES_XML, 
                JAXBContext.newInstance("carcassonne.basic.tiles"));
        LOGGER.log(Level.INFO, "Loading basic tiles");
        int basicTiles = 0;
        for (Tile t : basicSet.getTile()) {
            LOGGER.log(Level.INFO, "Loading tile: {0}", t.getId());
            for (int i = 0; i < t.getInstances(); i++) {
                ITile tile = builder.buildTile(t);
                edgeUtils.validateEdges(tile);
                tiles.add(tile);
                if (startTile == null && tile.getId().equals(START_TILE_ID)) {
                    startTile = tile;
                }
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
                ITile tile = builder.buildTile(t);
                edgeUtils.validateEdges(tile);
                tiles.add(tile);
                icTiles++;
            }
        }
        LOGGER.log(Level.INFO, "{0} Inns & Cathedrals tiles created", 
                icTiles);

        // TODO add more expansions
        return tiles;
    }

    public void shutdown() {
        // TODO implement shutdown logic
    }
}
