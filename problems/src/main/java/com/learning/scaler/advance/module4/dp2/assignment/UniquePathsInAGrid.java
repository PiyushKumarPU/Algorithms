package com.learning.scaler.advance.module4.dp2.assignment;

import java.util.ArrayList;
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
public class UniquePathsInAGrid {

    static int[][] pathMatrix;

    public static void main(String[] args) {
        /*int result = uniquePathsWithObstacles(new ArrayList<>(List.of(
                new ArrayList<>(List.of(0, 1))
        )));
        System.out.println(result);*/

        System.out.println(uniquePathsWithObstacles(new int[][]{
                {0, 0}}));
    }

    public static int uniquePathsWithObstacles(int[][] A) {
        if (A.length == 0) return 0;
        if (A.length == 1 && A[0].length == 1 && A[0][0] == 0) return 1;
        pathMatrix = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            Arrays.fill(pathMatrix[i], -1);
        }
        return uniquePathsWithRec(A, A.length - 1, A[0].length - 1);
    }

    private static int uniquePathsWithRec(int[][] A, int start, int end) {
        if (start == 0 || end == 0) return 1;
        if (A[start][end] == 1) return 0;
        if (pathMatrix[start][end] != -1) return pathMatrix[start][end];
        int pathCount = uniquePathsWithRec(A, start - 1, end) +
                uniquePathsWithRec(A, start, end - 1);
        pathMatrix[start][end] = pathCount;
        return pathCount;

    }

    public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {
        pathMatrix = new int[A.size()][A.get(0).size()];
        for (int i = 0; i < A.size(); i++) {
            Arrays.fill(pathMatrix[i], -1);
        }
        return uniquePathsWithRec(A, 0, 0);
    }


    private int uniquePathsWithRec(ArrayList<ArrayList<Integer>> A, int start, int end) {
        int n = A.size(), m = A.get(0).size();
        if (start == n - 1 && end == m - 1 && A.get(start).get(end) < 1) return 1;
        if (A.get(start).get(end) == 1) return 0;

        if (start < n - 1 && pathMatrix[start + 1][end] == -1) {
            pathMatrix[start + 1][end] = uniquePathsWithRec(A, start + 1, end);
        }

        if (end < m - 1 && pathMatrix[start][end + 1] == -1) {
            pathMatrix[start][end + 1] = uniquePathsWithRec(A, start, end + 1);
        }

        return (start == n - 1 ? 0 : pathMatrix[start + 1][end]) +
                (end == m - 1 ? 0 : pathMatrix[start][end + 1]);
    }
}
