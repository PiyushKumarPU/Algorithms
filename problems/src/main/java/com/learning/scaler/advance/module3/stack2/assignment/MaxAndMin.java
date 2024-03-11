package com.learning.scaler.advance.module3.stack2.assignment;


/*
Problem Description
    Given an array of integers A.
    The value of an array is computed as the difference between the maximum element in the array and the minimum element in the array A.
    Calculate and return the sum of values of all possible subarrays of A modulo 10^9+7.

Problem Constraints
    1 <= |A| <= 100000
    1 <= A[i] <= 1000000

Input Format
    The first and only argument given is the integer array A.

Output Format
    Return the sum of values of all possible subarrays of A modulo 109+7.

Example
    Input 1:
         A = [1]
    Input 2:
         A = [4, 7, 3, 8]

Example
    Output 1:
         0
    Output 2:
         26

Example
    Explanation 1:
        Only 1 subarray exists. Its value is 0.
    Explanation 2:
        value ( [4] ) = 4 - 4 = 0
        value ( [7] ) = 7 - 7 = 0
        value ( [3] ) = 3 - 3 = 0
        value ( [8] ) = 8 - 8 = 0
        value ( [4, 7] ) = 7 - 4 = 3
        value ( [7, 3] ) = 7 - 3 = 4
        value ( [3, 8] ) = 8 - 3 = 5
        value ( [4, 7, 3] ) = 7 - 3 = 4
        value ( [7, 3, 8] ) = 8 - 3 = 5
        value ( [4, 7, 3, 8] ) = 8 - 3 = 5
        sum of values % 10^9+7 = 26
* */
public class MaxAndMin {


    // TLE because TC : O(n^3)
    public int solveBruteForce(int[] A) {
        int size = A.length, totalSum = 0;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
                for (int k = i; k <= j; k++) {
                    min = Math.min(min, A[k]);
                    max = Math.max(max, A[k]);
                }
                totalSum += (max - min);
                totalSum %= 1000000007;
            }
        }
        return totalSum;
    }
}
