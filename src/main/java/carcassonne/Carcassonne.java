package carcassonne;

import carcassonne.basic.tiles.Edge;
import carcassonne.basic.tiles.Tile;
import carcassonne.basic.tiles.TileSet;
import carcassonne.board.IPlayArea;
import carcassonne.board.ITilePlacement;
import carcassonne.board.PlayArea;
import carcassonne.followers.Color;
import carcassonne.game.BasicGame;
import carcassonne.players.IPlayerFactory;
import carcassonne.players.PlayerFactory;
import carcassonne.tiles.BasicTileBuilder;
import carcassonne.tiles.EdgeUtils;
import carcassonne.tiles.ITile;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
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
    private static final String START_TILE_ID = "D";

    private final EdgeUtils edgeUtils;
    private final BasicTileBuilder basicTileBuilder;
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
        this.basicTileBuilder = builder;
    }

    public void start() throws Exception {
        List<ITile> tiles = createTiles();
        LOGGER.info("Creating play area");
		
		IPlayerFactory playerFactory = new PlayerFactory();
		
        IPlayArea pArea = new PlayArea();
		
		BasicGame game = new BasicGame(pArea, tiles);
		
		LOGGER.info("Loading expansions");
		// TODO move to carcassone.properties
		Properties props = new Properties();
		props.put("expansions", "inns_cathedrals");
		props.put("inns_cathedrals.tiles.builder", 
				"carcassonne.expansions.inns_cathedrals.ICTileBuilder");
		props.put("inns_cathedrals.tiles.package", 
				"carcassonne.inns_cathedrals.tiles");
		props.put("inns_cathedrals.tiles.xml", 
				"/expansions/inns-cathedrals-tiles.xml");
		new ExpansionLoader(props).loadExpansions(game);
		
		LOGGER.info("Creating players");
		for (Color c : Color.values()) {
			LOGGER.log(Level.INFO, "Creating {0} player", c);
			game.addPlayer(playerFactory.createPlayer(c));
		}
		
		int totalTiles = game.getNumTiles();
		ITilePlacement placement = game.start(startTile);
		
        // TODO temporary
        // Place all tiles 
		int placedTiles = 0;
        while (!tiles.isEmpty()) {
            ITile t = tiles.remove(0);
			boolean placed = false;
            for (Edge edge : Edge.values()) {
				if (placement.canConnectTile(t, edge)) {
					LOGGER.log(Level.INFO, "Placing tile ''{0}'' {1} of ''{2}''", 
							new Object[]{t.getId(), edge, placement.getTile().getId()});
					placement = placement.connectTile(t, edge);
					placedTiles++;
					placed = true;
					break;
				}
			}
			if (!placed) {
				LOGGER.log(Level.WARNING, "Could not place tile ''{0}'' on ''{1}''", 
						new Object[]{t.getId(), placement.getTile().getId()});
			}
        }
		LOGGER.log(Level.INFO, "Placed {0} of {1} tiles", 
				new Object[] {placedTiles, totalTiles});
    }
    
    private List<ITile> createTiles() throws Exception {
        
        List<ITile> tiles = new ArrayList<>();
        
        TileSet basicSet = basicTileBuilder.loadTiles(BASIC_TILES_XML, 
                JAXBContext.newInstance("carcassonne.basic.tiles"));
        LOGGER.log(Level.INFO, "Loading basic tiles");
        int basicTiles = 0;
        for (Tile t : basicSet.getTile()) {
            LOGGER.log(Level.INFO, "Loading tile: {0}", t.getId());
            for (int i = 0; i < t.getInstances(); i++) {
                ITile tile = basicTileBuilder.buildTile(t);
                edgeUtils.validateEdges(tile);
                tiles.add(tile);
                if (startTile == null && tile.getId().equals(START_TILE_ID)) {
                    startTile = tile;
                }
                basicTiles++;
            }
        }
        LOGGER.log(Level.INFO, "{0} basic tiles created", basicTiles);

        return tiles;
    }

    public void shutdown() {
        // TODO implement shutdown logic
    }
}
