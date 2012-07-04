/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.board;

import carcassonne.basic.tiles.Edge;
import carcassonne.features.IFeature;
import carcassonne.followers.Follower;
import carcassonne.tiles.ITile;
import java.util.List;

/**
 *
 * @author Morgan
 */
public interface ITilePlacement extends ITile {

    /**
     * Adds a tile next to the current tile position based on the specified
     * direction
     * @param tile
     * @param edge
     * @return new tile placement 
     */
    ITilePlacement connectTile(ITile tile, Edge edge);

    ITile getTile();
	
    /**
     * Returns all the features that have deployed followers on the tile
     * @return deployed features
     */
    List<IFeature> getDeployedFeatures();
    
    /**
     * Deploys a follower onto the specified  feature
     * @param follower
     * @param feature 
     */
    void deployFollower(Follower follower, IFeature feature);

    /**
     * Returns the tile next to this tile on the specified edge
     * @param edge
     * @return
     */
    ITilePlacement getConnectedTile(Edge edge);
 
    boolean canConnectTile(ITile tile, Edge edge);
    
    /**
     * Tile's position within the play area
     * @return 
     */
    Position getPosition();
	
	void addTileListener(ITilePlacementListener listener);
	
	void removeTileListener(ITilePlacementListener listener);
}
