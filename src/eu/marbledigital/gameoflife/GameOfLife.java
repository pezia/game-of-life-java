package eu.marbledigital.gameoflife;

import java.util.HashSet;
import java.util.Set;

/**
 * GameOfLife game logic
 *
 * @author Zsolt Petrik
 */
public class GameOfLife {

    public World generateNext(World world) {
        World nextWorld = new World();

        Set<Cell> possibleBirths = new HashSet<>();

        for (Cell cell : world) {
            possibleBirths.addAll(cell.getNeighbours());
            int livingNeighbourCount = world.getLivingNeighbourCount(cell);
            if (livingNeighbourCount == 2 || livingNeighbourCount == 3) {
                nextWorld.add(cell);
            }
        }

        for (Cell possibleBirth : possibleBirths) {
            if (!world.isAlive(possibleBirth) && world.getLivingNeighbourCount(possibleBirth) == 3) {
                nextWorld.add(possibleBirth);
            }
        }

        return nextWorld;
    }

}
