/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
}
