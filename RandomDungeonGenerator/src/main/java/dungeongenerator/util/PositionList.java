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

    public Position first() {
        return first;
    }
    
    public void setFirst(Position pos) {
        if(first != null) {
            if (pos == null) {
                first = null;
                return;
            }
            pos.setNext(first);
            first = pos;    
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

    public void decSize() {
        this.size--;
    }
    
    public Position poll() {
        Position pos = null;
        if (size > 0) {
            pos = first;
            first = pos.getNext();
            size--;
        }
        return pos;
    }
}
