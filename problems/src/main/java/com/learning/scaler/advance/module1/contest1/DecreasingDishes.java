package com.learning.scaler.advance.module1.contest1;

import java.util.List;

/*
Problem Description:
Given an array of N positive integers representing the weights of ingredients in a dish.
Find the maximum possible sum of a subarray with decreasing weights.

Problem Constraints:
    1 <= N <= 10^5
    0 <= A[i] <= 10^5
    Sum of all elements of A <= 10^9

Input format:
    First argument A is an array of integers.
Output Format;
    Return an integer denoting maximum possible sum of a subarray with decreasing weights.

Example Input:
    Input 1:
        A = [3, 2, 1]
    Input 2:
        A = [3, 3, 5, 0, 1]

Example Output:
    Output 1: 6
    Output 2: 5

Example Explanation:
    Example 1:
        We can take the subarray indexed [0-2] which are in decreasing order the sum the elements are 3+2+1=6.
    Example 2:
        We can take the subarray indexed [2-3] which are in decreasing order the sum of the elements are 5+0=5.
*
* */
public class DecreasingDishes {

    public static void main(String[] args) {

    }


    public int solve(List<Integer> A) {
        int sum = Integer.MIN_VALUE, currentSum = 0;
        for (int i = 0; i < A.size() - 1; i++) {
            if (currentSum < 1) currentSum = A.get(i);
            if (A.get(i) > A.get(i + 1)) {
                currentSum = currentSum + A.get(i + 1);
                sum = Math.max(sum, currentSum);
            } else {
                currentSum = 0;
            }
        }
        if (A.get(A.size() - 1) > A.get(A.size() - 2)) {
            sum = Math.max(sum, A.get(A.size() - 1));
        }
        return sum;
    }
}
