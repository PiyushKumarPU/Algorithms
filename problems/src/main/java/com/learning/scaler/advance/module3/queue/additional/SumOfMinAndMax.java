package com.learning.scaler.advance.module3.queue.additional;


import java.math.BigInteger;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
Problem Description
    Given an array A of both positive and negative integers.
    Your task is to compute the sum of minimum and maximum elements of all sub-array of size B.
    NOTE: Since the answer can be very large, you are required to return the sum modulo 10^9 + 7.

Problem Constraints
    1 <= size of array A <= 10^5
    -10^9 <= A[i] <= 10^9
    1 <= B <= size of array

Input Format
    The first argument denotes the integer array A.
    The second argument denotes the value B

Output Format
    Return an integer that denotes the required value.

Example
    Input 1:
         A = [2, 5, -1, 7, -3, -1, -2]
         B = 4
    Input 2:
         A = [2, -1, 3]
         B = 2

Example
    Output 1:
         18
    Output 2:
         3

Example
    Explanation 1:
         Subarrays of size 4 are :
            [2, 5, -1, 7],   min + max = -1 + 7 = 6
            [5, -1, 7, -3],  min + max = -3 + 7 = 4
            [-1, 7, -3, -1], min + max = -3 + 7 = 4
            [7, -3, -1, -2], min + max = -3 + 7 = 4
            Sum of all min & max = 6 + 4 + 4 + 4 = 18
    Explanation 2:
         Subarrays of size 2 are :
            [2, -1],   min + max = -1 + 2 = 1
            [-1, 3],   min + max = -1 + 3 = 2
            Sum of all min & max = 1 + 2 = 3
* */
public class SumOfMinAndMax {

    public static void main(String[] args) {
        System.out.println(solve(new int[]{2, 5, -1, 7, -3, -1, -2}, 4));
        System.out.println(solve(new int[]{2, -1, 3}, 2));
    }

    public static int solve(int[] A, int B) {
        if (A == null || B == 0) return 0;
        BigInteger sum = BigInteger.ZERO, MOD = BigInteger.valueOf(1000000007);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < B; i++) {
            minHeap.add(A[i]);
            maxHeap.add(A[i]);
        }
        sum = sum.add(BigInteger.valueOf(minHeap.peek() + maxHeap.peek()));
        sum = sum.mod(MOD);
        for (int i = 1; i < A.length - B + 1; i++) {
            minHeap.remove(A[i - 1]);
            maxHeap.remove(A[i - 1]);
            minHeap.add(A[i + B - 1]);
            maxHeap.add(A[i + B - 1]);
            sum = sum.add(BigInteger.valueOf(minHeap.peek() + maxHeap.peek()));
            sum = sum.mod(MOD);
        }
        return sum.intValue();
    }
}
