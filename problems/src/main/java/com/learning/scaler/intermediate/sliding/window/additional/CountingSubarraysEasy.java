package com.learning.scaler.intermediate.sliding.window.additional;


import java.util.ArrayList;

/*
Problem Description
    Given an array A of N non-negative numbers and a non-negative number B,
    you need to find the number of subarrays in A with a sum less than B.
    We may assume that there is no overflow.

Problem Constraints
    1 <= N <= 5 x 10^3
    1 <= A[i] <= 1000
    1 <= B <= 10^7

Input Format
    First argument is an integer array A.
    Second argument is an integer B.

Output Format
    Return an integer denoting the number of subarrays in A having sum less than B.

Example Input
    Input 1:
         A = [2, 5, 6]
         B = 10
    Input 2:
         A = [1, 11, 2, 3, 15]
         B = 10

Example Output
    Output 1:
         4
    Output 2:
         4

Example Explanation
    Explanation 1:
         The subarrays with sum less than B are {2}, {5}, {6} and {2, 5},
    Explanation 2:
         The subarrays with sum less than B are {1}, {2}, {3} and {2, 3}
* */
public class CountingSubarraysEasy {

    public int solve(ArrayList<Integer> A, int B) {
        int count = 0;
        for (int s = 0; s < A.size(); s++) {
            int currentSum = 0;
            for (int e = s; e < A.size(); e++) {
                currentSum += A.get(e);
                if (currentSum < B) count++;
            }
        }
        return count;
    }

    public int solve(int[] A, int B) {
        int n = A.length;
        int[] pref = new int[n];
        pref[0] = A[0];
        int ans = 0;
        for (int i = 1; i < n; i++) pref[i] = pref[i - 1] + A[i];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = pref[j];
                if (i > 0) {
                    sum -= pref[i - 1];
                }
                if (sum < B) ans++;
            }
        }
        return ans;
    }
}
