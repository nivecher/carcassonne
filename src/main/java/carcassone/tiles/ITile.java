/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassone.tiles;

import carcassone.board.Position;
import carcassone.followers.Follower;
import java.util.List;

import static carcassone.tiles.ITile.Direction.*;
import java.util.Arrays;
import java.util.EnumSet;

/**
 *
 * @author Morgan
 */
public interface ITile {
    
    /**
     * Direction based on Num Pad layout
     * (where the number is the ordinal of the num)
     * Zero is Unspecified)
     *
     *        N
     * 
     *     7  8  9
     *  W  4  5  6  E
     *     1  2  3
     * 
     *        S
     */
    public enum Direction {
        Unspecified, // 0
        SW(-1,-1),   // 1
        S(0,-1),     // 2
        SE(1,-1),    // 3
        W(0,-1),     // 4
        C(0,0),      // 5
        E(1,0),      // 6
        NW(-1,1),    // 7
        N(0,1),      // 8
        NE(1,1);     // 9
         
        private final Position relativePosition;
        
        Direction(int x, int y) {
            this.relativePosition = new Position(x,y);
        }
        
        Direction() {
            this.relativePosition = null;
        }
        
        public Position relativePosition() {
            return this.relativePosition;
        }
    }

    public enum Edge {
        Center(EnumSet.of(E, C, W)),
        Top(EnumSet.of(NW, N, NE)), 
        Bottom(EnumSet.of(SW, S, SE)), 
        Left (EnumSet.of(NW, W, SW)), 
        Right (EnumSet.of(NE, E, SE));
        
        private final EnumSet<Direction> directions;
        
        Edge(EnumSet<Direction> directions) {
            this.directions = directions;
        }
        
        private boolean containsDirections(Direction... directions) {
            return this.directions.containsAll(Arrays.asList(directions));
        }
        
    }
    
    List<Follower> getFollowers();

    String getId();
    
}
