package test.util;

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

    @Before
    public void setUp() {
        this.position = new Position(1, 2);
        this.list = new PositionList();
        list.add(position);
    }

    @Test
    public void getTest() {
        assertEquals(1, list.get(0).x);
        assertEquals(2, list.get(0).y);
        list.remove(0);
        assertNull(list.get(0));
    }
    
    @Test
    public void removeTest() {
        list.remove(0);
        assertEquals(0, list.size());
        list.remove(0);
        assertEquals(0, list.size());
    }
    
    @Test
    public void sizeTest() {
        assertEquals(1, list.size());
    }
    
    @Test
    public void pollTest() {
        Position pos = list.poll(0);
        assertEquals(position.x, pos.x);
        assertEquals(position.y, pos.y);
        assertEquals(0, list.size());
    }
    
    @Test
    public void pollRandomTest() {
        // 1 in list
        Position pos = list.pollRandom();
        assertEquals(position, pos);
        assertEquals(0, list.size());
        
        // empty list
        pos = list.pollRandom();
        assertNull(pos);
        assertEquals(0, list.size());
        

        // 3 in list
        Position one = new Position(1, 1);
        Position two = new Position(2, 2);
        Position three = new Position(3, 3);
        list.add(one);
        list.add(two);
        list.add(three);
        pos = list.pollRandom();
        if(pos == one) {
            assertEquals(pos, one);
            assertEquals(2, list.size());
        }
        if(pos == two) {
            assertEquals(pos, two);
            assertEquals(2, list.size());
        }
        if(pos == three) {
            assertEquals(pos, three);
            assertEquals(2, list.size());
        }
    }
    
}
