package dungeongenerator.domain;

/**
 * Main class
 *
 * @author hajame
 */
public class Main {

    public static void main(String[] args) {

        int dungeonHeight = 50;
        int dungeonWidth = 150;

        // max and min values for room edges
        int roomMin = 5;
        int roomMax = 10;
        // no. of attempts to place rooms.
        int roomPlacementAttempts = 50;
        long time = System.currentTimeMillis();
        Generator generator = new Generator(dungeonHeight, dungeonWidth,
                roomMin, roomMax, roomPlacementAttempts);
        
        generator.generateDungeon();
        time = System.currentTimeMillis() - time;
        Dungeon dungeon = generator.getDungeon();
        char[][] map = dungeon.getMap();
        dungeon.print();
        System.out.println("Creation time \t\t" + time + " ms");
        System.out.println("Height \t\t\t" + dungeonHeight);
        System.out.println("Width \t\t\t" + dungeonWidth);
        System.out.println("Room side len. \t\t"+roomMin+"-"+roomMax);
        System.out.println("Room placement attempts "+roomPlacementAttempts+"\n");
        
        System.out.println("RoomList, size: "+dungeon.getRooms().size());
    }

}
