package dungeongenerator.domain;

import dungeongenerator.util.Position;
import java.util.Random;

/**
 * Class responsible for random Dungeon creation.
 *
 * @author hajame
 */
public class Generator {

    final int dungeonHeight;
    final int dungeonWidth;
    final int roomMin;
    final int roomMax;
    final int roomAmount;
    private Dungeon dungeon;

    public Generator(int dungeonHeight, int dungeonWidth, int roomMin,
            int roomMax, int roomAmount) {
        this.dungeonHeight = dungeonHeight;
        this.dungeonWidth = dungeonWidth;
        this.roomMin = roomMin;
        this.roomMax = roomMax;
        this.roomAmount = roomAmount;
    }

    public void generate() {
        char[][] map = new char[dungeonHeight][dungeonWidth];

        this.dungeon = new Dungeon(map);
        Random random = new Random();

        for (int i = 0; i < roomAmount; i++) {
            Position leftPosition = new Position(
                    random.nextInt(dungeonHeight - 2) + 1,
                    random.nextInt(dungeonWidth - 2) + 1);
            Position rightPosition = new Position(
                    random.nextInt(roomMax - roomMin) + leftPosition.x + roomMin,
                    random.nextInt(roomMax - roomMin) + leftPosition.y + roomMin);
            Room room = new Room(leftPosition, rightPosition);
            dungeon.placeRoom(room);
        }

    }

    public Dungeon getDungeon() {
        return dungeon;
    }

}
