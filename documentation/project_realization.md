# Project realization

The structure of the program follows the steps of the [Project Specifications](https://github.com/hajame/RandomDungeonGenerator2000/blob/master/documentation/specifications.md):

#### Creating the dungeon

The application uses four stages to create the randomized dungeon:

1. Create rooms at random, but non-overlapping locations.
2. Fill the empty space with corridors created by a randomised [Flood Fill](https://en.wikipedia.org/wiki/Flood_fill) algorithm
3. Add doors that connect every room and corridor segment to each other, allowing travel from any square to any other square
4. Remove deadends (pruning)


## Exceptions

### Algorithms

- Kruskal was not used to connect rooms.
  - Rooms are collected to a List object, and only their surrounding squares are scanned for potential door positions.
  - This results in less code, but also sometimes the dungeon is not 100% connected.

### Data structures

- Spanning Tree was not used as result of not needing to use Kruskal's
- Stack will not be used in the final program
  - Using ArrayList instead
    - Scales up well
    - Fast and can be used for random polling
    
## Time and Space complexity

### 1. Create rooms
    a = number of attempts to create a room
    s = avg. number of squares in a room
    Time: O(as)
    Space: O(n)
### 2. Fill remaining space with corridos
The Flood-Fill algorithm visits all remaining squares once. 

    Time O(n) and Space O(n)
### 3. Add one (or more) doors to rooms
    m = number of connectors (possible door squares)
    Time: O(m)
    Space: O(m)
### 4. Pruning (removing extra corridors)
    Time: O(n)
    Space: O(1)
### Total
    n = total number of squares in the dungeon map
    m = number of connectors (possible door squares)
    a = number of attempts to create a room
    s = avg. number of squares in a room

    Time: O(as) + O(n) + O(m) + O(n) 
    = O(as + 2n + m)    
    = O(as + m)

    Space: O(n) + O(m) + O(n) + O(1)  
    = O(n + m)
## Sources

- [Bob Nystrom's Dungeon Generator](http://journal.stuffwithstuff.com/2014/12/21/rooms-and-mazes/)
- [Flood Fill](https://www.hackerearth.com/practice/algorithms/graphs/flood-fill-algorithm/tutorial/)
    - also [Flood Fill on wikipedia](https://en.wikipedia.org/wiki/Flood_fill)
