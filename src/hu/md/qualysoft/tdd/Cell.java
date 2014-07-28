/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.md.qualysoft.tdd;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zsolt
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
