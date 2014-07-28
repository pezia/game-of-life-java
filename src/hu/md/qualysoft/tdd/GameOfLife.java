package hu.md.qualysoft.tdd;

public class GameOfLife {

    public World getNextWorld(World world) {
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
