# Test report

## JUnit testing

The program was written borrowing test-driven development methods. The usual workflow was to write a class and test it right away, with the exceptions of classes with complex methods that evolve iteratively.

All classes, except the Main class, were tested. 

### jacoco test report 

| Report          | Coverage | Missed        |
|-----------------|----------|---------------|
| Line   | 	92%     | 	91 of 1,765   |
| Branch | 	88%     | 	18 of 162    |

## Empirical testing

### Test setup

The program is run multiple times using different settings for the dungeon size and room placement attempts. More placed rooms means less maze to generate, decreasing the time and vice versa.

For consistency, we will set min and max values for room edges to 5% and 10%. This will ensure that the rooms are relative to the size of the maze, which is important, because when the rooms are bigger, there is less maze to generate and the time decreases.

### Test 1: Results 27.9.2018

#### Exceptions
- Few repetitions (N = 3)
- No removing of dead ends
- No custom datastructures

Initial tests without the removal of dead ends suggests the following average times.

#### Small and mid-size tests

- 100x100 - 50 attempts - 0.589s  
- 100x100 - 500 attempts - 0.594s  
- 500x500 - 50 attempts - 3.000s
- 500x500 - 500 attempts - 2.059s

#### Large tests

| Map size | Room attempts | Avg time (ms)            | Noted                                                                             | Reason                                        |
|----------|---------------|--------------------------|-----------------------------------------------------------------------------------|-----------------------------------------------|
| 700x700  | 50 attempts   | 10,453s                  | crashed 1/3 tests                                                                 | StackOverflowError due to too many recursions |
| 700x700  | 500 attempts  | 5.479s                   | survived all 3 tests                                                              |                                               |
| 1kx1k    | 50 attempts   | crashed during all tests |                                                                                   | StackOverflowError due to too many recursions |
| 1kx1k    | 500 attempts  | failed all tests         | crashed during all tests                                                          | StackOverflowError due to too many recursions |
| 1kx1k    | 1000 attempts | failed all tests         | crashed during all tests                                                          | StackOverflowError due to too many recursions |
| 1kx1k    | 100k attempts | 13,942                   | SURVIVED ALL 3 TESTS. Usually ~100 rooms in the map despite large no. of attempts |                                               |

#### After removing recursion
- 1kx1k 
    - 50 attempts 32.119s
    - 500 attempts 19.920s
    - 1000 attempts 17.185s
    - 10k attempts 12.486s
    - 100k attempts 11.587s

#### Remarks

What is noteworthy is that although the generateMaze algorithm had stack over flow issues, these issues seem to disappear when room placement amount is increased. It would generate large mazes only if the rooms populate a large enough area. This problem was fixed by removing recursion.  

This suggests that when the number of rooms is sparse, the generateMaze random flood fill algorithm trips over somehow, stops and has to perform a recursion, beginning from a new opening multiple times, until StackOverFlow error occurs.

That being said, the 1kx1k ASCII map is too huge for a real game. It is, however, a good test for optimizing the random flood fill algorithim.


### Test 2 (n=10): Results 4.10.2018

#### Changes from Test 1
- N = 10 
- Custom PositionList (Stack using LinkedList) and NeighborList (LinkedList)
- Removal of deadends implemented

#### Results, test 2

| Map size  | Room attempts | Avg time (ms) | Max    | Min   | Med   |
|-----------|---------------|---------------|--------|-------|-------|
| 100x100   | 50            | 15            | 45     | 8     | 10    |
| 100x100   | 500           | ndf           | dnf    | dnf   | dnf   |
| 500x500   | 50            | 7351          | 8517   | 6518  | 7102  |
| 500x500   | 500           | 5076          | 6300   | 4174  | 4712  |
| 700x700   | 50            | 28559         | 32381  | 25751 | 28189 |
| 700x700   | 500           | 19556         | 21696  | 15482 | 20270 |
| 700x700   | 1000          | 15897         | 19277  | 13111 | 15001 |
| 1000x1000 | 50 (n=1)      |               | 140547 |       |       |
| 1000x1000 | 1000 (n=1)    |               | 92397  |       |       |
| 1000x1000 | 10000 (n=1)   |               | 75255  |       |       |

#### Remarks

Changes from ArrayList implementation to LinkedList seemed to slow the program down significantly. 500x500 500 room placements went from previous 2 seconds to an average of 5 seconds. Removal of deadends alone could did not cause this, based on earlier experimentation.

Major optimization and possible switching of the LinkedList to Arrays (NeighborList max size is always 4) or the Stack implementation is in order.

100x100 seems to have trouble finishing with 500 room attempts. It seems the chance is high for the rooms to fill the space completely, resulting in a NullException when randomly choosing door positions, as there is nowhere to place a door.


### Test 3 (n=10): Results 10.10.2018

#### Changes from Test 2

- PositionList & NeighborList
    - LinkedList was changed to ArrayList
- During this test, RoomList was still using stock ArrayList, but similar results were had after changing to custom ArrayList

#### Results, test 3

| Map size  | Room attempts | Avg time (ms) | Max   | Min   | Med   |
|-----------|---------------|---------------|-------|-------|-------|
| 100x100   | 50            | 19            | 46    | 8     | 11    |
| 100x100   | 100           | 22            | 78    | 6     | 12    |
| 500x500   | 50            | 2415          | 2800  | 2131  | 2375  |
| 500x500   | 500           | 1349          | 1572  | 1171  | 1272  |
| 700x700   | 50            | 8828          | 9085  | 8594  | 8790  |
| 700x700   | 500           | 5135          | 5736  | 4624  | 5032  |
| 700x700   | 1000          | 4208          | 4937  | 3661  | 4097  |
| 1000x1000 | 1000          | 22735         | 24743 | 21199 | 22255 |
| 1000x1000 | 10000         | 16004         | 17851 | 13815 | 16112 |

#### Remarks

Changes from LinkedList to a custom ArrayList brought performance up to it's initial levels. 500x500 500 room placements went from 5 to 1,3 seconds on average. 

100x100 still hase the same trouble of finishing with 500 room attempts. The chance is still high for the rooms to fill the space completely, resulting in a NullException when randomly choosing door positions, as there is nowhere to place a door. Although this could be fixed, I would argue that it would not result in a pleasing-looking dungeon as it would be all room no corridor. Even with 100 room attempts the space ends up looking cramped with rooms.

#### Visualisation

Here is the visualisation of average running time vs. number of map squares (n) and room squares (m).

![Visualisation of Test 3](https://raw.githubusercontent.com/hajame/RandomDungeonGenerator2000/master/documentation/images/3_test_results.png)

| n + m  | Room attempts | Avg time (ms) |
|-----------|---------------|---------------|
| 20k   | 100           | 22            |
| 500k   | 500           | 1349          |
| 980k   | 1000          | 4208          |
| 2M | 10000         | 16004         |

It can be seen that when n + m doubles, the average time quadruples. This suggests a time complexity of `O((n+m)^2)`, which is not line with the initial time estimation of `O(n+m)`, given in the [Project specifications document](https://github.com/hajame/RandomDungeonGenerator2000/blob/master/documentation/specifications.md).

Unless there are severe flaws in the code, it is unlikely that an `O((n+m))` time complexity can be achieved using the current algorithm structure. This suggests that the initial estimation of `O((n+m))` was wrong.

#### Potential for optimization

As __phase 2: 'fill remaining space with a maze'__ is the most time-demanding phase, more optimization there could lead to a more efficient algorithm. 
