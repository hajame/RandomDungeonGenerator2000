package test.util;

import dungeongenerator.util.Position;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hajame
 */
public class PositionTest {

    private Position position;
    private Position next;

    @Before
    public void setUp() {
        this.position = new Position(1, 1);
        this.next = new Position(2, 1);
    }
    
    @Test
    public void settersAndGettersTest() {
        position.setNext(next);
        assertEquals(position.x, 1);
        assertEquals(position.y, 1);
        assertEquals(next, position.getNext());
    }
    
    @Test
    public void equalsTest() {
        assertTrue(position.equals(new Position(1, 1)));
        assertFalse(position.equals(new Position(1, 2)));
        assertFalse(position.equals(new Position(2, 1)));
        Position pos = null;
        assertFalse(position.equals(pos));
        assertFalse(position.equals(5));
    }
}
