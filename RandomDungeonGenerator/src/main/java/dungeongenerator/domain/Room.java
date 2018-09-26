package dungeongenerator.domain;

import dungeongenerator.util.Position;
import dungeongenerator.util.PositionList;

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

    /**
     * @return List of wall segments that can connect to a maze via door.
     */
    public PositionList connectingSegments(Dungeon dungeon) {
        PositionList doorCandidates = new PositionList();
        char[][] map = dungeon.getMap();
        for (int y = leftPosition.y; y <= rightPosition.y; y++) {
            if (map[leftPosition.x - 1][y] == '█' && map[leftPosition.x - 2][y] == ' ') {
                doorCandidates.add(new Position(leftPosition.x - 1, y));
            }
            if (map[rightPosition.x + 1][y] == '█' && map[rightPosition.x + 2][y] == ' ') {
                doorCandidates.add(new Position(rightPosition.x + 1, y));
            }
        }
        for (int x = leftPosition.x; x <= rightPosition.x; x++) {
            if (map[x][leftPosition.y - 1] == '█' && map[x][leftPosition.y - 2] == ' ') {
                doorCandidates.add(new Position(x, leftPosition.y - 1));
            }
            if (map[x][rightPosition.y + 1] == '█' && map[x][rightPosition.y + 2] == ' ') {
                doorCandidates.add(new Position(x, rightPosition.y + 1));
            }
        }
        return doorCandidates;
    }

}
