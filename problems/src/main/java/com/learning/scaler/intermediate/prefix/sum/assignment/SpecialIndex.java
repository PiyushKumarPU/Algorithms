package com.learning.scaler.intermediate.prefix.sum.assignment;

/*
Problem Description
    Given an array, arr[] of size N, the task is to find the count of array indices such that removing an
    element from these indices makes the sum of even-indexed and odd-indexed array elements equal.

Problem Constraints
    1 <= N <= 10^5
    -10^5 <= A[i] <= 10^5
    Sum of all elements of A <= 10^9

Input Format
    First argument contains an array A of integers of size N

Output Format
    Return the count of array indices such that removing an element from these indices makes the sum of
    even-indexed and odd-indexed array elements equal.

Example Input
    Input 1:
        A = [2, 1, 6, 4]
    Input 2:
        A = [1, 1, 1]

Example Output
    Output 1:
        1
    Output 2:
        3
* */
public class SpecialIndex {

    public int solve(int[] A) {
        long[] PFEven = new long[A.length];
        long[] PFOdd = new long[A.length];
        PFEven[0] = A[0];
        PFOdd[0] = 0;
        int count = 0;
        for (int index = 1; index < A.length; index++) {
            PFEven[index] = PFEven[index - 1] + (index % 2 == 0 ? A[index] : 0);
            PFOdd[index] = PFOdd[index - 1] + (index % 2 != 0 ? A[index] : 0);
        }

        // derived
        long lastEvenIndex = PFEven[A.length - 1];
        long lastOddIndex = PFOdd[A.length - 1];
        for (int index = 0; index < A.length; index++) {
            long evenSum = (index > 0 ? PFEven[index - 1] : 0) + (lastOddIndex - PFOdd[index]);
            long oddSum = (index > 0 ? PFOdd[index - 1] : 0) + (lastEvenIndex - PFEven[index]);
            if (evenSum == oddSum) count++;
        }
        return count;

    }
}
