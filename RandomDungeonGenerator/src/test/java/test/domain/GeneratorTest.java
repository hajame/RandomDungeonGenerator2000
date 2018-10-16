/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.domain;

import dungeongenerator.domain.Dungeon;
import dungeongenerator.domain.Generator;
import dungeongenerator.util.PositionList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hajame
 */
public class GeneratorTest {

    private Generator generator;
    private Generator gComplete;
    private Dungeon compDungeon;

    @Before
    public void setUp() {

        int dungeonHeight = 100;
        int dungeonWidth = 100;

        // max and min values for room edges
        int roomMin = 5;
        int roomMax = 10;
        // no. of attempts to place rooms.
        int roomPlacementAttempts = 100;

        this.generator = new Generator(dungeonHeight, dungeonWidth,
                roomMin, roomMax, roomPlacementAttempts);

        this.compDungeon = new Dungeon(new char[dungeonHeight][dungeonWidth]);
        this.gComplete = generator;
        gComplete.generateRooms();
        boolean isFinished = gComplete.generateMaze();
        while (!isFinished) {
            isFinished = gComplete.generateMaze();
        }

    }
    
    @Test
    public void generateRoomsAndMazeTest() {
        generator.generateRooms();
        boolean isFinished = generator.generateMaze();
        if (generator.findNextFree(2, 2) != null) {
            assertFalse(isFinished);
        } else {
            assertTrue(isFinished);
        }
    }

    @Test
    public void generateRoomsTest() {
        generator.generateRooms();
        assertNotEquals(generator.getDungeon().getRooms().size(), 
                compDungeon.getRooms().size());
    }

    @Test
    public void removeDeadEndsTest() {
        assertNull(gComplete.findNextFree(2, 2));
        gComplete.deleteDeadEnds();
        assertNotNull(gComplete.findNextFree(2, 2));
    }
    
    @Test
    public void cleanTest() {
        gComplete.clean();
        char[][] map = gComplete.getDungeon().getMap();
        boolean isClean = true;
        for (int y = 0; y < map[0].length; y++) {
            for (int x = 0; x < map.length; x++) {
                if (map[x][y] == 'X') {
                    isClean = false;
                }
            }
        }
        assertTrue(isClean);
    }
    
    @Test
    public void connectingSegmentsTest() {
        PositionList segments0 = gComplete.getDungeon().getRooms().get(0)
                .connectingSegments(gComplete.getDungeon());
        PositionList segments1 = gComplete.getDungeon().getRooms().get(1)
                .connectingSegments(gComplete.getDungeon());
        assertTrue(segments0.size() != 0);
        assertTrue(segments1.size() != 0);
    }
}
