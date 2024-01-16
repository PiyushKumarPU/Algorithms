package com.learning.scaler.advance.module4.dp2.additional;

import java.util.Arrays;

/*
Problem Description
    Given a M x N grid A of integers, find a path from top left to bottom right which minimizes the sum of
    all numbers along its path.
    Return the minimum sum of the path.
    NOTE: You can only move either down or right at any point in time.

Problem Constraints
    1 <= M, N <= 2000
    -1000 <= A[i][j] <= 1000

Input Format
    First and only argument is a 2-D grid A.

Output Format
    Return an integer denoting the minimum sum of the path.

Example Input
    Input 1:
         A = [
               [1, 3, 2]
               [4, 3, 1]
               [5, 6, 1]
             ]
    Input 2:
         A = [
               [1, -3, 2]
               [2, 5, 10]
               [5, -5, 1]
             ]

Example Output
    Output 1:
        8
    Output 2:
        -1


Example Explanation
    Explanation 1:
         The path will be: 1 -> 3 -> 2 -> 1 -> 1.
    Input 2:
         The path will be: 1 -> -3 -> 5 -> -5 -> 1.
* */
public class MinSumPathInMatrix {
    int[][] pathMatrix;

    public static void main(String[] args) {
        int[][] A = new int[][]{{1, 3, 2}, {4, 3, 1}, {5, 6, 1}};

        MinSumPathInMatrix matrix = new MinSumPathInMatrix();
        System.out.println(matrix.minPathSum(A));
    }


    public int minPathSum(int[][] A) {
        return minPathSumRecursion(A, 0, 0);
    }

    public int minPathSumRecursion(int[][] A, int start, int end) {
        if (pathMatrix == null) {
            pathMatrix = new int[A.length][A[0].length];
            for (int i = 0; i < A.length; i++) {
                Arrays.fill(pathMatrix[i], -1);
            }
        }
        if ((start == A.length - 1) && (end == A[0].length - 1)) return A[start][end];
        if (start == A.length || end == A[0].length) return 0;


        if (start < A.length - 1 && pathMatrix[start + 1][end] == -1) {
            pathMatrix[start + 1][end] = minPathSumRecursion(A, start + 1, end);
        }

        if (end < A[0].length - 1 && pathMatrix[start][end + 1] == -1) {
            pathMatrix[start][end + 1] = minPathSumRecursion(A, start, end + 1);
        }

        int right = start == A.length - 1 ? Integer.MAX_VALUE : pathMatrix[start + 1][end];
        int down = end == A[0].length - 1 ? Integer.MAX_VALUE : pathMatrix[start][end + 1];
        return A[start][end] + Math.min(right, down);
    }

}
