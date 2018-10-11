package dungeongenerator.util;

import dungeongenerator.domain.Room;

/**
 * ArrayList-type data structure containing Room objects. Will be replaced with
 * a custom model.
 *
 * @author hajame
 */
public class RoomList {

    private HarrayList<Room> list;
    private int size;

    public RoomList() {
        this.list = new HarrayList<>();
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
            return (Room) list.get(index);
        }
        return null;
    }

    public int size() {
        return size;
    }

    public void print() {
        System.out.println("RoomList, size: " + size);
        for (int i = 0; i < size; i++) {
            Room room = (Room) list.get(i);
            Position left = room.getLeftPosition();
            Position right = room.getRightPosition();
            System.out.println("Lx " + left.x + "\tLy " + left.x + "\tRx " + right.x + "\tRy " + right.y);
        }
    }
}
