package dungeongenerator.util;

import java.util.Random;

/**
 * Stores 1-4 neighbors for a position
 *
 * @author hajame
 */
public class NeighborList extends PositionList {

    public NeighborList() {
    }

    public Position pollRandom() {
        if (super.size() == 0) {
            return null;
        }
        if (super.size() == 1) {
            return poll(0);
        }
        int i = random.nextInt(super.size());
        Position pos = get(i);
        remove(i);
        return pos;
    }
}
