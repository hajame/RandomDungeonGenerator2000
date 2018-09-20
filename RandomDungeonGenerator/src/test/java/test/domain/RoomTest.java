package test.domain;

import dungeongenerator.util.Position;
import dungeongenerator.domain.Room;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests Room class
 * 
 * @author hajame
 */
public class RoomTest {

    private Room room;
    private Room comp;

    @Before
    public void setUp() {
        Position left = new Position(5, 5);
        Position right = new Position(5, 5);
        this.room = new Room(left, right);
        this.comp = new Room(left, right, true);
    }

    @Test
    public void noDoorTest() {
        assertFalse(room.hasDoor());
    }

    @Test
    public void setHasDoorTest() {
        room.setHasDoor(true);
        assertTrue(room.hasDoor());
    }

    @Test
    public void hasDoorConstructorTest() {
        assertTrue(comp.hasDoor());
    }
}
