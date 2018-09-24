package test.util;

import dungeongenerator.domain.Room;
import dungeongenerator.util.Position;
import dungeongenerator.util.RoomList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hajame
 */
public class RoomListTest {

    private Room room1;
    private RoomList list;
    private Position leftPos;
    private Position rightPos;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp() {
        leftPos = new Position(1, 1);
        rightPos = new Position(5, 5);
        this.room1 = new Room(leftPos, rightPos);
        this.list = new RoomList();
        list.add(room1);

        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void getTest() {
        assertEquals(leftPos, list.get(0).getLeftPosition());
        assertEquals(rightPos, list.get(0).getRightPosition());
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
    public void printTest() {
        list.print();
        assertEquals("RoomList, size: 1\nLx 1\tLy 1\tRx 5\tRy 5\n", outContent.toString());
    }
}
