package dungeongenerator.domain;

import dungeongenerator.util.HarrayList;

/**
 * Main class
 *
 * @author hajame
 */
public class Main {

    public static void main(String[] args) {

        // **PARAMETERS**
        //      over 1000x1000 will take a lot of time
        //      also increase roomPlacementAttempts on bigger maps (for speed)
        int dungeonHeight = 50;
        int dungeonWidth = 100;

        // max and min values for room edges
        int roomMin = 4;
        int roomMax = 11;

        // no. of attempts to place rooms.
        int roomPlacementAttempts = 30;

        Generator gen = new Generator(dungeonHeight, dungeonWidth,
                roomMin, roomMax, roomPlacementAttempts);

        create(gen);

            // * Uncomment line below to print out each phase with its creation time *
        // printAndTimePhases(gen);
        
            // * Uncomment line below to see the average time of n amount of tests *
        // test(gen, 10);
    }

    /**
     * Creates and prints a single dungeon
     *
     * @param g Generator
     */
    public static void create(Generator g) {
        long time = System.currentTimeMillis();     // begin measuring time
        g.generateDungeon();
        time = System.currentTimeMillis() - time;   // record time

        // print new randomly generated dungeon and creation information
        g.getDungeon().print();
        System.out.println("Creation time \t\t" + time + " ms");
        System.out.println("Height \t\t\t" + g.dungeonHeight);
        System.out.println("Width \t\t\t" + g.dungeonWidth);
        System.out.println("Room side len. \t\t" + g.roomMin + "-" + g.roomMax);
        System.out.println("Room placement attempts " + g.roomAmount);
        System.out.println("RoomList, size: \t" + g.getDungeon().getRooms().size());
    }

    /**
     * Creates n dungeons, lists creation times and average time
     *
     * @param g Generator
     * @param n test repetitions
     */
    public static void test(Generator g, int n) {
        long time, sum = 0;
        HarrayList<Long> times = new HarrayList();

        for (int i = 0; i < n; i++) {
            time = System.currentTimeMillis();
            g = new Generator(g.dungeonHeight, g.dungeonWidth,
                    g.roomMin, g.roomMax, g.roomAmount);
            g.generateDungeon();
            time = System.currentTimeMillis() - time;
            sum += time;
            times.add(time);
        }
        System.out.println("\n\nTEST RESULTS (ms), n = " + n);
        System.out.println(times.toString());
        System.out.println("Avg duration: " + sum / n + " ms");
    }

    /**
     * Prints out dungeon map and creation time after each phase.
     *
     * @param g Generator
     */
    public static void printAndTimePhases(Generator g) {
        long sum = 0;
        long time = System.currentTimeMillis();
        Generator generator = new Generator(g.dungeonHeight, g.dungeonWidth,
                g.roomMin, g.roomMax, g.roomAmount);
        time = System.currentTimeMillis() - time;
        sum += time;
        System.out.println("Init map \t\t" + time + " ms");
        generator.getDungeon().print();

        time = System.currentTimeMillis();
        generator.generateRooms();
        time = System.currentTimeMillis() - time;
        sum += time;
        System.out.println("Generating rooms \t\t" + time + " ms");
        generator.getDungeon().print();

        time = System.currentTimeMillis();
        boolean mazeGenerated = generator.generateMaze();
        while (!mazeGenerated) {
            mazeGenerated = generator.generateMaze();
        }
        time = System.currentTimeMillis() - time;
        sum += time;
        System.out.println("Generating maze \t\t" + time + " ms");
        generator.getDungeon().print();

        time = System.currentTimeMillis();
        generator.generateDoors();
        time = System.currentTimeMillis() - time;
        sum += time;
        System.out.println("Generating doors \t\t" + time + " ms");
        generator.getDungeon().print();

        time = System.currentTimeMillis();
        generator.deleteDeadEnds();
        time = System.currentTimeMillis() - time;
        sum += time;
        System.out.println("Deleting deadends \t\t" + time + " ms");
        generator.getDungeon().print();

        time = System.currentTimeMillis();
        generator.clean();
        time = System.currentTimeMillis() - time;
        sum += time;
        System.out.println("Clean up \t\t" + time + " ms");

        generator.getDungeon().print();
        System.out.println("Creation time \t\t" + sum + " ms");
        System.out.println("Height \t\t\t" + g.dungeonHeight);
        System.out.println("Width \t\t\t" + g.dungeonWidth);
        System.out.println("Room side len. \t\t" + g.roomMin + "-" + g.roomMax);
        System.out.println("Room placement attempts " + g.roomAmount);
        System.out.println("RoomList, size: \t" + generator.getDungeon().getRooms().size());
    }

}
