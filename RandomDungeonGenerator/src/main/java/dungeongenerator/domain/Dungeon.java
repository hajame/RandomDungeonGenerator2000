package dungeongenerator.domain;

import dungeongenerator.util.Position;
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
        if(room == null) {
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

}
