## Advance DSA Day 41 DP 2 Two Dimentional

## Scope / Agenda
- [Max Subsequence Sum](#max-subsequence-sum)
- [Unique path in a grid I](#unique-path-in-a-grid-i)
- [Unique path in a grid II](#unique-path-in-a-grid-ii)
- [Dungeons and princess](#dungeons-and-princess)


## Problems and solutions

1. [Assignments](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/advance/module4/dp2/assignment)
2. [Additional Problems](https://github.com/rajpiyush220/Algorithms/tree/master/problems/src/main/java/com/learning/scaler/advance/module4/dp2/additional)
3. [Lecture Problems]()

## Class Notes and Videos

1. [Class Notes](../../../class_Notes/Advance%20DSA%20Notes/41.%20DP%202%20Two%20Dimensional.pdf)
2. [Class/Lecture Video](https://youtu.be/Bb-K2N2GA3A)

## Max Subsequence Sum
## Unique path in a grid I
## Unique path in a grid II
### Problem Description
    Given a grid of size n * m, lets assume you are starting at (1,1) and your goal is to reach (n, m). 
    At any instance, if you are on (x, y), you can either go to (x, y + 1) or (x + 1, y).

    Now consider if some obstacles are added to the grids. 
    Return the total number unique paths from (1, 1) to (n, m).

    Note: 
    1. An obstacle is marked as 1 and empty space is marked 0 respectively in the grid.
    2. Given Source Point and Destination points are 1-based index.

    Problem Constraints
    1 <= n, m <= 100
    A[i][j] = 0 or 1

    Input Format
    Firts and only argument A is a 2D array of size n * m.

    Output Format
    Return an integer denoting the number of unique paths from (1, 1) to (n, m).

    Example Input
    Input 1:
        A = [
                [0, 0, 0]
                [0, 1, 0]
                [0, 0, 0]
            ]
    Input 2:
        A = [
                [0, 0, 0]
                [1, 1, 1]
                [0, 0, 0]
            ]

    Example Output
    Output 1:
       2
    Output 2:
        0

    Example Explanation
    Explanation 1:

        Possible paths to reach (n, m): {(1, 1), (1, 2), (1, 3), (2, 3), (3, 3)} and {(1 ,1), (2, 1), (3, 1), (3, 2), (3, 3)}  
        So, the total number of unique paths is 2. 
    Explanation 2:
        It is not possible to reach (n, m) from (1, 1). So, ans is 0.
## Dungeons and princess
### Problem Description
    The demons had captured the princess and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

    The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

    Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

    In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.

    Given a 2D array of integers A of size M x N. Find and return the knight's minimum initial health so that he is able to rescue the princess.

    Problem Constraints
        1 <= M, N <= 500
        -100 <= A[i] <= 100

    Input Format
        First and only argument is a 2D integer array A denoting the grid of size M x N.

    Output Format
        Return an integer denoting the knight's minimum initial health so that he is able to rescue the princess.

    Example Input
        Input 1:
            A = [ 
                [-2, -3, 3],
                [-5, -10, 1],
                [10, 30, -5]
                ]
        Input 2:
            A = [ 
                [1, -1, 0],
                [-1, 1, -1],
                [1, 0, -1]
                ]

    Example Output
        Output 1:
            7
        Output 2:
            1

    Example Explanation
        Explanation 1:
            Initially knight is at A[0][0].
            If he takes the path RIGHT -> RIGHT -> DOWN -> DOWN, the minimum health required will be 7.
            At (0,0) he looses 2 health, so health becomes 5.
            At (0,1) he looses 3 health, so health becomes 2.
            At (0,2) he gains 3 health, so health becomes 5.
            At (1,2) he gains 1 health, so health becomes 6.
            At (2,2) he looses 5 health, so health becomes 1.
            At any point, the health point doesn't drop to 0 or below. So he can rescue the princess with minimum health 7.
        
        Explanation 2:
            Take the path DOWN -> DOWN ->RIGHT -> RIGHT, the minimum health required will be 1.
