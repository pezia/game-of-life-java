package eu.marbledigital.gameoflife;

import java.util.HashSet;
import java.util.List;

/**
 * World class Contains the alive Cell objects
 *
 * @author Zsolt Petrik
 */
public class World extends HashSet<Cell> {

    public boolean isAlive(Cell cell) {
        return this.contains(cell);
    }

    @Override
    public boolean add(Cell cell) {
        return super.add(cell);
    }

    public int getLivingNeighbourCount(Cell cell) {
        int neighbourCount = 0;

        for(Cell neighbour : cell.getNeighbours()) {
            if(this.contains(neighbour)) {
                neighbourCount++;
            }
        }

        return neighbourCount;
    }
}
