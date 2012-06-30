/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.tiles;

import carcassonne.basic.tiles.City;
import carcassonne.basic.tiles.Cloister;
import carcassonne.basic.tiles.Edge;
import carcassonne.basic.tiles.Feature;
import carcassonne.basic.tiles.Field;
import carcassonne.basic.tiles.Road;
import carcassonne.basic.tiles.Segment;
import carcassonne.basic.tiles.Tile;
import carcassonne.basic.tiles.TileSet;
import carcassonne.features.AbsFeatureSegment;
import carcassonne.features.IFeature;
import carcassonne.features.basic.CitySegment;
import carcassonne.features.basic.FieldSegment;
import carcassonne.features.basic.RoadSegment;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;

/**
 *
 * @author Morgan
 */
public class BasicTileBuilder {

    private static final Logger LOGGER = Logger.getLogger(BasicTileBuilder.class.getName());

    public TileSet loadTiles(String xmlFilename, JAXBContext context) throws Exception {

        try {
            URL xmlURL = getClass().getResource(xmlFilename);
//            JAXBContext context = JAXBContext.newInstance(TileSet.class);
            Object ts = context.createUnmarshaller().unmarshal(xmlURL);
            return (TileSet) ts;
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, null, ex);
            throw new Exception("Failed to load TileSet from: " + xmlFilename, ex);
        }
    }
    
    public BasicTile buildTile(Tile tile) {
        List<JAXBElement<? extends Feature>> tileFeatures = tile.getFeature();
        BasicTile basicTile = new BasicTile(tile.getId());
        for (int i = 0; i < tileFeatures.size(); i++) {
            Feature f = tileFeatures.get(i).getValue();
            basicTile.addFeature(buildFeature(f));
        }
        return basicTile;
    }
    
    public IFeature buildFeature(Feature f) {
        IFeature newFeature;
        if (f instanceof Cloister) {
            newFeature = createCloister((Cloister) f);
        } else if (f instanceof City) {
            newFeature = createCity((City) f);
        } else if (f instanceof Field) {
            newFeature = createField((Field) f);
        } else if (f instanceof Road) {
            newFeature = createRoad((Road) f);
        } else {
            throw new IllegalArgumentException("Unknown feature type: " + f);
        }
        return newFeature;
    }
    
    private carcassonne.features.basic.Cloister createCloister(Cloister c) {
        return new carcassonne.features.basic.Cloister();
    }
    
    private void addEdges(AbsFeatureSegment seg, Segment s) {
        for (Edge e : s.getEdge()) {
            seg.addEdge(e);
        }
    }
    
    private CitySegment createCity(City city) {
        CitySegment seg = new CitySegment();
        seg.setPennants(city.getPennant().size());
        addEdges(seg, city);
        return seg;
    }

    private FieldSegment createField(Field field) {
        FieldSegment seg = new FieldSegment();
        addEdges(seg, field);
        return seg;
    }
    
    private RoadSegment createRoad(Road road) {
        RoadSegment seg = new RoadSegment();
        addEdges(seg, road);
        return seg;
    }
}
