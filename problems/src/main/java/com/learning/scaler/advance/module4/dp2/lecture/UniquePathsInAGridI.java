package com.learning.scaler.advance.module4.dp2.lecture;

import java.util.Arrays;

/*
Problem Description
    Given a grid of size n * m, lets assume you are starting at (1,1) and your goal is to reach (n, m).
    At any instance, if you are on (x, y), you can either go to (x, y + 1) or (x + 1, y).
    Return the total number unique paths from (1, 1) to (n, m).

    Note:
        1. Given Source Point and Destination points are 1-based index.

Problem Constraints
    1 <= n, m <= 100
    A[i][j] = 0 or 1

Input Format
    First and only argument A is a 2D array of size n * m.

Output Format
     Returns an integer denoting the number of unique paths from (1, 1) to (n, m).

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
public class UniquePathsInAGridI {

    static int[][] pathMatrix;
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
        System.out.println(uniquePathsDp1(3, 7));
    }

    // BF
    public int uniquePathsBF(int[][] A) {
        if (A.length == 0 || A[0].length == 0) return 0;
        return uniquePathsBFRec(A.length - 1, A[0].length - 1);
    }

    private int uniquePathsBFRec(int start, int end) {
        if (start == 0 || end == 0) return 1;
        return uniquePathsBFRec(start - 1, end) + uniquePathsBFRec(start, end - 1);
    }

    // top down
    public int uniquePathsDP1(int[][] A) {
        if (pathMatrix == null) {
            pathMatrix = new int[A.length][A[0].length];
            for (int[] arr : pathMatrix) Arrays.fill(arr, -1);
        }
        return uniquePathsDP1Rec(A.length - 1, A[0].length - 1);
    }

    private int uniquePathsDP1Rec(int start, int end) {
        if (start == 0 || end == 0) return 1;
        if (pathMatrix[start][end] != -1) return pathMatrix[start][end];
        pathMatrix[start][end] = uniquePathsBFRec(start - 1, end) + uniquePathsBFRec(start, end - 1);
        return pathMatrix[start][end];
    }

    // bottom up
    public int uniquePathsDP2(int[][] A) {
        if (pathMatrix == null) {
            pathMatrix = new int[A.length][A[0].length];
            for (int i = 0; i < pathMatrix.length; i++) {
                if (i == 0) Arrays.fill(pathMatrix[i], 1);
                else {
                    Arrays.fill(pathMatrix[i], -1);
                    pathMatrix[i][0] = 1;
                }
            }
        }
        return uniquePathsDP2Rec(A.length - 1, A[0].length - 1);
    }

    private int uniquePathsDP2Rec(int start, int end) {
        if (pathMatrix[start][end] != -1) return pathMatrix[start][end];
        pathMatrix[start][end] = uniquePathsDP2Rec(start - 1, end) + uniquePathsDP2Rec(start, end - 1);
        return pathMatrix[start][end];
    }

    // leet code  BF
    public static int uniquePaths(int m, int n) {
        return uniquePathsRec(m - 1, n - 1);
    }

    private static int uniquePathsRec(int m, int n) {
        if (m == 0 || n == 0) return 1;
        return uniquePathsRec(m - 1, n) + uniquePathsRec(m, n - 1);
    }


    // Top down


    public static int uniquePathsDp1(int m, int n) {
        pathMatrix = new int[m][n];
        for (int[] arr : pathMatrix) Arrays.fill(arr, -1);
        return uniquePathsDp1Rec(m - 1, n - 1);
    }

    private static int uniquePathsDp1Rec(int m, int n) {
        if (m == 0 || n == 0) return 1;
        if (pathMatrix[m][n] != -1) return pathMatrix[m][n];
        pathMatrix[m][n] = uniquePathsDp1Rec(m - 1, n) + uniquePathsDp1Rec(m, n - 1);
        return pathMatrix[m][n];
    }

    // bottom up
    public int uniquePathsDP2(int m, int n) {
        if (pathMatrix == null) {
            pathMatrix = new int[m][n];
            for (int i = 0; i < pathMatrix.length; i++) {
                if (i == 0) Arrays.fill(pathMatrix[i], 1);
                else {
                    Arrays.fill(pathMatrix[i], -1);
                    pathMatrix[i][0] = 1;
                }
            }
        }
        return uniquePathsBURec(m - 1, n - 1);
    }

    private int uniquePathsBURec(int start, int end) {
        if (pathMatrix[start][end] != -1) return pathMatrix[start][end];
        pathMatrix[start][end] = uniquePathsBURec(start - 1, end) + uniquePathsBURec(start, end - 1);
        return pathMatrix[start][end];
    }

}
