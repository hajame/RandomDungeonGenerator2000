package test.domain;

import dungeongenerator.domain.Dungeon;
import dungeongenerator.domain.Room;
import dungeongenerator.util.Position;
import dungeongenerator.util.PositionList;
import java.awt.Point;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests Dungeon class
 *
 * @author hajame
 */
public class DungeonTest {

    private Dungeon dungeon;
    private Room room1;
    private Room room2;
    private Room room3;
    private Position firstPos;

    @Before
    public void setUp() {
        int dungeonHeight = 40;
        int dungeonWidth = 40;
        char[][] map = new char[dungeonHeight][dungeonWidth];
        this.firstPos = new Position(2, 2);
        this.dungeon = new Dungeon(map);
        this.room1 = new Room(new Position(7, 7), new Position(12, 12));
        this.room2 = new Room(new Position(0, 0), new Position(7, 7));
        this.room3 = new Room(new Position(7, 7),
                new Position(dungeonHeight, dungeonWidth));
    }

    @Test
    public void canBeFirstTest() {
        assertTrue(dungeon.canBeFirst(firstPos));
    }

    @Test
    public void cannotBeFirstTest() {
        assertFalse(dungeon.canBeFirst(new Position(1, 1)));
        dungeon.placeRoom(room1);
        assertFalse(dungeon.canBeFirst(new Position(7, 7)));
    }

    @Test
    public void isFreeTest() {
        dungeon.placeRoom(room1);
        dungeon.fill(new Position(8, 5), ' ');
        assertFalse(dungeon.isFree(new Position(7, 7)));
        assertFalse(dungeon.isFree(new Position(8, 6)));
        assertTrue(dungeon.isFree(new Position(7, 5)));
    }

    @Test
    public void getNeighborsTest() {
        dungeon.placeRoom(room1);
        Position newPos = new Position(8, 5);
        dungeon.fill(newPos, ' ');
        dungeon.fill(new Position(9, 4), ' ');        
        PositionList neigbors = dungeon.getNeighbors(newPos);
        assertEquals(new Position(7, 5), neigbors.get(0));
    }

    @Test
    public void canPlaceRoomTest() {
        assertEquals(true, dungeon.canBePlaced(room1));
    }

    @Test
    public void cantPlaceRoomOnMapBoarderTest() {
        assertEquals(false, dungeon.canBePlaced(room2));
        assertEquals(false, dungeon.canBePlaced(room3));
    }
}
