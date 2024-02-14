package com.learning.scaler.intermediate.sliding.window.additional;


import java.util.ArrayList;

/*
Problem Description
    Given an array of integers A, a subarray of an array is said to be good if it fulfills any one of the criteria:
        1. Length of the subarray is be even, and the sum of all the elements of the subarray must be less than B.
        2. Length of the subarray is be odd, and the sum of all the elements of the subarray must be greater than B.
        Your task is to find the count of good subarrays in A.

Problem Constraints
    1 <= len(A) <= 5 x 10^3
    1 <= A[i] <= 10^3
    1 <= B <= 10^7

Input Format
    The first argument given is the integer array A.
    The second argument given is an integer B.

Output Format
    Return the count of good subarrays in A.

Example Input
    Input 1:
        A = [1, 2, 3, 4, 5]
        B = 4
    Input 2:
        A = [13, 16, 16, 15, 9, 16, 2, 7, 6, 17, 3, 9]
        B = 65

Example Output
    Output 1:
        6
    Output 2:
        36

Example Explanation
    Explanation 1:
        Even length good subarrays = {1, 2}
        Odd length good subarrays = {1, 2, 3}, {1, 2, 3, 4, 5}, {2, 3, 4}, {3, 4, 5}, {5}
    Explanation 1:
        There are 36 good subarrays
* */
public class GoodSubarraysEasy {

    public int solve(ArrayList<Integer> A, int B) {
        int count = 0;
        for (int s = 0; s < A.size(); s++) {
            int currentSum = 0;
            for (int e = s; e < A.size(); e++) {
                currentSum += A.get(e);
                boolean isEven = (e - s + 1) % 2 == 0;
                if ((isEven && currentSum < B) || (!isEven && currentSum > B)) count++;
            }
        }
        return count;
    }

    public int solve(int[] A, int B) {
        int n = A.length;
        int[] pref = new int[n];
        pref[0] = A[0];
        int ans = 0;
        for (int i = 1; i < n; i++) {
            pref[i] = pref[i - 1] + A[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sz = j - i + 1;
                int sum;
                if (i == 0) {
                    sum = pref[j];
                } else {
                    sum = pref[j] - pref[i - 1];
                }
                if (sz % 2 == 0 && sum < B) ans++;
                if (sz % 2 == 1 && sum > B) ans++;
            }
        }
        return ans;
    }


}
