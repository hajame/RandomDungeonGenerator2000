# Test report

## JUnit testing

The program was written borrowing test-driven development methods. The usual workflow was to write a class and test it right away, with the exceptions of classes with complex methods that evolve iteratively.

This will involve all classes except the Main class. 

### Exceptions

Certain branches, such as the equals-method of the Position class were not tested. These are really general and well tried basic object comparisons.

### jacoco test report 

| Report          | Coverage | Missed        |
|-----------------|----------|---------------|
| Line   | 	64%     | 414 of 1,162   |
| Branch | 53%     | 	63 of 136    |

## Empirical testing

### Test setup

The program is run multiple times using different settings for the dungeon size and room placement attempts. More placed rooms means less maze to generate, decreasing the time and vice versa.

For consistency, we will set min and max values for room edges to 5% and 10%. This will ensure that the rooms are relative to the size of the maze, which is important, because when the rooms are bigger, there is less maze to generate and the time decreases.

### Results

27.9.2018
(final results are waiting for the removing of dead ends)

Initial tests without the removal of dead ends suggests the following average times.

#### Small and mid-size tests

- 100x100 - 50 attempts - 0.589s  
- 100x100 - 500 attempts - 0.594s  
- 500x500 - 50 attempts - 3.000s
- 500x500 - 500 attempts - 2.059s

Note: even a 500x500 maze is quite big for an ASCII dungeon. It will not confortably fit on one screen. However, larger dungeons may be desired in a game where only part of the screen is showing at a time.


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

Build time did not increase significantly from 700x700 to 1kx1k, even if there are twice as many squares in the latter. However, this is probably due to the increased amount of attempts, 500 vs 100k.

What is noteworthy is that although the generateMaze algorithm had stack over flow issues, these issues seem to disappear when room placement amount is increased. It would generate large mazes only if the rooms populate a large enough area. This problem was fixed by removing recursion.

This suggests that when the number of rooms is sparse, the generateMaze random flood fill algorithm trips over somehow, stops and has to perform a recursion, beginning from a new opening multiple times, until StackOverFlow error occurs.

That being said, the 1kx1k ASCII map is too huge for a real game. It is, however, a good test for optimizing the random flood fill algorithim.




