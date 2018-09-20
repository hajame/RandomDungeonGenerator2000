# Week 3

- [Hour reporting](https://github.com/hajame/RandomDungeonGenerator2000/blob/master/documentation/hour_report.md)

## Progress during week 3

- Lots of refactoring!!
- Maze generation works! (though still fails on many occasions)
- New Classes!

## Class updates

### RoomList

- Stores rooms
- ArrayList, replaced later

### PositionList

- Stores map positions
- Methods getNeighbors and pollRandom help with maze generation.

### Generator

- Creates the maze with a flood fill -style algorithm

## Problems

- Maze generation stops if generated rooms surround an area. This should be easy to fix later.
- Spent so much of the time writing the algorithm, had no time for testing this week.

## Lessons learned

Reserve more time for testing and documentation.

## Next week

- Writing lots of JUnit tests
- Generator fills missed areas with mazes.
- Connecting Mazes and Rooms

## Week after next week

- Delete dead ends.
- Replace some of the data structures.
- Optimize algorithm.
