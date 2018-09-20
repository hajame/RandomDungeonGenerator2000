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
        int dungeonWidth = 80;

        // max and min values for room edges
        int roomMin = 7;
        int roomMax = 13;
        // no. of attempts to place rooms.
        int roomPlacementAttempts = 100;

        Generator generator = new Generator(dungeonHeight, dungeonWidth,
                roomMin, roomMax, roomPlacementAttempts);
        generator.generateRooms();
        Dungeon dungeon = generator.getDungeon();
        generator.generateMaze();

        char[][] map = dungeon.getMap();

        for (char[] array : map) {
            System.out.println(Arrays.toString(array));
        }
        dungeon.getRooms().print();
    }

}
