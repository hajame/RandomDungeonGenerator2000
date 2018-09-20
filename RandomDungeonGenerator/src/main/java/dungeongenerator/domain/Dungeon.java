package dungeongenerator.domain;

import dungeongenerator.util.Position;
import dungeongenerator.util.PositionList;
import dungeongenerator.util.RoomList;

/**
 * Class for handling map information and functions.
 *
 * @author hajame
 */
public class Dungeon {

    private char[][] map;
    private RoomList rooms;

    public Dungeon(char[][] map) {
        this.map = map;
        this.rooms = new RoomList();
        initMap();
    }

    public void initMap() {
        for (int y = 0; y < map[0].length; y++) {
            for (int x = 0; x < map.length; x++) {

                if (y == 0 || y == map[0].length - 1 || x == 0 || x == map.length - 1) {
                    map[x][y] = 'x';
                } else {
                    map[x][y] = '█';
                }
            }
        }
    }

    public char[][] getMap() {
        return map;
    }

    public void fill(Position pos, char a) {
        map[pos.x][pos.y] = a;
    }

    /**
     * Checks if the cell can be an opener for maze generation
     *
     * @param pos
     * @return true if is free and has 4 free neighbors.
     */
    public boolean canBeFirst(Position pos) {
        int x = pos.x;
        int y = pos.y;

        if (map[x][y] == '█'
                && map[x + 1][y] == '█'
                && map[x - 1][y] == '█'
                && map[x][y + 1] == '█'
                && map[x][y - 1] == '█') {
            return true;
        }
        return false;
    }

    /**
     * Checks if the cell has 3 or more free neighbors.
     *
     * @param pos
     * @return true if free with 3 free neighbors.
     */
    public boolean isFree(Position pos) {
        int x = pos.x;
        int y = pos.y;
        if (map[x][y] == '█') {
            int freeNeighbors = 0;
            if (map[x + 1][y] == '█') {
                freeNeighbors++;
            }
            if (map[x - 1][y] == '█') {
                freeNeighbors++;
            }
            if (map[x][y + 1] == '█') {
                freeNeighbors++;
            }
            if (map[x][y - 1] == '█') {
                freeNeighbors++;
            }
            // true if there are 3 or more free neighbors
            if (freeNeighbors >= 3) {
                return true;
            }
        }
        return false;
    }

    public PositionList getNeighbors(Position pos) {
        PositionList neighbors = new PositionList();
        int x = pos.x;
        int y = pos.y;

        Position right = new Position(x + 1, y);
        if (isFree(right)) {
            neighbors.add(right);
        }
        Position left = new Position(x - 1, y);
        if (isFree(left)) {
            neighbors.add(left);
        }
        Position top = new Position(x, y + 1);
        if (isFree(top)) {
            neighbors.add(top);
        }
        Position down = new Position(x, y - 1);
        if (isFree(down)) {
            neighbors.add(down);
        }
        return neighbors;
    }

    public void setMap(char[][] map) {
        this.map = map;
    }

    public RoomList getRooms() {
        return rooms;
    }

    public void setRooms(RoomList rooms) {
        this.rooms = rooms;
    }

    /**
     * Places a room if it doesn't collide with other rooms.
     *
     * @param room
     */
    public void placeRoom(Room room) {
        if (!canBePlaced(room)) {
            return;
        }
        Position leftPos = room.getLeftPosition();
        Position rightPos = room.getRightPosition();
        for (int y = leftPos.y; y <= rightPos.y; y++) {
            for (int x = leftPos.x; x <= rightPos.x; x++) {
                map[x][y] = 'X';
            }
        }
    }

    /**
     * Checks if given room overlaps with a room that is already in place.
     *
     * @param room
     */
    public boolean canBePlaced(Room room) {
        if (room == null) {
            return false;
        }
        Position leftPos = room.getLeftPosition();
        Position rightPos = room.getRightPosition();
        for (int y = leftPos.y; y <= rightPos.y; y++) {
            for (int x = leftPos.x; x <= rightPos.x; x++) {
                if (map[x][y] != '█') {
                    return false;
                }
            }
        }
        rooms.add(room);
        return true;
    }

    public void print() {

        for (char[] array : map) {
            System.out.println(String.valueOf(array));
        }

    }

}
