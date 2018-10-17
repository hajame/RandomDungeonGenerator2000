# User guide

Download file [RandomDungeonGenerator-1.0.jar](https://github.com/hajame/RandomDungeonGenerator2000/releases/tag/v1.0)

## Run jar in terminal

You can use command-line arguments when running the program
        
    java -jar RandomDungeonGenerator-1.0.jar [height] [width] [roomMin] [roomMax] [roomPlacementAttempts]

for example

    java -jar RandomDungeonGenerator-1.0.jar 30 80 3 8 20

will produce a map with 

    Height 			30
    Width 			80
    Room side len. 	       	3-8
    Room placement attempts 20
    RoomList, size: 	11

## Run in IDE

When running the source code in an IDE such as NetBeans, enter the parameters below and run the program.

        dungeonHeight = 50;
        dungeonWidth = 100;
        roomMin = 4;
        roomMax = 11;
        roomPlacementAttempts = 30;

### Test Programs

In an IDE, you can also the run test programs the following way

#### Run n amount of repeated tests

In Main class main method, **uncomment** line 45

    test(gen, 10);

Here '10' represents the amount of repeated tests (n). The output will be a list of dungeon completions times, and the avegare said times.

#### Time and print each individual phase in Dungeon generations

In Main class main method, **uncomment** line 42

    printAndTimePhases(gen);
    
This will print out dungeon map and creation time after each phase.
