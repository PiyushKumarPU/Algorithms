package com.learning.scaler.advance.module4.dp4.additional;

import java.util.ArrayList;
import java.util.HashMap;

/*
Problem Description
    Given a strictly increasing array A of positive integers forming a sequence.
    A sequence X1, X2, X3, ..., XN is fibonacci like if
    N > =3
        Xi + Xi+1 = Xi+2 for all i+2 <= N
        Find and return the length of the longest Fibonacci-like subsequence of A.
    If one does not exist, return 0.
    NOTE: A subsequence is derived from another sequence A by deleting any number of elements (including none) from A,
    without changing the order of the remaining elements.

Problem Constraints
    3 <= length of the array <= 1000
    1 <= A[i] <= 10^9

Input Format
    The only argument given is the integer array A.

Output Format
    Return the length of the longest Fibonacci-like subsequence of A.
    If one does not exist, return 0.

Example Input
    Input 1:
     A = [1, 2, 3, 4, 5, 6, 7, 8]
    Input 2:
     A = [1, 3, 7, 11, 12, 14, 18]

Example Output
    Output 1:
     5
    Output 2:
     3

Example Explanation
    Explanation 1:
     The longest subsequence that is fibonacci-like: [1, 2, 3, 5, 8].
    Explanation 2:
     The longest subsequence that is fibonacci-like: [1, 11, 12], [3, 11, 14] or [7, 11, 18].
     The length will be 3.
* */
public class LengthOfLongestFibonacciSubsequence {

    public static void main(String[] args) {
        System.out.println(solve(new int[]{1, 2, 3, 5, 8}));
    }

    public int lenLongestFibSubseqBF(int[] A) {
        int n = A.length;
        int longestLength = 0;

        // Iterate over all possible starting indices of the subsequence
        for (int i = 0; i < n - 2; i++) {
            // Iterate over all possible middle indices of the subsequence
            for (int j = i + 1; j < n - 1; j++) {
                int currentLength = 2; // Initialize with two elements A[i] and A[j]
                int prev1 = A[i];
                int prev2 = A[j];

                // Check subsequent elements to see if they form a Fibonacci-like sequence
                for (int k = j + 1; k < n; k++) {
                    int next = prev1 + prev2;
                    if (next == A[k]) {
                        currentLength++;
                        prev1 = prev2;
                        prev2 = next;
                    }
                }

                // Update the longest length found
                longestLength = Math.max(longestLength, currentLength);
            }
        }

        // Return the length of the longest Fibonacci-like subsequence found
        return longestLength >= 3 ? longestLength : 0;
    }

    public static int solve(int[] A) {
        int n = A.length, maxLength = 0;
        // for index 0 and 1 there would not be any fibonacci so wil keep it as 0
        // creating a dp array to hold longest fibonacci crated using index i and j
        int[][] dp = new int[n][n];

        for (int i = 2; i < n; i++) {
            // check if there is any pair before i whose sum would be equal to A[i]
            int start = 0, end = i - 1;
            while (start < end) {
                int currentTotal = A[start] + A[end];
                if (currentTotal > A[i])
                    end--;
                else if (currentTotal < A[i]) start++;
                else {
                    dp[end][i] = dp[start][end] + 1;
                    maxLength = Math.max(maxLength, dp[end][i]);
                    /*start++;
                    end--;*/
                    break;
                }
            }
        }
        // if maxLength is greater than 0 it means there was a fibonacci so we will add 2 to accommodate 2 index which
        // we didn't add
        return maxLength > 0 ? maxLength + 2 : 0;
    }


}
