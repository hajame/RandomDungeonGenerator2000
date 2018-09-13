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
        int roomMax = 10;
        // no. of attempts to place rooms.
        int roomPlacementAttempts = 1000;

        Generator generator = new Generator(dungeonHeight, dungeonWidth,
                roomMin, roomMax, roomPlacementAttempts);
        generator.generate();
        Dungeon dungeon = generator.getDungeon();

        char[][] map = dungeon.getMap();

        for (char[] array : map) {
            System.out.println(Arrays.toString(array));
        }
    }

}
