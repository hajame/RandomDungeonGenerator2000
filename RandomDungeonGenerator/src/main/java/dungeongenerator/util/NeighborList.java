package dungeongenerator.util;

import java.util.Random;

/**
 * Used to store 1-4 neighbors for a position. Can poll random neighbor from the
 * list.
 *
 * @author hajame
 */
public class NeighborList extends PositionList {

    final Random random;

    public NeighborList() {
        this.random = new Random();
    }

    public void remove(int index) {
        if (size() > index && index == 0) {
            setFirst(first().getNext());
            decSize();
        } else if (size() > index && index > 0) {
            Position previous = null;
            Position current = first();
            for (int i = 1; i < index + 1; i++) {
                previous = current;
                current = current.getNext();
            }
            if (previous != null) {
                previous.setNext(current.getNext());
            } else {
                setFirst(current.getNext());
            }
            decSize();
        }
    }

    public Position poll(int index) {
        if (size() > 0 && index >= 0) {
            Position previous = null;
            Position current = first();
            for (int i = 1; i < index; i++) {
                previous = current;
                current = current.getNext();
            }
            if (previous != null) {
                previous.setNext(current.getNext());
            } else if (current.getNext() != null) {
                setFirst(current.getNext());
            } else {
                setFirst(null);
            }
            decSize();
            return current;
        }
        return null;
    }

    public Position pollRandom() {
        if (this.size() == 0) {
            return null;
        }
        if (this.size() == 1) {
            return poll();
        }
        int i = random.nextInt(this.size());
        Position pos = poll(i);
        return pos;
    }

}
