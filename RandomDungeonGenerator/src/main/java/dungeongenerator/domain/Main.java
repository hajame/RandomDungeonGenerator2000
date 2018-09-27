package dungeongenerator.domain;

/**
 * Main class
 *
 * @author hajame
 */
public class Main {

    public static void main(String[] args) {

        int dungeonHeight = 100;
        int dungeonWidth = 100;

        // max and min values for room edges
        int roomMin = 5;
        int roomMax = 10;
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
