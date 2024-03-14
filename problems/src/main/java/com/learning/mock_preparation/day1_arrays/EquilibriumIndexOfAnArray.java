package com.learning.mock_preparation.day1_arrays;


/*
Problem Description
    You are given an array A of integers of size N.
    Your task is to find the equilibrium index of the given array,
    The equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to
    the sum of elements at higher indexes.
    If there are no elements that are at lower indexes or at higher indexes, then the corresponding sum of
    elements is considered as 0.

    Note:
        Array indexing starts from 0.
        If there is no equilibrium index, then return -1.
        If there is more than one equilibrium index, then return the minimum index.


Problem Constraints
    1 <= N <= 10^5
    -10^5 <= A[i] <= 10^5

Input Format
    First argument is an array A.

Output Format
     Returns the equilibrium index of the given array. If no such index is found then return -1.

Example Input
    Input 1:
        A = [-7, 1, 5, 2, -4, 3, 0]
    Input 2:
        A = [1, 2, 3]

Example Output
    Output 1:
        3
    Output 2:
        -1

Example Explanation
    Explanation 1:
        i   Sum of elements at lower indexes    Sum of elements at higher indexes
        0                   0                                   7
        1                  -7                                   6
        2                  -6                                   1
        3                  -1                                  -1
        4                   1                                   3
        5                  -3                                   0
        6                   0                                   0

        3 is an equilibrium index, because:
        A[0] + A[1] + A[2] = A[4] + A[5] + A[6]
    Explanation 1
        I Sum of elements at lower indexes Sum of elements at higher indexes
        0 0 5
        1 1 3
        2 3 0
        Thus, there is no such index.
* */
public class EquilibriumIndexOfAnArray {

    public int solve(int[] A) {
        if (A == null || A.length == 0) return -1;
        long[] prefixSum = new long[A.length];
        prefixSum[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + A[i];
        }
        for (int i = 0; i < A.length; i++) {
            long leftSum = i > 0 ? prefixSum[i - 1] : 0;
            long rightSum = prefixSum[prefixSum.length - 1] - prefixSum[i];
            if (leftSum == rightSum) return i;
        }
        return -1;
    }


}
