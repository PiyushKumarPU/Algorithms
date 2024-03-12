package com.learning.scaler.advance.module1.bitmanipulation2.additional;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
Problem Description
    Given an integer array A of N integers, find the pair of integers in the array which have minimum XOR value.
    Report the minimum XOR value.

Problem Constraints
    2 <= length of the array <= 100000
    0 <= A[i] <= 10^9

Input Format
    First and only argument of input contains an integer array A.

Output Format
     Returns a single integer denoting minimum xor value.

Example
    Input 1:
         A = [0, 2, 5, 7]
    Input 2:
         A = [0, 4, 7, 9]

Example
    Output 1:
         2
    Output 2:
         3

Example
    Explanation 1:
         0 xor 2 = 2
* */
public class MinXORValue {

    public static void main(String[] args) {
        System.out.println(findMinXor(new ArrayList<>(List.of(6, 2, 7))));
    }

    public static int findMinXor(ArrayList<Integer> A) {
        A.sort(Comparator.naturalOrder());
        int minXor = Integer.MAX_VALUE, val = 0;
        for (int i = 0; i < A.size() - 1; i++) {
            val = A.get(i) ^ A.get(i + 1);
            minXor = Math.min(minXor, val);
        }
        return minXor;
    }
}
