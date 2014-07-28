/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.marbledigital.gameoflife;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zsolt
 */
public class World extends ArrayList<Cell> {

    public boolean isAlive(Cell cell) {
        return this.contains(cell);
    }

    @Override
    public boolean add(Cell cell) {
        return super.add(cell);
    }

    public int getLivingNeighbourCount(Cell cell) {
        int neighbourCount = 0;

        List<Cell> neighbours = cell.getNeighbours();

        for (Cell livingCell : this) {
            if (neighbours.contains(livingCell)) {
                neighbourCount++;
            }
        }
        return neighbourCount;
    }
}
