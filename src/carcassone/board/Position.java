package carcassone.board;

/**
 * Position based on the Cartesian coordinate system, in two-dimension
 * @author Morgan
 */
public class Position {

    static final Position BASE = new Position(0,0);
    
    /**
     * Horizontal position relative to the base tile
     */
    private final int x;
    
    /**
     * Vertical position relative to the base tile
     */
    private final int y;
    
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Get the value of x
     *
     * @return the value of x
     */
    public int getX() {
        return x;
    }

    /**
     * Get the value of y
     *
     * @return the value of y
     */
    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Position other = (Position) obj;
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.x;
        hash = 47 * hash + this.y;
        return hash;
    }

    @Override
    public String toString() {
        return String.valueOf('(' + x + ',' + y + ')');
    }

    /**
     * Return a relative position
     * @param pos
     * @return 
     */
    public Position getRelative(Position pos) {
        return new Position(x + pos.x, y + pos.y);
    }
}
