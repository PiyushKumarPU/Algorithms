package com.learning.mock_preparation.day13_dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>(
                List.of(new ArrayList<>(List.of(1, 2, 3, 4)),
                        new ArrayList<>(List.of(2, 3, 4, 5)))
        );
        System.out.println(adjacent(A));
    }

    public static int adjacent(ArrayList<ArrayList<Integer>> A) {
        int size = A.get(0).size();
        int[] dp = new int[size];
        Arrays.fill(dp, -1);
        //  System.out.println(adjacentRec(A, 0, size - 1));
        System.out.println(adjacentRecWithDp(A, dp, 0, size - 1));
        return 0;
    }


    public static int adjacentRecWithDp(ArrayList<ArrayList<Integer>> A, int[] dp, int start, int end) {

        return 0;
    }

    public static int adjacentRec(ArrayList<ArrayList<Integer>> A, int start, int end) {
        return 0;
    }

}
