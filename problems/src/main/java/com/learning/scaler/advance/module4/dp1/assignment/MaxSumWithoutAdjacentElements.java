package com.learning.scaler.advance.module4.dp1.assignment;

import java.util.Arrays;

/*
Problem Description
    Given a 2 x N grid of integers, A, your task is to choose numbers from the grid such that sum of these numbers is maximized.
    However, you cannot choose two numbers that are adjacent horizontally, vertically, or diagonally.
    Return the maximum possible sum.
    Note: You are allowed to choose more than 2 numbers from the grid.

Problem Constraints
    1 <= N <= 20000
    1 <= A[i] <= 2000

Input Format
    The first and the only argument of input contains a 2d matrix, A.

Output Format
    Return an integer, representing the maximum possible sum.


Example Input
    Input 1:

         A = [
                [1]
                [2]
             ]
    Input 2:

         A = [
                [1, 2, 3, 4]
                [2, 3, 4, 5]
             ]

Example Output
    Output 1:
        2
    Output 2:
        8
* */
public class MaxSumWithoutAdjacentElements {

    int[] maxSumArray;

    public int adjacent(int[][] A) {
        if (A.length < 2 || A[0].length < 1) return 0;
        maxSumArray = new int[A[0].length];
        Arrays.fill(maxSumArray, -1);
        return adjacentWithRec(A, 0, A[0].length - 1);
    }

    public int adjacentWithRec(int[][] A, int start, int end) {
        // add base condition
        if (start > end) return 0;
        if (maxSumArray[start] != -1) return maxSumArray[start];
        int take = Math.max(A[0][start], A[1][start]) + adjacentWithRec(A, start + 2, end);
        int dontTake = adjacentWithRec(A, start + 1, end);
        maxSumArray[start] = Math.max(take, dontTake);
        return maxSumArray[start];
    }

    public int adjacentIterative(int[][] A) {
        if (A.length < 2 || A[0].length < 1) return 0;
        maxSumArray = new int[A[0].length];
        Arrays.fill(maxSumArray, -1);
        return adjacentWithRec(A, 0, A[0].length - 1);
    }
}
