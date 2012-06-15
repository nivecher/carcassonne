/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassone.tiles;

import java.util.Objects;

/**
 * Game tile
 *
 * @author Morgan
 */
public abstract class AbsTile implements ITile {
    
    /**
     * AbsTile identifier
     */
    private final String id;

    public AbsTile(String id) {
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
        final AbsTile other = (AbsTile) obj;
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
    
}
