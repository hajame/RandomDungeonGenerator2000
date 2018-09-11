package dungeongenerator.domain;
import dungeongenerator.util.Position;

/**
 *
 * Class for holding Room information.
 * 
 * @author hajame
 */
public class Room {
    private Position leftPosition;
    private Position rightPosition;
    private boolean hasDoor;

    public Room(Position leftPosition, Position rightPosition) {
        this.leftPosition = leftPosition;
        this.rightPosition = rightPosition;
        this.hasDoor = false;
    }

    public Room(Position leftPosition, Position rightPosition, boolean hasDoor) {
        this.leftPosition = leftPosition;
        this.rightPosition = rightPosition;
        this.hasDoor = hasDoor;
    }

    public Position getLeftPosition() {
        return leftPosition;
    }

    public Position getRightPosition() {
        return rightPosition;
    }

    public boolean hasDoor() {
        return hasDoor;
    }

    public void setHasDoor(boolean hasDoor) {
        this.hasDoor = hasDoor;
    }
    
}
