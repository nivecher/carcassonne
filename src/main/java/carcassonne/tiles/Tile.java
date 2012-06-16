/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.tiles;

import carcassonne.followers.Follower;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.text.Segment;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Game tile
 *
 * @author Morgan
 */
@XmlRootElement
public class Tile implements ITile {
    
    private final List<Segment> segments = new ArrayList<>();
    
    /**
     * Tile identifier
     */
    @XmlAnyAttribute
    private final String id;

    public Tile(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tile other = (Tile) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public List<Follower> getFollowers() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
