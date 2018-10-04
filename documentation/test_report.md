# Test report

## JUnit testing

The program was written borrowing test-driven development methods. The usual workflow was to write a class and test it right away, with the exceptions of classes with complex methods that evolve iteratively.

This will involve all classes except the Main class. 

### Exceptions

Certain branches, such as the equals-method of the Position class were not tested. These are really general and well tried basic object comparisons.

### jacoco test report 

| Report          | Coverage | Missed        |
|-----------------|----------|---------------|
| Line   | 	68%     | 	555 of 1,763   |
| Branch | 	61%     | 	89 of 230    |

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

- 700x700 - 50 attempts - 10,453s 
    - crashed 1/3 tests - StackOverflowError due to too many recursions
- 700x700 - 500 attempts - 5.479s - survived all 3 tests
- 1kx1k - 50 attempts - crashed during all tests 
    - StackOverflowError due to too many recursions
- 1kx1k - 500 attempts - failed all tests - crashed during all tests 
    - StackOverflowError due to too many recursions
- 1kx1k - 1000 attempts - failed all tests - crashed during all tests 
    - StackOverflowError due to too many recursions
- 1kx1k - 100k attempts - 13,942 - SURVIVED ALL 3 TESTS
    - NOTE: usually ~100 rooms in the map despite large no. of attempts

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


### Test 2: Results 4.10.2018

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





