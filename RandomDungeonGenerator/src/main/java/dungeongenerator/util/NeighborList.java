package dungeongenerator.util;

import java.util.Random;

/**
 * Used to store 1-4 neighbors for a position.
 * Can poll random neighbor from the list.
 *
 * @author hajame
 */
public class NeighborList extends PositionList {
    final Random random;
    
    public NeighborList() {
        this.random = new Random();
    }

    public Position pollRandom() {
        if (this.size() == 0) {
            return null;
        }
        if (this.size() == 1) {
            return poll(0);
        }
        int i = random.nextInt(this.size());
        Position pos = get(i);
        remove(i);
        return pos;
    }
}
