package dungeongenerator.domain;

import java.util.Arrays;

/**
 * Main class
 *
 * @author hajame
 */
public class Main {

    public static void main(String[] args) {

        int dungeonHeight = 50;
        int dungeonWidth = 110;

        // max and min values for room edges
        int roomMin = 5;
        int roomMax = 10;
        // no. of attempts to place rooms.
        int roomPlacementAttempts = 50;

        Generator generator = new Generator(dungeonHeight, dungeonWidth,
                roomMin, roomMax, roomPlacementAttempts);
        generator.generateRooms();
        Dungeon dungeon = generator.getDungeon();
        generator.generateMaze();

        char[][] map = dungeon.getMap();

        for (char[] array : map) {
            System.out.println(Arrays.toString(array));
        }
        dungeon.print();
        dungeon.getRooms().print();
    }

}
