/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.features.basic;

import carcassonne.features.AbsSegmentedFeature;
import carcassonne.followers.Role;

/**
 *
 * @author Morgan
 */
public class Field extends AbsSegmentedFeature<FieldSegment> {

    public Field() {
        super(Role.Farmer);
    }
    
}
