package dungeongenerator.domain;

/**
 * Main class
 *
 * @author hajame
 */
public class Main {

    public static void main(String[] args) {

        int dungeonHeight = 500;
        int dungeonWidth = 500;

        // max and min values for room edges
        int roomMin = 25;
        int roomMax = 50;
        // no. of attempts to place rooms.
        int roomPlacementAttempts = 500;

        Generator generator = new Generator(dungeonHeight, dungeonWidth,
                roomMin, roomMax, roomPlacementAttempts);

        generator.generateDungeon();

        Dungeon dungeon = generator.getDungeon();
        char[][] map = dungeon.getMap();

        dungeon.print();
        dungeon.getRooms().print();
    }

}
