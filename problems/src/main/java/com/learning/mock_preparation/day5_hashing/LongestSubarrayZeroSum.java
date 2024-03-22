package com.learning.mock_preparation.day5_hashing;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Problem Description
    Given an array A of N integers.
    Find the length of the longest subarray in the array which sums to zero.
    If there is no subarray that sums to zero, then return 0.

Problem Constraints
    1 <= N <= 10^5
    -10^9 <= A[i] <= 10^9

Input Format
    Single argument, which is an integer array, A.

Output Format
     Returns an integer.

Example
    Input 1:
         A = [1, -2, 1, 2]
    Input 2:
         A = [3, 2, -1]

Example
    Output 1:
        3
    Output 2:
        0

Example
    Explanation 1:
         [1, -2, 1] is the largest subarray which sums up to 0.
    Explanation 2:
         No subarray sums up to 0.
* */
public class LongestSubarrayZeroSum {

    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<>(List.of(9, -20, -11, -8, -4, 2, -12, 14, 1))));

    }

    // https://www.scaler.com/academy/mentee-dashboard/class/155293/assignment/problems/27742
    public int solve(int[] A) {
        HashMap<Long, Integer> sumMap = new HashMap<>();
        int maxLen = 0;
        long sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum == 0) {
                maxLen = i + 1;
            } else {
                if (sumMap.containsKey(sum)) {
                    maxLen = Math.max(maxLen, i - sumMap.get(sum));
                } else {
                    sumMap.put(sum, i);
                }
            }
        }
        return maxLen;
    }


    public static int solve(ArrayList<Integer> A) {
        int maxLength = 0;
        HashMap<Long, Integer> sumMap = new HashMap<>();
        long currentVal = 0;
        for (int i = 0; i < A.size(); i++) {
            currentVal += A.get(i);
            if (currentVal == 0) {
                maxLength = Math.max(maxLength, i + 1);
            } else {
                int prevIndex = sumMap.getOrDefault(currentVal, -1);
                if (prevIndex > -1) {
                    maxLength = Math.max(maxLength, (i - prevIndex));
                } else sumMap.put(currentVal, i);
            }
        }
        return maxLength;
    }


}
