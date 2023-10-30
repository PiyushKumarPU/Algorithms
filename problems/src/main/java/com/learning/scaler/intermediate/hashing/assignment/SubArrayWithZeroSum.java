package com.learning.scaler.intermediate.hashing.assignment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Problem Description
Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.

If the given array contains a sub-array with sum zero return 1, else return 0.

Problem Constraints
1 <= |A| <= 100000

-10^9 <= A[i] <= 10^9

Input Format
The only argument given is the integer array A.


Output Format
Return whether the given array contains a subarray with a sum equal to 0.


Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
Input 2:

 A = [4, -1, 1]


Example Output
Output 1:

 0
Output 2:
 1

Example Explanation
Explanation 1:

 No subarray has sum 0.
Explanation 2:

 The subarray [-1, 1] has sum 0.


GFG Link
https://www.geeksforgeeks.org/find-if-there-is-a-subarray-with-0-sum/

* */
public class SubArrayWithZeroSum {

    public static void main(String[] args) {
        System.out.println(solve(List.of(1, 2, 3, 4, 5)));
        System.out.println(solve(List.of(4, -1, 1)));
    }

    public static int solve(List<Integer> A) {
        Map<Long, Integer> frequencyMap = new HashMap<>();
        long currentSum = A.get(0);
        frequencyMap.put(currentSum, 1);
        for (int element : A) {
            currentSum += element;
            if (currentSum == 0) return 1;
            if (frequencyMap.containsKey(currentSum)) return 1;
            frequencyMap.put(currentSum, (frequencyMap.getOrDefault(currentSum, 0) + 1));
        }
        return 0;
    }


}
