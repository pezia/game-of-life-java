package eu.marbledigital.gameoflife.test;

import eu.marbledigital.gameoflife.Cell;
import eu.marbledigital.gameoflife.World;
import eu.marbledigital.gameoflife.GameOfLife;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * GameOfLife tests
 *
 * @author Zsolt Petrik
 */
public class GameOfLifeTest {

    private World world;
    private GameOfLife gameOfLife;

    @Before
    public void setUp() {
        this.world = new World();
        this.gameOfLife = new GameOfLife();
    }

    @After
    public void tearDown() {
        this.world = null;
        this.gameOfLife = null;
    }

    @Test
    public void testEmptyWorld() {
        World nextWorld = gameOfLife.generateNext(world);

        assertFalse(nextWorld.isAlive(new Cell(0, 0)));
    }

    @Test
    public void testLonelyCellDies() {
        world.add(new Cell(0, 0));

        World nextWorld = gameOfLife.generateNext(world);

        assertFalse(nextWorld.isAlive(new Cell(0, 0)));
    }

    @Test
    public void testCellWithOneNeighbourDies() {
        world.add(new Cell(0, 0));
        world.add(new Cell(0, 1));

        World nextWorld = gameOfLife.generateNext(world);

        assertFalse(nextWorld.isAlive(new Cell(0, 0)));
    }

    @Test
    public void testCellWithTwoNeighboursLivesOn() {
        world.add(new Cell(0, -1));
        world.add(new Cell(0, 0));
        world.add(new Cell(0, 1));

        World nextWorld = gameOfLife.generateNext(world);

        assertTrue(nextWorld.isAlive(new Cell(0, 0)));
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

        World nextWorld = gameOfLife.generateNext(world);

        assertTrue(nextWorld.isAlive(new Cell(0, 0)));
    }

    @Test
    public void testCellWithFourNeighboursDies() {
        world.add(new Cell(0, -1));
        world.add(new Cell(0, 0));
        world.add(new Cell(0, 1));
        world.add(new Cell(-1, 0));
        world.add(new Cell(1, 0));

        World nextWorld = gameOfLife.generateNext(world);
        assertFalse(nextWorld.isAlive(new Cell(0, 0)));
    }
}
