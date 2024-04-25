package com.learning.scaler.advance.module4.dp2.assignment;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
Problem Description
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
    First and only argument A is a 2D array of size n * m.

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
* */
public class UniquePathsInAGridWithObstacle {

    public static void main(String[] args) {
        System.out.println(new UniquePathsInAGridWithObstacle()
                .uniquePathsWithObstaclesBU(new int[][]{{0}}));
    }

    // top down
    int[][] pathMatrix;

    public int uniquePathsWithObstacles(int[][] A) {
        if (pathMatrix == null) {
            pathMatrix = new int[A.length][A[0].length];
            for (int[] arr : pathMatrix) Arrays.fill(arr, -1);
        }
        return uniquePathsWithObstaclesDp1Rec(A, A.length - 1, A[0].length - 1);
    }

    public int uniquePathsWithObstaclesDp1Rec(int[][] A, int start, int end) {
        if (start < 0 || end < 0) return 0;
        else if (start == 0 && end == 0) return (A[start][end] == 1) ? 0 : 1;
        else if (pathMatrix[start][end] != -1) return pathMatrix[start][end];
        else if (A[start][end] == 1) {
            pathMatrix[start][end] = 0;
        } else {
            pathMatrix[start][end] = uniquePathsWithObstaclesTDRec(A, start - 1, end) +
                    uniquePathsWithObstaclesTDRec(A, start, end - 1);
        }
        return pathMatrix[start][end];
    }

    // bottom up
    // need to correct it
    public int uniquePathsWithObstaclesBU(int[][] A) {
        if (pathMatrix == null) {
            pathMatrix = new int[A.length][A[0].length];
            if (pathMatrix.length > 1) {
                for (int i = 0; i < pathMatrix.length; i++) {
                    if (i == 0) {
                        for (int j = 0; j < pathMatrix[0].length; j++) {
                            pathMatrix[0][j] = A[0][j] > 0 ? 0 : 1;
                        }
                    } else {
                        Arrays.fill(pathMatrix[i], -1);
                        pathMatrix[i][0] = A[i][0] > 0 ? 0 : 1;
                    }
                }
            } else {
                Arrays.fill(pathMatrix[0], -1);
            }

        }
        return uniquePathsWithObstaclesBURec(A, A.length - 1, A[0].length - 1);
    }

    public int uniquePathsWithObstaclesBURec(int[][] A, int start, int end) {
        if (start < 0 || end < 0) return 0;
        else if (start == 0 && end == 0 && A[start][end] == 0) return 1;
        else if (pathMatrix[start][end] > 0) return pathMatrix[start][end];
        else if (A[start][end] == 1) {
            pathMatrix[start][end] = 0;
        } else {
            pathMatrix[start][end] = uniquePathsWithObstaclesBURec(A, start - 1, end) +
                    uniquePathsWithObstaclesBURec(A, start, end - 1);
        }
        return pathMatrix[start][end];
    }

    // leet code
    int[][] lPathMatrix;
    public int uniquePathsWithObstaclesTD(int[][] obstacleGrid) {
        if (lPathMatrix == null) {
            lPathMatrix = new int[obstacleGrid.length][obstacleGrid[0].length];
            for (int[] arr : lPathMatrix) Arrays.fill(arr, -1);
        }
        return uniquePathsWithObstaclesTDRec(obstacleGrid, obstacleGrid.length - 1, obstacleGrid[0].length - 1);
    }

    public int uniquePathsWithObstaclesTDRec(int[][] obstacleGrid, int start, int end) {
        if (start < 0 || end < 0) return 0;
        else if (start == 0 && end == 0) return (obstacleGrid[start][end] == 1) ? 0 : 1;
        else if (lPathMatrix[start][end] != -1) return lPathMatrix[start][end];
        else if (obstacleGrid[start][end] == 1) {
            lPathMatrix[start][end] = 0;
        } else {
            lPathMatrix[start][end] = uniquePathsWithObstaclesTDRec(obstacleGrid, start - 1, end) +
                    uniquePathsWithObstaclesTDRec(obstacleGrid, start, end - 1);
        }
        return lPathMatrix[start][end];
    }
}
