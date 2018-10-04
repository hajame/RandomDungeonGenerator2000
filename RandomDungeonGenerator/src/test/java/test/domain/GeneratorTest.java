/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.domain;

import dungeongenerator.domain.Dungeon;
import dungeongenerator.domain.Generator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hajame
 */
public class GeneratorTest {
    
    private Generator generator;
    private Dungeon comp;


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
        
        this.comp = new Dungeon(new char[dungeonHeight][dungeonWidth]);
        
    }

    @Test
    public void generateDungeonTest() {
        generator.generateRooms();
        Dungeon dungeon = generator.getDungeon();
        assertEquals(dungeon.getMap().length, comp.getMap().length);
        
    }
    
    @Test
    public void generateTest() {
        generator.generateRooms();
        boolean isFinished = generator.generateMaze();
        if (generator.findNextFree(2, 2) != null) {
            assertFalse(isFinished);
        } else {
            assertTrue(isFinished);
        }
        
    }
}
