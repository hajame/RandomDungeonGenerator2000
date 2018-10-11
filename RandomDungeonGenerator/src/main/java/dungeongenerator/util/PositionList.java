package dungeongenerator.util;

/**
 * List containing Position objects. Uses a custom ArrayList implementation.
 *
 * @author hajame
 */
public class PositionList {

    private HarrayList<Position> list;
    private int size;

    public PositionList() {
        this.list = new HarrayList<>();
        this.size = 0;
    }

    public void add(Position position) {
        list.add(position);
        size += 1;
    }

    public void remove(int index) {
        if (size > 0) {
            list.remove(index);
            size -= 1;
        }
    }

    public Position get(int i) {
        if (size == 0) {
            return null;
        }
        return (Position) list.get(i);
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
    
    public Position poll(int i) {
        Position pos = get(i);
        if (pos != null) {
            remove(i);
        }
        return pos;
    }
}
