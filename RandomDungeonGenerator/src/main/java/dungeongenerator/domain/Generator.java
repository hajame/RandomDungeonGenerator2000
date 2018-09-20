package dungeongenerator.domain;

import dungeongenerator.util.Position;
import java.util.Random;

/**
 * Class responsible for random Dungeon creation.
 *
 * @author hajame
 */
public class Generator {

    final Dungeon dung;
    final Random random;
    final int dungeonHeight;
    final int dungeonWidth;
    final int roomMin;
    final int roomMax;
    final int roomAmount;

    public Generator(int dungeonHeight, int dungeonWidth, int roomMin,
            int roomMax, int roomAmount) {
        this.dungeonHeight = dungeonHeight;
        this.dungeonWidth = dungeonWidth;
        this.roomMin = roomMin;
        this.roomMax = roomMax;
        this.roomAmount = roomAmount;
        this.random = new Random();
        char[][] map = new char[dungeonHeight][dungeonWidth];
        this.dung = new Dungeon(map);
    }
    
    /**
     * Generates rooms randomly with the given amount of attempts.
     */
    public void generateRooms() {
        for (int i = 0; i < roomAmount; i++) {
            Position leftPosition = new Position(
                    random.nextInt(dungeonHeight - 2) + 1,
                    random.nextInt(dungeonWidth - 2) + 1);
            Position rightPosition = new Position(
                    random.nextInt(roomMax - roomMin) + leftPosition.x + roomMin,
                    random.nextInt(roomMax - roomMin) + leftPosition.y + roomMin);
            Room room = new Room(leftPosition, rightPosition);
            dung.placeRoom(room);
        }
    }

    /**
     * Fills the dungeon's empty space with a maze.
     */
    public void generateMaze() {
        Position pos = findNextFree();
        
        if (pos != null) {
            dung.fill(pos, ' ');
        }
    }

    /**
     *
     * Finds a beginning point for maze building.
     *
     * @return Position nextFree
     */
    public Position findNextFree() {
        Position pos = new Position(2, 2);
        for (int y = 2; y < dung.getMap()[0].length; y++) {
            pos.y = y;
            for (int x = 2; x < dung.getMap().length; x++) {
                pos.x = x;
                char a = dung.getMap()[x][y];
                if (a == 'x' || a == 'X') {
                } else {
                    if (dung.canBeFirst(pos)) {
                        return pos;
                    }
                }
            }
        }
        return null;
    }
    
    public Position chooseRandomNeighbor(Position pos) {
        // todo
        
        return null;
    }

    public Dungeon getDungeon() {
        return dung;
    }
}
