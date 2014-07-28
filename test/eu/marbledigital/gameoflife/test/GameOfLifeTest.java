package eu.marbledigital.gameoflife.test;

import eu.marbledigital.gameoflife.Cell;
import eu.marbledigital.gameoflife.World;
import eu.marbledigital.gameoflife.GameOfLife;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GameOfLifeTest {
    
    private World world;
    private GameOfLife gameOfLife;
    
    public GameOfLifeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.world = new World();
        this.gameOfLife = new GameOfLife();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testEmptyWorld() {
        assertFalse(world.isAlive(new Cell(0, 0)));
    }
    
    @Test
    public void testAddedCellIsAlive() {
        world.add(new Cell(0, 0));
        assertTrue(world.isAlive(new Cell(0, 0)));
        assertFalse(world.isAlive(new Cell(0, 1)));
    }
    
    @Test
    public void testCellEqualsTrue() {
        Cell cell1 = new Cell(0, 0);
        Cell cell2 = new Cell(0, 0);
        
        assertTrue(cell1.equals(cell2));
    }
    
    @Test
    public void testCellEqualsFalse() {
        Cell cell1 = new Cell(0, 0);
        Cell cell2 = new Cell(0, 1);
        
        assertFalse(cell1.equals(cell2));
    }
    
    @Test
    public void testEmptyWorldStep() {
        World nextWorld = gameOfLife.getNextWorld(world);
        
        assertFalse(nextWorld.isAlive(new Cell(0, 0)));
    }
    
    @Test
    public void testLonelyCellDies() {
        world.add(new Cell(0, 0));

        World nextWorld = gameOfLife.getNextWorld(world);
        
        assertFalse(nextWorld.isAlive(new Cell(0, 0)));
    }
    
    @Test
    public void testCellWithOneNeighbourDies() {
        world.add(new Cell(0, 0));
        world.add(new Cell(0, 1));

        World nextWorld = gameOfLife.getNextWorld(world);
        
        assertFalse(nextWorld.isAlive(new Cell(0, 0)));
    }
    
    @Test
    public void testCellWithTwoNeighboursLivesOn() {
        world.add(new Cell(0, -1));
        world.add(new Cell(0, 0));
        world.add(new Cell(0, 1));

        World nextWorld = gameOfLife.getNextWorld(world);
        
        assertTrue(nextWorld.isAlive(new Cell(0, 0)));
    }
    
    @Test
    public void testCellNeighbours() {
        Cell cell = new Cell(0, 0);
        List<Cell> neighbours = cell.getNeighbours();
        assertEquals(8, neighbours.size());
        assertTrue(neighbours.contains(new Cell(-1, -1)));
        assertTrue(neighbours.contains(new Cell(1, 1)));
        assertFalse(neighbours.contains(new Cell(0, 0)));
    }
    
    @Test
    public void testLivingNeighbourCountOneNeighbour() {
        world.add(new Cell(0, 0));
        
        assertEquals(1, world.getLivingNeighbourCount(new Cell(0, 1)));
    }
    
    @Test
    public void testLivingNeighbourCountTwoNeighbours() {
        world.add(new Cell(0, 0));
        world.add(new Cell(0, 1));
        
        assertEquals(2, world.getLivingNeighbourCount(new Cell(1, 0)));
    }
    
    @Test
    public void testCellWithThreeNeighboursLivesOn() {
        world.add(new Cell(0, -1));
        world.add(new Cell(0, 0));
        world.add(new Cell(0, 1));
        world.add(new Cell(-1, 0));
        
        World nextWorld = gameOfLife.getNextWorld(world);
        
        assertTrue(nextWorld.isAlive(new Cell(0, 0)));
    }
    
    @Test
    public void testCellWithFourNeighboursDies() {
        world.add(new Cell(0, -1));
        world.add(new Cell(0, 0));
        world.add(new Cell(0, 1));
        world.add(new Cell(-1, 0));
        world.add(new Cell(1, 0));
        
        World nextWorld = gameOfLife.getNextWorld(world);
        assertFalse(nextWorld.isAlive(new Cell(0, 0)));
    }
}
