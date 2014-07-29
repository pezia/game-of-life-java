package eu.marbledigital.gameoflife.test;

import eu.marbledigital.gameoflife.Cell;
import eu.marbledigital.gameoflife.World;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * World tests
 *
 * @author Zsolt Petrik
 */
public class WorldTest {

    private World world;

    @Before
    public void setUp() {
        this.world = new World();
    }

    @After
    public void tearDown() {
        this.world = null;
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
    public void testMultipleAddsDoNotDuplicate() {
        world.add(new Cell(0, 0));
        world.add(new Cell(0, 0));
        world.add(new Cell(0, 0));

        assertEquals(1, world.getLivingNeighbourCount(new Cell(0, 1)));
    }
}
