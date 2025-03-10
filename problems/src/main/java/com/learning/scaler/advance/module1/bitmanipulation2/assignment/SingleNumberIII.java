package com.learning.scaler.advance.module1.bitmanipulation2.assignment;


import java.util.Arrays;

/*
Problem Description
    Given an array of positive integers A, two integers appear only once, and all the other integers appear twice.
    Find the two integers that appear only once.
    Note: Return the two numbers in ascending order.

Problem Constraints
    2 <= |A| <= 100000
    1 <= A[i] <= 10^9

Input Format
    The first argument is an array of integers of size N.

Output Format
     Returns an array of two integers that appear only once.

Example
    Input 1:
        A = [1, 2, 3, 1, 2, 4]
    Input 2:
        A = [1, 2]

Example
    Output 1:
        [3, 4]
    Output 2:
        [1, 2]

Example
    Explanation 1:
        3 and 4 appear only once.
    Explanation 2:
        1 and 2 appear only once.
* */
public class SingleNumberIII {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(new int[]{1, 2, 3, 1, 2, 4})));
    }

    public static int[] solve(int[] A) {
        int xor = A[0];
        for (int i = 1; i < A.length; i++) {
            xor = xor ^ A[i];
        }
        int pos = 0;
        for (pos = 0; pos < 32; pos++) {
            if ((xor & (1 << pos)) > 1) break;
        }
        int firstNumber = 0, secondNumber = 0;
        for (int j : A) {
            if ((j & (1 << pos)) > 1) {
                firstNumber = firstNumber ^ j;
            } else secondNumber = secondNumber ^ j;
        }
        return new int[]{Math.min(firstNumber, secondNumber),
                Math.max(firstNumber, secondNumber)};
    }
}
