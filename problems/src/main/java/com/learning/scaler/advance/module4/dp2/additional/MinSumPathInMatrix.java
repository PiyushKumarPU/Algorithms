package com.learning.scaler.advance.module4.dp2.additional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    int[][] minSumPathMatrix;

    public int minPathSum(ArrayList<ArrayList<Integer>> A) {
        minSumPathMatrix = new int[A.size()][A.get(0).size()];
        for (int[] arr : minSumPathMatrix) Arrays.fill(arr, Integer.MIN_VALUE);
        return minPathSum(A, A.size() - 1, A.get(0).size() - 1);
    }

    private int minPathSum(ArrayList<ArrayList<Integer>> A, int start, int end) {
        if (start < 0 || end < 0) return Integer.MAX_VALUE;
        else if (start == 0 && end == 0) return A.get(start).get(end);
        else if (minSumPathMatrix[start][end] != Integer.MIN_VALUE) return minSumPathMatrix[start][end];
        else if (start == 0) return A.get(start).get(end) + minPathSum(A, start, end - 1);
        else if (end == 0) return A.get(start).get(end) + minPathSum(A, start - 1, end);
        else
            minSumPathMatrix[start][end] = A.get(start).get(end) + Math.min(minPathSum(A, start - 1, end), minPathSum(A, start, end - 1));
        return minSumPathMatrix[start][end];
    }
}
