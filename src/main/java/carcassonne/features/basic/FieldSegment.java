/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.features.basic;

import carcassonne.features.AbsFeatureSegment;
import carcassonne.features.ISegment;
import carcassonne.followers.Role;

/**
 *
 * @author Morgan
 */
public class FieldSegment extends AbsFeatureSegment implements ISegment {

    public FieldSegment() {
        super(Role.Farmer);
    }
    
}
