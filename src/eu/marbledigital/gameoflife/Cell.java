package eu.marbledigital.gameoflife;

import java.util.ArrayList;
import java.util.List;

/**
 * Cell Represents a 2D, square shaped cell
 *
 * @author Zsolt Petrik
 */
public class Cell {

    private int x;
    private int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Cell)) {
            return false;
        }

        Cell otherCell = (Cell) other;

        return this.x == otherCell.x && this.y == otherCell.y;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.x;
        hash = 89 * hash + this.y;
        return hash;
    }

    public List<Cell> getNeighbours() {
        ArrayList<Cell> neighbours = new ArrayList<>(8);

        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0) {
                    continue;
                }

                neighbours.add(new Cell(this.x + dx, this.y + dy));
            }
        }

        return neighbours;
    }
}
