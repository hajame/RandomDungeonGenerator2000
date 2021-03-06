package dungeongenerator.domain;

import dungeongenerator.util.Direction;
import dungeongenerator.util.NeighborList;
import dungeongenerator.util.Position;
import dungeongenerator.util.PositionList;
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
    final PositionList deadEnds;

    public Generator(int dungeonHeight, int dungeonWidth, int roomMin,
            int roomMax, int roomAmount) {
        this.dungeonHeight = dungeonHeight;
        this.dungeonWidth = dungeonWidth;
        this.roomMin = roomMin;
        this.roomMax = roomMax;
        this.roomAmount = roomAmount;
        this.deadEnds = new PositionList();
        this.random = new Random();
        char[][] map = new char[dungeonHeight][dungeonWidth];
        this.dung = new Dungeon(map);
    }

    /**
     * Generates a random dungeon from an initialized map.
     */
    public void generateDungeon() {
        generateRooms();
        boolean mazeGenerated = generateMaze();
        while (!mazeGenerated) {
            mazeGenerated = generateMaze();
        }
        generateDoors();
        deleteDeadEnds();
        clean();
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
     * Randomly fills the dungeon's empty space with a maze.
     */
    public boolean generateMaze() {
        Position start = findNextFree(random.nextInt(
                dungeonWidth / 2 + 2), dungeonHeight / 2 + 2);
        if (start == null) {            // if couldn't find random start position
            start = findNextFree(2, 2); // check if one exists
            if (start == null) {
                return true;            // maze complete
            }
        }
        dung.fill(start, ' ');
        PositionList waitingList = new PositionList();
        waitingList.add(start);
        Direction dir = Direction.RIGHT;
        while (waitingList.size() > 0) {
            Position pos = waitingList.poll();
            NeighborList neighbors = dung.getFreeNeighbors(pos);
            Position neighbor = null;
            for (int i = 0; i < neighbors.size(); i++) {
                if (neighbors.get(i).getDirectionFrom(pos) == dir) {
                    if (random.nextInt(7) > 2) { // increase chance to continue straight
                        neighbor = neighbors.poll(i);
                        break;
                    } else {
                        break;
                    }
                }
            }
            if (neighbor == null) {
                neighbor = neighbors.pollRandom();
            }
            if (neighbor != null) {
                dir = neighbor.getDirectionFrom(pos); // update new direction
                dung.fill(neighbor, ' ');
                waitingList.add(neighbor);
            }
            if (neighbors.size() != 0) {
                waitingList.add(pos);   // back to list if still has room to expand
            } else {
                if (dung.isDeadEnd(pos)) {
                    deadEnds.add(pos);
                    dir = Direction.RIGHT;
                }
            }
        }
        start = findNextFree(2, 2); // checks if there is a spot to build more maze
        if (start != null) {
            return false;           // maze not complete
        }
        return true;                // maze complete
    }

    /**
     * Finds a beginning point for maze building.
     *
     * @return Position nextFree
     */
    public Position findNextFree(int xPos, int yPos) {
        Position pos = new Position(xPos, yPos);
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

    /**
     * Generates doors randomly wherever a door can be placed in a room.
     */
    public void generateDoors() {
        if (dung.getRooms().size() == 0) {
            return;
        }
        for (int i = 0; i < dung.getRooms().size(); i++) {
            PositionList doorSegments = dung.getRooms().get(i).connectingSegments(dung);
            Position door = doorSegments.get(random.nextInt(doorSegments.size()));
            if (door != null) {
                dung.fill(door, '+');
            }
        }
    }

    /**
     * Fills all such squares of corridor where the square is neighbored by
     * three walls.
     */
    public void deleteDeadEnds() {
        while (deadEnds.size() > 0) {
            Position pos = deadEnds.poll();
            if (!dung.isDeadEnd(pos)) {
                continue;
            }
            dung.fill(pos, '█');
            pos = dung.findOpenNeighbor(pos);
            if (pos != null) {
                if (dung.isDeadEnd(pos)) {
                    deadEnds.add(pos);
                }
            }
        }
    }

    /**
     * Fills the rooms with space chars.
     */
    public void clean() {
        for (int y = 1; y < dung.getMap()[0].length; y++) {
            for (int x = 1; x < dung.getMap().length; x++) {
                char a = dung.getMap()[x][y];
                if (a == 'X') {
                    dung.fill(new Position(x, y), ' ');
                }
            }
        }
    }

    public Dungeon getDungeon() {
        return dung;
    }
}
