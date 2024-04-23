package com.learning.scaler.advance.module4.dp2.assignment;

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
public class NewBatchUniquePathsInAGrid {

    int[][] pathMatrix;

    public static void main(String[] args) {
        NewBatchUniquePathsInAGrid paths = new NewBatchUniquePathsInAGrid();
        System.out.println(paths.uniquePathsWithObstacles(new int[][]{{0, 0}}));
    }

    public int uniquePathsWithObstacles(int[][] A) {
        if (A.length == 0 || A[0].length == 0) return 0;
        int m = A.length, n = A[0].length;
        // construct dp matrix of size m * n
        pathMatrix = new int[m][n];
        for (int[] arr : pathMatrix) {
            Arrays.fill(arr, -1);
        }
        uniquePathsWithRec(A, m - 1, n - 1);
        return pathMatrix[m - 1][n - 1];
    }

    private void uniquePathsWithRec(int[][] A, int start, int end) {
        // write base condition later on
        if (start < 0 || end < 0) return;
        if (start == 0 && end == 0) {
            pathMatrix[start][end] = 1;
            return;
        }
        if (A[start][end] == 1) {
            pathMatrix[start][end] = 0;
            return;
        }
        if (pathMatrix[start][end] == -1) {
            if (start > 0 && pathMatrix[start - 1][end] == -1)
                uniquePathsWithRec(A, start - 1, end);
            if (end > 0 && pathMatrix[start][end - 1] == -1) uniquePathsWithRec(A, start, end - 1);
            pathMatrix[start][end] = ((start > 0) ? pathMatrix[start - 1][end] : 0)
                    + (end > 0 ? pathMatrix[start][end - 1] : 0);
        }
    }
}
