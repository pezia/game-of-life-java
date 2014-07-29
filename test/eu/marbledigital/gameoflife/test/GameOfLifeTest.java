package eu.marbledigital.gameoflife.test;

import eu.marbledigital.gameoflife.Cell;
import eu.marbledigital.gameoflife.World;
import eu.marbledigital.gameoflife.GameOfLife;
import java.util.Arrays;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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

    private World generateNewWorldForCells(Cell[] cells) {
        world.addAll(Arrays.asList(cells));

        return gameOfLife.generateNext(world);
    }

    @Test
    public void testEmptyWorld() {
        World nextWorld = gameOfLife.generateNext(world);

        assertFalse(nextWorld.isAlive(new Cell(0, 0)));
    }

    @Test
    public void testLonelyCellDies() {
        World nextWorld = generateNewWorldForCells(new Cell[]{new Cell(0, 0)});

        assertFalse(nextWorld.isAlive(new Cell(0, 0)));
    }

    @Test
    public void testCellWithOneNeighbourDies() {
        World nextWorld = generateNewWorldForCells(new Cell[]{
            new Cell(0, 0),
            new Cell(0, 1),});

        assertFalse(nextWorld.isAlive(new Cell(0, 0)));
    }

    @Test
    public void testCellWithTwoNeighboursLivesOn() {
        World nextWorld = generateNewWorldForCells(new Cell[]{
            new Cell(0, -1),
            new Cell(0, 0),
            new Cell(0, 1),});

        assertTrue(nextWorld.isAlive(new Cell(0, 0)));
    }

    @Test
    public void testCellWithThreeNeighboursLivesOn() {
        World nextWorld = generateNewWorldForCells(new Cell[]{
            new Cell(0, -1),
            new Cell(0, 0),
            new Cell(0, 1),
            new Cell(-1, 0),});

        assertTrue(nextWorld.isAlive(new Cell(0, 0)));
    }

    @Test
    public void testCellWithFourNeighboursDies() {
        World nextWorld = generateNewWorldForCells(new Cell[]{
            new Cell(0, -1),
            new Cell(0, 0),
            new Cell(0, 1),
            new Cell(-1, 0),
            new Cell(1, 0),});

        assertFalse(nextWorld.isAlive(new Cell(0, 0)));
    }

    @Test
    public void testCellWithFiveNeighboursDies() {
        World nextWorld = generateNewWorldForCells(new Cell[]{
            new Cell(0, -1),
            new Cell(0, 0),
            new Cell(0, 1),
            new Cell(-1, 0),
            new Cell(1, 0),
            new Cell(-1, -1),});

        assertFalse(nextWorld.isAlive(new Cell(0, 0)));
    }

    @Test
    public void testCellWithSixNeighboursDies() {
        World nextWorld = generateNewWorldForCells(new Cell[]{
            new Cell(0, -1),
            new Cell(0, 0),
            new Cell(0, 1),
            new Cell(-1, 0),
            new Cell(1, 0),
            new Cell(-1, -1),
            new Cell(1, 1),});

        assertFalse(nextWorld.isAlive(new Cell(0, 0)));
    }

    @Test
    public void testCellWithSevenNeighboursDies() {
        World nextWorld = generateNewWorldForCells(new Cell[]{
            new Cell(0, -1),
            new Cell(0, 0),
            new Cell(0, 1),
            new Cell(-1, 0),
            new Cell(1, 0),
            new Cell(-1, -1),
            new Cell(1, 1),
            new Cell(-1, 1),});

        assertFalse(nextWorld.isAlive(new Cell(0, 0)));
    }

    @Test
    public void testCellWithEightNeighboursDies() {
        World nextWorld = generateNewWorldForCells(new Cell[]{
            new Cell(0, -1),
            new Cell(0, 0),
            new Cell(0, 1),
            new Cell(-1, 0),
            new Cell(1, 0),
            new Cell(-1, -1),
            new Cell(1, 1),
            new Cell(-1, 1),
            new Cell(1, -1),});

        assertFalse(nextWorld.isAlive(new Cell(0, 0)));
    }
}
