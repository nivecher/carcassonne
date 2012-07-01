/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.board;

import carcassonne.basic.tiles.Edge;
import carcassonne.features.IFeature;
import carcassonne.features.IFeatureSegment;
import carcassonne.features.basic.CitySegment;
import carcassonne.features.basic.FieldSegment;
import carcassonne.features.basic.RoadSegment;
import carcassonne.followers.Follower;
import carcassonne.followers.Role;
import carcassonne.tiles.ITile;
import java.util.Arrays;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author Morgan
 */
@RunWith(MockitoJUnitRunner.class)
public class TilePlacementTest {
    
    private TilePlacement instance;
    
    @Mock private ITile tile1;
    @Mock private ITile tile2;
    @Mock private ITile tile3;
    @Mock private Position pos1;
    @Mock private Follower follower1;
    @Mock private IFeature feature1;
    
    public TilePlacementTest() {
    }

    private void givenTile1Features() {
        given(tile1.getFeature(Edge.NORTH)).willReturn(new CitySegment());
        given(tile1.getFeature(Edge.EAST)).willReturn(new FieldSegment());
        given(tile1.getFeature(Edge.SOUTH)).willReturn(new RoadSegment());
        given(tile1.getFeature(Edge.WEST)).willReturn(new FieldSegment());
    }
    
    private void givenTile2Features() {
        given(tile2.getFeature(Edge.NORTH)).willReturn(new RoadSegment());
        given(tile2.getFeature(Edge.EAST)).willReturn(new FieldSegment());
        given(tile2.getFeature(Edge.SOUTH)).willReturn(new CitySegment());
        given(tile2.getFeature(Edge.WEST)).willReturn(new FieldSegment());
    }
    
    private void givenTile3Features() {
        RoadSegment road = new RoadSegment();
        given(tile3.getFeature(Edge.NORTH)).willReturn(new FieldSegment());
        given(tile3.getFeature(Edge.EAST)).willReturn(road);
        given(tile3.getFeature(Edge.SOUTH)).willReturn(road);
        given(tile3.getFeature(Edge.WEST)).willReturn(new CitySegment());
    }
	
	private void givenFeature1() {
		// given feature1 ("field") on tile1
        given(tile1.getFeatures()).willReturn(Arrays.asList(feature1));
		// TODO move to feature test
//        given(feature1.getFollowerRole()).willReturn(Role.Farmer);
	}
    
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        instance = new TilePlacement(tile1, pos1);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getConnectedTile method, of class TilePlacement.
     */
    @Test
    public void testGetTile() {
        System.out.println("getTile");
        // given 
        given(tile1.getId()).willReturn("H");
        
        // when
        ITile result = instance.getTile();
        
        // then
        assertEquals(tile1, result);
    }

    /**
     * Test of connectTile method, of class TilePlacement.
     */
    @Test
    public void testConnectTile() {
        System.out.println("connectTile");
        
        // given a new tile placement with no connected tiles
        
        // when new tile connected to the north edge
        ITilePlacement result = instance.connectTile(tile2, Edge.NORTH);
        
        // then - new tile placement created
        assertEquals(tile2, result.getTile());

        // given North edge already connected
        
        // when new tile connected to north edge
        try {
            instance.connectTile(tile3, Edge.NORTH);
            fail("Edge not checked during connection");
        } catch (Exception ex) {
            // then - connection fails
        }
    }

    /**
     * Test of canConnectTile method, of class TilePlacement.
     */
    @Test
    public void testCanConnectTile() {
        // given an empty tile placement and default tile features set
        // such that tile2 could be connected to any side of tile1 based on
        // connected features
        givenTile1Features();
        givenTile2Features();
        
        for (Edge e : Edge.values()) {
            // when checking if a tile can be connected on any edge
            boolean result = instance.canConnectTile(tile2, e);
            
            // then result is true
            assertTrue(result);
            
        }
        
        // given tile2 connected on east edge of tile1
        instance.connectTile(tile2, Edge.EAST);
        
        // when tile connected on east edge
        boolean result = instance.canConnectTile(tile2, Edge.EAST);
        
        // then connection not allowed
        assertFalse(result);
        
        // given tile connected on east edge, but not west
        
        // when tile connected on west edge
        result = instance.canConnectTile(tile2, Edge.WEST);
        
        // then connection is allowed
        assertTrue(result);
    }

    /**
     * Test of getConnectedTile method, of class TilePlacement.
     */
    @Test
    public void testGetConnectedTile() {
        System.out.println("getConnectedTile");
        
        // Given new tile placement and tile1 and tile2 have compatible
        // edge features
        givenTile1Features();
        givenTile2Features();
        
        for (Edge e : Edge.values()) {
            // when getting connected tiles for each edge
            ITilePlacement result = instance.getConnectedTile(e);
            
            // then each edge is empty
            assertNull(result);
        }
        
        // given tile2 connected on the east
        instance.connectTile(tile2, Edge.EAST);
        
        // when
        ITilePlacement t2 = instance.getConnectedTile(Edge.EAST);
        
        // then - tile2 returned
        assertEquals(tile2, t2.getTile());
        
        // when - getting connected tile on the opposite edge of t2 placement
        ITilePlacement t1 = t2.getConnectedTile(Edge.WEST);
        
        // then - connected placement is the original tile placement
        assertEquals(instance, t1);
        // then - connected tile is tile1
        assertEquals(tile1, t1.getTile());
        
        // given tile3 added to the north of tile2
        t2.connectTile(tile3, Edge.NORTH);
        
        // when
        ITilePlacement t3 = t2.getConnectedTile(Edge.NORTH);
        
        // then - tile3 returned
        assertEquals(tile3, t3.getTile());
        
    }
    
    /**
     * Test of getDeployedFeatures method, of class TilePlacement.
     */
    @Test
    public void testDeployedFollower() {
        System.out.println("deployFollower");
        
		// given feature1 not on tile1
		
		// when
		try {
			instance.deployFollower(follower1, feature1);
			fail("Feature not checked during deployment");
		} catch (Exception ex) {
			// then exception thrown
		}
		
        givenFeature1();
        
        // when
        instance.deployFollower(follower1, feature1);
        verify(feature1).addFollower(follower1);
        
        // TODO add more tests
    }

    /**
     * Test of getDeployedFeatures method, of class TilePlacement.
     */
    @Test
    public void testGetDeployedFeatures() {
        System.out.println("getDeployedFeatures");
        
        // given new instance and feature1
		givenFeature1();
        
        // when
        List<IFeature> deployed = instance.getDeployedFeatures();
        
        // then deployed features list empty
        assertTrue(deployed.isEmpty());
        
        // given - follower deployed
        instance.deployFollower(follower1, feature1);
        
        // TODO add more tests
        fail("Not implemented");
    }
    
    /**
     * Test of getPosition method, of class TilePlacement.
     */
    @Test
    public void testGetPosition() {
        System.out.println("getPosition");
        TilePlacement instance = null;
        Position expResult = null;
        Position result = instance.getPosition();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFeature method, of class TilePlacement.
     */
    @Test
    public void testGetFeature() {
        System.out.println("getFeature");
        Edge e = null;
        TilePlacement instance = null;
        IFeatureSegment expResult = null;
        IFeatureSegment result = instance.getFeature(e);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFeatures method, of class TilePlacement.
     */
    @Test
    public void testGetFeatures() {
        System.out.println("getFeatures");
        TilePlacement instance = null;
        List expResult = null;
        List result = instance.getFeatures();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
