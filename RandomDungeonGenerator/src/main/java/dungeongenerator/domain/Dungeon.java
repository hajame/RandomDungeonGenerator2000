package dungeongenerator.domain;

import dungeongenerator.util.Position;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * Class for handling map information and functions.
 *
 * @author hajame
 */
public class Dungeon {

    private char[][] map;
    private ArrayList<Room> rooms;

    public Dungeon(char[][] map) {
        this.map = map;
        init();
    }

    public void init() {
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

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public void placeRoom(Room room) {
        // todo
    }

    /**
     * Checks if given room overlaps with a room that is already in place.
     *
     * @param room
     */
    public boolean canBePlaced(Room room) {
        Position leftPos = room.getLeftPosition();
        Position rightPos = room.getRightPosition();
        for (int y = leftPos.y; y <= rightPos.y; y++) {
            for (int x = leftPos.x; x <= rightPos.x; x++) {
                if (map[x][y] != '█') {
                    return false;
                }
            }
        }
        return true;
    }

}
