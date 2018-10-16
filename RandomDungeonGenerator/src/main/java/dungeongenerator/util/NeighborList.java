package dungeongenerator.util;

import java.util.Random;

/**
 * Used to store the neighbors of a Position.
 * Can poll random neighbor from the list.
 *
 * @author hajame
 */
public class NeighborList extends PositionList {
    final Random random;
    
    public NeighborList() {
        this.random = new Random();
    }
    
    /**
     * Removes and returns a random Position from the list
     * @return random Position
     */
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
