package com.learning.scaler.advance.module4.dp4.lecture;

import java.util.Arrays;

/*
Problem Description
    Given a rod of length N units and an array A of size N denotes prices that contains prices of all
    pieces of size 1 to N.
    Find and return the maximum value that can be obtained by cutting up the rod and selling the pieces.

Problem Constraints
    1 <= N <= 1000
    0 <= A[i] <= 10^6

Input Format
    First and only argument is an integer array A of size N.

Output Format
    Return an integer denoting the maximum value that can be obtained by cutting up
    the rod and selling the pieces.

Example Input
    Input 1:
     A = [3, 4, 1, 6, 2]
    Input 2:
     A = [1, 5, 2, 5, 6]

Example Output
    Output 1:
        15
    Output 2:
        11

Example Explanation
    Explanation 1:
         Cut the rod of length 5 into 5 rods of length (1, 1, 1, 1, 1) and sell them for (3 + 3 + 3 + 3 + 3) = 15.
    Explanation 2:
         Cut the rod of length 5 into 3 rods of length (2, 2, 1) and sell them for (5 + 5 + 1) = 11.
* */
public class CuttingARod {

    public static void main(String[] args) {
        com.learning.scaler.advance.module4.dp4.assignment.CuttingARod rod = new com.learning.scaler.advance.module4.dp4.assignment.CuttingARod();
        System.out.println(rod.cuttingRodsIterative(new int[]{3, 4, 1, 6, 2}));
    }

    int[] profitMatrix;

    public int cuttingRods(int[] A) {
        if (A == null || A.length == 0) return 0;
        profitMatrix = new int[A.length + 1];
        Arrays.fill(profitMatrix, -1);
        profitMatrix[0] = 0;
        return cuttingRodsTopDown(A, A.length);
    }

    public int cuttingRods(int[] A, int capacity) {
        if (capacity <= 0) return 0;
        int currentMax = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            int current = 0;
            if (i + 1 <= capacity) {
                current = A[i] + cuttingRods(A, capacity - (i + 1));
            }
            currentMax = Math.max(currentMax, current);
        }
        return (currentMax == Integer.MIN_VALUE) ? 0 : currentMax;
    }

    public int cuttingRodsTopDown(int[] A, int capacity) {
        if (capacity <= 0) return 0;
        if (profitMatrix[capacity] != -1) return profitMatrix[capacity];
        int currentMax = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            int current = 0;
            if (i + 1 <= capacity) {
                current = A[i] + cuttingRods(A, capacity - (i + 1));
            }
            currentMax = Math.max(currentMax, current);
        }
        profitMatrix[capacity] = (currentMax == Integer.MIN_VALUE) ? 0 : currentMax;
        return profitMatrix[capacity];
    }

    // need to check it
    public int cuttingRodsIterative(int[] A) {
        int[] profitMatrix = new int[A.length + 1];
        profitMatrix[0] = 0;
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= i; j++) {
                profitMatrix[i] = Math.max(profitMatrix[i], A[j] + profitMatrix[i - j]);
            }
        }
        return profitMatrix[A.length];
    }
}
