# Week 5

- [Hour reporting](https://github.com/hajame/RandomDungeonGenerator2000/blob/master/documentation/hour_report.md)

## Progress during week 5

- JUnit tests
- Eempirical testing
- Experimental testing
- Delete dead ends (Pruning)
- Replaced some of the data structures: PositionList, NeighborList
- Optimizing algorithms and datastructures
- Searching for and fixing bugs
- Adding more randomness
- Maze generator prefers continuing in the same direction
- Documentation

## Class updates

### Main

- Now has a test loop for n repeated tests, counts average of build times.

### PositionList

Stack-type structure using LinkedList as its base.

### NeighborList extends PositionList

NeighborList has remove(i), poll(i): required by the pollRandom method.
  
### Position

- Method for checking direction from previous Position
  
## Problems

- Some times rooms would return empty doorSegment lists. -> Null Exception. Fixed this using a check. Rooms may in rare cases end up without a door.
- Realized a little too late that I need to finish up some documentation.

## Lessons learned

- Writing your own datastructures is hard, and Java DSs are well optimized.
- Small changes in datastructures can make a huge difference in execution times.

## Next week
- Connecting Mazes and Rooms (Might never happen, depending on time constraints)
- Optimizing datastructures for increased speed
- Bug fixing

