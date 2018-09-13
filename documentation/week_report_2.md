# Week 2

- [Hour reporting](https://github.com/hajame/RandomDungeonGenerator2000/blob/master/documentation/hour_report.md)

## Progress during week 2

__Started coding!__  

- Designed some of the classes
- Generator class. Now creates randomly placed rooms.
- Created:
	- Dungeon
	- Room
	- Position
	- Generator
- Added parameters for Main class
- Created Tests
	- DungeonTest
		- canBePlaced method testing
	- GeneratorTest
	- Jacoco report

### Dungeon class

- init() creates walls on the perimeter of the map
- canBePlaced(room) checks if the given room overlaps with map walls or other rooms.

## Problems

Couldn't decide if I need an ArrayList or not. Decided to create it now and decide later if I'm going to ditch it.

## Lessons learned

Refactoring is not as bad as it used to be.

## Next week

- Mark room walls better.
- Generator fills the rest of the space with mazes
- Create class RoomList that contains the ArrayList that is going to be replaced later.
