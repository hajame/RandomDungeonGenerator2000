package test.domain;

import dungeongenerator.domain.Dungeon;
import dungeongenerator.domain.Room;
import dungeongenerator.util.Position;
import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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

    @Before
    public void setUp() {
        int dungeonHeight = 40;
        int dungeonWidth = 40;
        char[][] map = new char[dungeonWidth][dungeonHeight];

        this.dungeon = new Dungeon(map);
        this.room1 = new Room(new Position(2, 2), new Position(7, 7));
        this.room2 = new Room(new Position(0, 0), new Position(7, 7));
        this.room3 = new Room(new Position(2, 2),
                new Position(dungeonWidth, dungeonHeight));
    }

    @Test
    public void canPlaceRoomTest() {
        assertEquals(dungeon.canBePlaced(room1), true);
    }

    @Test
    public void cantPlaceRoomOnMapBoarderTest() {
        assertEquals(dungeon.canBePlaced(room2), false);
        assertEquals(dungeon.canBePlaced(room3), false);
    }
}
