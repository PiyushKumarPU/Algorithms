package com.learning.scaler.advance.module4.dp3.assignment;

import java.util.*;
import java.util.stream.Collectors;

/*
Problem Description
    Given two integer arrays A and B of size N each which represent values and weights associated with N
    items respectively.
    Also given an integer C which represents knapsack capacity.
    Find out the maximum value subset of A such that sum of the weights of this subset is smaller
    than or equal to C.
    NOTE:
        You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).

Problem Constraints
    1 <= N <= 10^3
    1 <= C <= 10^3
    1 <= A[i], B[i] <= 10^3

Input Format
    First argument is an integer array A of size N denoting the values on N items.
    Second argument is an integer array B of size N denoting the weights on N items.
    Third argument is an integer C denoting the knapsack capacity.

Output Format
    Return a single integer denoting the maximum value subset of A such that sum of the weights of this subset is
    smaller than or equal to C.

Example Input
    Input 1:
         A = [60, 100, 120]
         B = [10, 20, 30]
         C = 50
    Input 2:
         A = [10, 20, 30, 40]
         B = [12, 13, 15, 19]
         C = 10
Example Output
    Output 1:
        220
    Output 2:
        0

Example Explanation
    Explanation 1:
        Taking items with weight 20 and 30 will give us the maximum value i.e 100 + 120 = 220
    Explanation 2:
        Knapsack capacity is 10 but each item has weight greater than 10 so no items can be considered in the
        knapsack therefore answer is 0.
* */
public class ZeroOne01Knapsack {

    public static void main(String[] args) {
        int[] A = {359, 963, 465, 706, 146, 282, 828, 962, 492}, B = {96, 43, 28, 37, 92, 5, 3, 54, 93};
        int C = 383;
        ZeroOne01Knapsack knapsack = new ZeroOne01Knapsack();
        System.out.println(knapsack.solve(A, B, C));
    }

    int[][] indexWeightPair;
    public int solve(int[] A, int[] B, int C) {
        indexWeightPair = new int[A.length + 1][C + 1];
        for (int[] arr : indexWeightPair) Arrays.fill(arr, -1);
        return solve(A, B, C, A.length - 1);
    }

    private int solve(int[] A, int[] B, int C, int index) {
        if (index < 0) return 0;
        if (indexWeightPair[index][C] != -1) return indexWeightPair[index][C];
        int dontTake = solve(A, B, C, index - 1);
        int take = (C >= B[index]) ? (A[index] + solve(A, B, C - B[index], index - 1)) : 0;
        indexWeightPair[index][C] = Math.max(take, dontTake);
        return indexWeightPair[index][C];
    }
}
