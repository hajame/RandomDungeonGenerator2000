
package dungeongenerator.domain;

import dungeongenerator.util.Position;
import java.util.Arrays;

/**
 * Main class
 * 
 * @author hajame
 */
public class Main {

    public static void main(String[] args) {
        
        int dungeonHeight = 40;
        int dungeonWidth = 40;
        char[][] map = new char[dungeonWidth][dungeonHeight];
        
        Dungeon dungeon = new Dungeon(map);
        
        map = dungeon.getMap();
        
        for(char[] array : map) {
            System.out.println(Arrays.toString(array));
        }
        
        Room room1 = new Room(new Position(2, 2), new Position(7, 7));
        Room room2 = new Room(new Position(0, 0), new Position(7, 7));
        Room room3 = new Room(new Position(2, 2), new Position(dungeonWidth, dungeonHeight));
        
        System.out.println(dungeon.canBePlaced(room1));
        System.out.println(dungeon.canBePlaced(room2));
        System.out.println(dungeon.canBePlaced(room3));
        
    }
    
}
