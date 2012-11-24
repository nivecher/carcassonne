/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.game;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import carcassonne.board.IPlayArea;
import carcassonne.board.ITilePlacement;
import carcassonne.followers.Color;
import carcassonne.players.Player;
import carcassonne.tiles.ITile;

/**
 * Basic Carcassonne game that contains players, a play area and game tiles
 * @author Morgan
 */
public class BasicGame {
	
	private static final Logger LOGGER = Logger.getLogger(BasicGame.class.getName());
	
	private final Map<Color, Player> playerMap = new HashMap<>();
	
	private final IPlayArea playArea;
	private final List<ITile> tiles;
	
	public BasicGame(IPlayArea playArea, List<ITile> tiles) {
		this.playArea = playArea;
		this.tiles = new ArrayList<>(tiles);
	}
	
	public void addPlayer(Player p) {
		if (playerMap.containsKey(p.getColor())) {
			throw new IllegalArgumentException("Color already taken: " + 
					p.getColor());
		}
		playerMap.put(p.getColor(), p);
	}
	
	public ITilePlacement start(ITile startTile) {
		LOGGER.log(Level.INFO, "Placing start tile: {0}", startTile);
        tiles.remove(startTile);
        LOGGER.info("Shuffling tiles");
        Collections.shuffle(tiles);
        return playArea.setStartTile(startTile);
	}

	public void addTiles(List<ITile> newTiles) {
		tiles.addAll(newTiles);
	}

	public int getNumTiles() {
		return tiles.size();
	}

    public ITile drawTile() {
        if (tiles.isEmpty()) {
            return null;
        }
        return tiles.remove(0);
    }
}
