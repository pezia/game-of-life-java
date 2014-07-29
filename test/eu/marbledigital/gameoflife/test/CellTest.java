package eu.marbledigital.gameoflife.test;

import eu.marbledigital.gameoflife.Cell;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Cell tests
 *
 * @author Zsolt Petrik
 */
public class CellTest {

    @Test
    public void testEqual() {
        Cell cell1 = new Cell(0, 0);
        Cell cell2 = new Cell(0, 0);

        assertTrue(cell1.equals(cell2));
    }

    @Test
    public void testNotEqual() {
        Cell cell1 = new Cell(0, 0);
        Cell cell2 = new Cell(0, 1);

        assertFalse(cell1.equals(cell2));
    }

    
    @Test
    public void testNeighbours() {
        Cell cell = new Cell(0, 0);
        List<Cell> neighbours = cell.getNeighbours();
        assertEquals(8, neighbours.size());
        assertTrue(neighbours.contains(new Cell(-1, -1)));
        assertTrue(neighbours.contains(new Cell(1, 1)));
        assertFalse(neighbours.contains(new Cell(0, 0)));
    }
}
