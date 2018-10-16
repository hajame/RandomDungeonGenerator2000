package test.domain;

import dungeongenerator.domain.Dungeon;
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
        Position left = new Position(4, 4);
        Position right = new Position(6, 6);
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
    
    @Test
    public void noConnectingSegmentsTest() {
        Dungeon dung = new Dungeon(new char[10][10]);
        dung.placeRoom(room);
        assertTrue(room.connectingSegments(dung).size() == 0);
    }
}
