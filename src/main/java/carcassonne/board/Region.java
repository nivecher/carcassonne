package carcassonne.board;

/**
 * Region enumeration following the Cartesian coordinate system (x,y)
 * for adjacent relative positions:
 * 
 *     (-1,1)  N  (1,1)
 *         _ _ _ _ _ 
 *        |x|_|x|_|x|
 *        |_|_|_|_|_|
 *     W  |x|_|x|_|x|  E
 *   A    |_|_|_|_|_|
 *   |    |x|_|x|_|x|
 *   |
 * y | (-1,-1)    (1,-1)
 *   |         S
 *    - - - - >
 *      x
 * 
 * N - North
 * E - East
 * S - South
 * W - West
 * C - Center
 * 
 * 0 - N/A =>   N/A
 * 1 - SW  => (-1, 0)
 * 2 - S   => ( 0, 1)
 * 3 - SE  => ( 1, 1)
 * 4 - W   => (-1, 0)
 * 5 - C   => ( 0, 0)
 * 6 - E   => ( 1, 0)
 * 7 - NW  => (-1, -1)
 * 8 - N   => ( 0, -1)
 * 9 - NE  => ( 1,  1)
 * 
 * @author Morgan
 * @deprecated use ITile.Direction instead
 */
@Deprecated
public enum Region {
    Unspecified(0,0), North(0,1), South(0,-1), East(1,0), West(-1,0);
    
    final int x;
    final int y;
    
    Region(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    int x() {
        return x;
    }
    
    int y() {
        return y;
    }
    
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

}
