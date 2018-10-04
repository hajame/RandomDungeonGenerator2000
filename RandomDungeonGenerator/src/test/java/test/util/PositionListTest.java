package test.util;

import dungeongenerator.util.NeighborList;
import dungeongenerator.util.Position;
import dungeongenerator.util.PositionList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hajame
 */
public class PositionListTest {

    private Position position;
    private PositionList list;
    private NeighborList neigbors;

    @Before
    public void setUp() {
        this.position = new Position(1, 2);
        this.list = new PositionList();
        this.neigbors = new NeighborList();
        list.add(position);
        neigbors.add(position);
    }

    @Test
    public void getTest() {
        assertEquals(1, list.get(0).x);
        assertEquals(2, list.get(0).y);
        list.poll();
        assertNull(list.get(0));
        list.poll();
        assertEquals(0, list.size());
    }

    @Test
    public void sizeTest() {
        assertEquals(1, list.size());
    }

    @Test
    public void pollTest() {
        Position pos = list.poll();
        assertEquals(position.x, pos.x);
        assertEquals(position.y, pos.y);
        assertEquals(0, list.size());
    }

    @Test
    public void pollRandomTest() {
        // 1 in list
        Position pos = neigbors.pollRandom();
        assertEquals(position, pos);
        assertEquals(0, neigbors.size());

        // empty list
        pos = neigbors.pollRandom();
        assertNull(pos);
        assertEquals(0, neigbors.size());

        // 3 in list
        Position one = new Position(1, 1);
        Position two = new Position(2, 2);
        Position three = new Position(3, 3);
        neigbors.add(one);
        neigbors.add(two);
        neigbors.add(three);
        pos = neigbors.pollRandom();
        if (pos == one) {
            assertEquals(pos, one);
            assertEquals(2, neigbors.size());
        }
        if (pos == two) {
            assertEquals(pos, two);
            assertEquals(2, neigbors.size());
        }
        if (pos == three) {
            assertEquals(pos, three);
            assertEquals(2, neigbors.size());
        }
    }

}
