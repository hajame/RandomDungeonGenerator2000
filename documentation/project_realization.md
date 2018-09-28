# Project realization

The structure of the program follows the steps of the [Project Specifications](https://github.com/hajame/RandomDungeonGenerator2000/blob/master/documentation/specifications.md).

## Creating the dungeon

The application uses four stages to create the randomized dungeon:

1. Create rooms at random, but non-overlapping locations.
2. Fill the empty space with corridors created by a randomised [Flood Fill](https://en.wikipedia.org/wiki/Flood_fill) algorithm
3. Add doors that connect every room and corridor segment to each other, allowing travel from any square to any other square
4. Remove deadends (pruning)


## Exceptions

### Algorithms

- Kruskal was not used to connect rooms.
  - Rooms are collected to a List object, and only their surrounding squares are scanned for potential door positions.

### Data structures

- Spanning Tree was not used as result of not needing to use Kruskal's
- Stack will not be used in the final program
  - Using Linked List instead
    - Scales up well as a Stack
  - Using an object to store 1-4 neighbors
    - Allows the pollRandom method to be used
    
## Time and Space complexity

TODO:

### 1. Create rooms
### 2. Fill remaining space with corridos
### 3. Add one (or more) doors to rooms
### 4. Pruning (removing extra corridors)
### Total
## Sources

- [Bob Nystrom's Dungeon Generator](http://journal.stuffwithstuff.com/2014/12/21/rooms-and-mazes/)
- [Flood Fill](https://www.hackerearth.com/practice/algorithms/graphs/flood-fill-algorithm/tutorial/)
    - also [Flood Fill on wikipedia](https://en.wikipedia.org/wiki/Flood_fill)
