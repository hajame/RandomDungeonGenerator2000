# Project Specifications

The program creates an ASCII dungeon filled with rooms and mazes.  

It accepts user input for the size of the maze and number attempts to make rooms (which normally results in having more rooms).

## Creating the dungeon

The application uses four stages to create the randomized dungeon:

1. Create rooms at random, but non-overlapping locations.
2. Fill the empty space with corridors created by a randomised [Flood Fill](https://en.wikipedia.org/wiki/Flood_fill) algorithm
3. Starting from a random room, add doors that connect every room and corridor segment to each other, allowing travel from any square to any other square
4. Remove deadends

## Algorithms

- Modified Flood Fill
- Kruskal's algorithm
- Random Number Generator

## Data structures

### Initial extimation

- Spanning Tree
- Stack

## Time and Space complexity

n = total number of squares in the dungeon map

### 1. Create rooms

The user defines how many room-adding attempts are made. The attempt fails if the new room overlaps with an existing room. The higher the number, the more likely it is that the dungeon will have a lot of rooms. The time complexity is the number of attempts O(a) * the average size of the room O(s). A and s are not usually particularly large numbers. Space complexity is O(n) as we need to be able to check for every square for overlaps.

    a = number of attempts to create a room
    s = avg. number of squares in a room
    Time: O(as)
    Space: O(n)


### 2. Fill remaining space with a maze

Time O(n) and Space O(n): The Flood-Fill algorithm visits all remaining squares once. 

### 3. Add one (or more) doors to rooms

Check all squares to find squares that are adjacent to room walls (connectors). Place a door on a random connector square and form a spanning tree of rooms with Kruskal. Add a small chance to create extra doors to improve playablity.

From Kruskal's algorithm we get the estimates for time and space complexity:

    m = number of connectors (possible door squares)
    Time: O(n log m)
    Space: O(n + m)

### 4. Pruning (removing extra corridors)

Find all squares that are next to three wall squares: O(n). Start with a random one and replace the dead end with a wall. The algorithm then finds the neighbouring open square and checks for that one, continuing until there are no dead ends O(n).

    Time: O(n)
    Space: O(1)

### Total

    n = total number of squares in the dungeon map
    m = number of connectors (possible door squares)
    a = number of attempts to create a room
    s = avg. number of squares in a room

    Time: O(as) + O(n) + O(n log m) + O(n) = O(as + 2n + n log m)    
    = O(as + n log m)

    Space: O(n) + O(n + m) + O(n) + o(1)  
    = O(n + m)

## Sources

- [Bob Nystrom's Dungeon Generator](http://journal.stuffwithstuff.com/2014/12/21/rooms-and-mazes/)
- [Flood Fill](https://www.hackerearth.com/practice/algorithms/graphs/flood-fill-algorithm/tutorial/)
    - also [Flood Fill on wikipedia](https://en.wikipedia.org/wiki/Flood_fill)
- [Kruskal](https://en.wikipedia.org/wiki/Kruskal%27s_algorithm)



