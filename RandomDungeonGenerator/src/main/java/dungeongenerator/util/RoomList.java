package dungeongenerator.util;

import dungeongenerator.domain.Room;
import java.util.ArrayList;

/**
 * ArrayList-type data structure containing Room objects. Will be replaced with
 * a custom model.
 *
 * @author hajame
 */
public class RoomList {

    private ArrayList<Room> list;
    private int size;

    public RoomList() {
        this.list = new ArrayList<>();
        this.size = 0;
    }

    public void add(Room room) {
        list.add(room);
        size += 1;
    }

    public void remove(int index) {
        if (size != 0 && index < size) {
            list.remove(index);
            size -= 1;
        }
    }

    public Room get(int index) {
        if (size != 0 && index < size) {
            return list.get(index);
        }
        return null;
    }

    public int size() {
        return size;
    }

    public void print() {
        System.out.println("RoomList, size: " + size);
        for (Room room : list) {
            Position left = room.getLeftPosition();
            Position right = room.getRightPosition();
            System.out.println("Lx " + left.x + "\tLy " + left.x + "\tRx " + right.x + "\tRy " + right.y);
        }
    }
}
