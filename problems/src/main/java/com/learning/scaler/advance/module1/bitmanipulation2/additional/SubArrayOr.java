package com.learning.scaler.advance.module1.bitmanipulation2.additional;


/*
Problem Description
    You are given an array of integers A of size N.
    The value of a subarray is defined as BITWISE OR of all elements in it.
    Return the sum of value of all subarrays of A % 109 + 7.

Problem Constraints
    1 <= N <= 10^5
    1 <= A[i] <= 10^8

Input Format
    The first argument given is the integer array A.

Output Format
    Return the sum of Value of all subarrays of A % 109 + 7.

Example Input
    Input 1:
         A = [1, 2, 3, 4, 5]
    Input 2:
         A = [7, 8, 9, 10]

Example Output
    Output 1:
         71
    Output 2:
         110

Example Explanation
    Explanation 1:
         Value([1]) = 1
         Value([1, 2]) = 3
         Value([1, 2, 3]) = 3
         Value([1, 2, 3, 4]) = 7
         Value([1, 2, 3, 4, 5]) = 7
         Value([2]) = 2
         Value([2, 3]) = 3
         Value([2, 3, 4]) = 7
         Value([2, 3, 4, 5]) = 7
         Value([3]) = 3
         Value([3, 4]) = 7
         Value([3, 4, 5]) = 7
         Value([4]) = 4
         Value([4, 5]) = 5
         Value([5]) = 5
         Sum of all these values = 71
    Explanation 2:
         Sum of value of all subarray is 110.
* */
public class SubArrayOr {

    public int solve(int[] A) {

        return 1;
    }
}
