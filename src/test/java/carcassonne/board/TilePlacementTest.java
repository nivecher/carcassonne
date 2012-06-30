/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.board;

import carcassonne.basic.tiles.Edge;
import carcassonne.features.IFeatureSegment;
import carcassonne.followers.Follower;
import carcassonne.tiles.ITile;
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
    @Mock private Position pos1;
    
    public TilePlacementTest() {
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
     * Test of getAdjacentTile method, of class TilePlacement.
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
     * Test of addTile method, of class TilePlacement.
     */
    @Test
    public void testAddTile() {
        System.out.println("addTile");
        ITile newTile = null;
        Edge edge = null;
        TilePlacement instance = null;
        ITilePlacement expResult = null;
        ITilePlacement result = instance.addTile(newTile, edge);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of canAddTile method, of class TilePlacement.
     */
    @Test
    public void testCanAddTile() {
        System.out.println("canAddTile");
        ITile newTile = null;
        Edge edge = null;
        TilePlacement instance = null;
        boolean expResult = false;
        boolean result = instance.canAddTile(newTile, edge);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAdjacentTile method, of class TilePlacement.
     */
    @Test
    public void testGetAdjacentTile() {
        System.out.println("getAdjacentTile");
        Edge edge = null;
        TilePlacement instance = null;
        ITilePlacement expResult = null;
        ITilePlacement result = instance.getAdjacentTile(edge);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDeployedFollower method, of class TilePlacement.
     */
    @Test
    public void testGetDeployedFollower() {
        System.out.println("getDeployedFollower");
        TilePlacement instance = null;
        Follower expResult = null;
        Follower result = instance.getDeployedFollower();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class TilePlacement.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        TilePlacement instance = null;
        String expResult = "";
        String result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class TilePlacement.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        TilePlacement instance = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
     * Test of hashCode method, of class TilePlacement.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        TilePlacement instance = null;
        int expResult = 0;
        int result = instance.hashCode();
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

    /**
     * Test of toString method, of class TilePlacement.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        TilePlacement instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
