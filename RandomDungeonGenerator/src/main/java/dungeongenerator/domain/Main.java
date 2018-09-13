package dungeongenerator.domain;

import dungeongenerator.util.Position;
import java.util.Arrays;
import java.util.Random;

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
        char[][] map = new char[dungeonHeight][dungeonWidth];

        Dungeon dungeon = new Dungeon(map);
        Random random = new Random();

        for (int i = 0; i < 1000; i++) {
            Position leftPosition = new Position(
                    random.nextInt(dungeonHeight - 2) + 1,
                    random.nextInt(dungeonWidth - 2) + 1);
            Position rightPosition = new Position(
                    random.nextInt(roomMax - roomMin) + leftPosition.x + roomMin,
                    random.nextInt(roomMax - roomMin) + leftPosition.y + roomMin);
            Room room = new Room(leftPosition, rightPosition);
            dungeon.placeRoom(room);
        }

        map = dungeon.getMap();

        for (char[] array : map) {
            System.out.println(Arrays.toString(array));
        }

        Room room1 = new Room(new Position(2, 2), new Position(7, 7));
        Room room2 = new Room(new Position(0, 0), new Position(7, 7));
        Room room3 = new Room(new Position(2, 2), new Position(dungeonWidth, dungeonHeight));

        System.out.println(dungeon.canBePlaced(room1));
        System.out.println(dungeon.canBePlaced(room2));
        System.out.println(dungeon.canBePlaced(room3));

    }

}
