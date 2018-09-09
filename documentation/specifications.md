# Project Specifications

The program creates an ASCII dungeon filled with rooms and mazes. It accepts user input for the size of the maze and number of rooms.

## Creating the dungeon

The application uses four stages to create the randomized dungeon:

1. Create rooms at random, but non-overlapping locations
2. Fill the empty space with corridors created by a randomised [Flood fill](https://en.wikipedia.org/wiki/Flood_fill) algorithm
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

The user defines how many room-adding attempts are made. The attempt fails if the new room overlaps with an existing room. The higher the number, the more likely it is that the dungeon will have a lot of rooms. The time complexity is the number of attempts O(a) * the average size of the room O(s). Space complexity is O(n) as we need to be able to check for every square for overlaps.

a = number of attempts to create a room
s = avg. size of the room
Time: O(a * s)
Space: O(n)

### 2. Fill remaining space with corridos

Time O(n) and Space O(n): The Flood-Fill algorithm visits all remaining squares once. 

### 3. Add one (or more) doors to rooms

Check all squares to find squares that are adjacent to room walls (connectors). Place a door on a random connector square and form a spanning tree of rooms with Kruskal. Add a small chance to create extra doors to improve playablity.

From Kruskal's algorithm we get the estimates for time and space
m = number of connectors (possible door squares)
Time: O(n log m)
Space: 


## Sources

- [Flood Fill](https://www.hackerearth.com/practice/algorithms/graphs/flood-fill-algorithm/tutorial/)
- [Kruskal](https://en.wikipedia.org/wiki/Kruskal%27s_algorithm)



