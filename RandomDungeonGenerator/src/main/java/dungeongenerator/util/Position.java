package dungeongenerator.util;

/**
 * Class that holds values for x and y positions. Intended to be modified from
 * the outside.
 *
 * @author hajame
 */
public class Position {

    public int x;
    public int y;
    private Position next;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
        this.next = null;
    }

    public Position getNext() {
        return next;
    }

    public void setNext(Position next) {
        this.next = next;
    }

    /**
     * @param pos
     * @return Direction in relation to given Position
     */
    public Direction getDirectionFrom(Position pos) {
        if (pos.y == this.y) {
            if (pos.x == this.x - 1) {
                return Direction.RIGHT;
            }
            if (pos.x == this.x + 1) {
                return Direction.LEFT;
            }
        }
        if (pos.x == this.x) {
            if (pos.y == this.y + 1) {
                return Direction.UP;
            }
            if (pos.y == this.y - 1) {
                return Direction.DOWN;
            }
        }
        return null;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof Position) {
            Position position = (Position) obj;
            return position.x == this.x && position.y == this.y;
        }
        return false;
    }

}
