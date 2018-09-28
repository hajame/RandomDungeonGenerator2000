# Week 4

- [Hour reporting](https://github.com/hajame/RandomDungeonGenerator2000/blob/master/documentation/hour_report.md)

## Progress during week 4

- Writing lots of JUnit tests
- Experimental and empirical testing
- Generator fills missed areas with mazes
- Connecting Mazes and Rooms
- Optimizing
- Bug fixing
- Planning Algorithms
- Documenting, lots of it

## Class updates

### Generator

Now finishes one corridor at a time insted of jumping around, creating a more pleasing maze pattern.

- No more recursion if there's more room for maze building
  - Using while loop instead
  - This fixed StackOverFlow issues
  
### Room

- Method for checking possible door segments
  
## Problems

- Some times rooms would return empty doorSegment lists. -> Null Exception. Fixed this using a check. Rooms may in rare cases end up without a door.
- Realized a little too late that I need to finish up some documentation.

## Lessons learned

Coding doesn't require a lot of time, you just need to use your time effectively.

## Next week

- Delete dead ends (todo)
- Replace some of the data structures.
- Optimize algorithm.
- Create more tests
