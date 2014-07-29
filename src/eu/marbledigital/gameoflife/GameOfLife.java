package eu.marbledigital.gameoflife;

/**
 * GameOfLife game logic
 *
 * @author Zsolt Petrik
 */
public class GameOfLife {

    public World generateNext(World world) {
        World nextWorld = new World();

        for (Cell cell : world) {
            int livingNeighbourCount = world.getLivingNeighbourCount(cell);
            if (livingNeighbourCount == 2 || livingNeighbourCount == 3) {
                nextWorld.add(cell);
            }
        }

        return nextWorld;
    }

}
