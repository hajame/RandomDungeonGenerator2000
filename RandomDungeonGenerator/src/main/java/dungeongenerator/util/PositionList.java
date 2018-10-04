package dungeongenerator.util;

import java.util.LinkedList;

/**
 * LinkedList-type data structure containing Position objects. Will be replaced
 * with a custom model.
 *
 * @author hajame
 */
public class PositionList {

    private LinkedList<Position> list;
    private Position first;
    private int size;

    public PositionList() {
        this.list = new LinkedList<>();
        this.first = null;
        this.size = 0;
    }

    public void add(Position position) {
        position.setNext(first);
        first = position;
        size += 1;
    }

    public void remove(int index) {
        if (size > index && index > -1) {
            Position previous = null;
            Position current = first;
            for (int i = 1; i < index + 1; i++) {
                previous = current;
                current = current.getNext();
            }
            if (previous != null) {
                previous.setNext(current.getNext());
            } else {
                first = current.getNext();
            }
            size -= 1;
        }
    }

    public Position get(int index) {
        if (size == 0 || size <= index || index < 0) {
            return null;
        }
        Position pos = first;
        for (int i = 1; i < index + 1; i++) {
            pos = pos.getNext();
        }
        return pos;
    }

    public int size() {
        return size;
    }

    public Position poll() {
        Position pos = get(0);
        if (pos != null) {
            remove(0);
        }
        return pos;
    }

    public Position poll(int index) {
        if (size > index && index > -1) {
            Position previous = null;
            Position current = first;
            for (int i = 1; i < index; i++) {
                previous = current;
                current = current.getNext();
            }
            if (previous != null) {
                previous.setNext(current.getNext());
            } else {
                first = current.getNext();
            }
            size -= 1;
            return current;
        } else {
            return null;
        }
    }
}
