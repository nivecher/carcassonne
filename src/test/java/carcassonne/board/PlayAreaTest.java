/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carcassonne.board;

import carcassonne.tiles.ITile;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.BDDMockito.*;
        
/**
 *
 * @author Morgan
 */
@RunWith(MockitoJUnitRunner.class)
public class PlayAreaTest {
    
    private PlayArea instance;
    
    @Mock private ITile startTile;
    @Mock private ITile tile1;
    @Mock private ITile tile2;
    
    private void givenStartTilePlaced() {
        instance.setStartTile(startTile);
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        instance = new PlayArea();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setStartTile method, of class PlayArea.
     */
    @Test
    public void testSetStartTile() {
        System.out.println("setStartTile");
        // given
        given(startTile.getId()).willReturn("D");
        
        // when
        ITilePlacement result = instance.setStartTile(startTile);
        
        // then
        assertEquals(startTile, result.getTile());
        assertEquals(Position.BASE, result.getPosition());
    }

    /**
     * Test of placeTile method, of class PlayArea.
     */
    @Test
    public void testPlaceTile() {
        System.out.println("placeTile");
        
        // given
        givenStartTilePlaced();
        given(tile1.getId()).willReturn("A");
        given(tile2.getId()).willReturn("B");
        Position loc = new Position(1,0);
        
        // when
        ITilePlacement p1 = instance.placeTile(tile1, loc);
        
        // then
        assertEquals(tile1, p1.getTile());
        assertEquals(loc, p1.getPosition());
        
        // given - position taken
        
        // when - placing a tile in the same position
        try {
            instance.placeTile(tile2, loc);
            fail("Position check failed");
        } catch (Exception ex) {
            // then - exception is thrown
        }
    }

    /**
     * Test of getPlacement method, of class PlayArea.
     */
    @Test
    public void testGetPlacement() {
        System.out.println("getPlacement");

        // given
        givenStartTilePlaced();
        
        // when
        ITilePlacement result = instance.getPlacement(Position.BASE);
        
        // then
        assertEquals(startTile, result.getTile());
    }

    /**
     * Test of findTile method, of class PlayArea.
     */
    @Test
    public void testFindTile() {
        System.out.println("fineTile");
        
        // given - no tile placed
        
        // when - attempt to get placement
        ITilePlacement result = instance.findTile(startTile);
        
        // then - no placement found
        assertNull(result);
        
        // given - start tile placed
        givenStartTilePlaced();
        
        // when - attempt to get placement
        result = instance.findTile(startTile);
        
        // then
        assertEquals(startTile, result.getTile());
    }

}
