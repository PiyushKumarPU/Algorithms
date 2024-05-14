package com.learning.scaler.advance.module3.queue.additional;


import java.math.BigInteger;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
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
        int[][] maxAndMinOfEachWindow = minAndMaxSlidingWindow(A, B);
        int total = 0;
        for (int[] arr : maxAndMinOfEachWindow) {
            total += (arr[0] + arr[1]);
            total %= 1000000000 + 7;
        }
        return total;
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.peekFirst()]) deque.removeFirst();
            deque.addLast(i);
        }
        if (!deque.isEmpty())
            result[index++] = nums[deque.peekFirst()];

        for (int i = k; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == i - k) deque.removeFirst();

            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()])
                deque.removeLast();
            deque.addLast(i);

            if (!deque.isEmpty())
                result[index++] = nums[deque.peekFirst()];
        }
        return result;
    }

    public static int[] minSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] < nums[deque.peekFirst()]) deque.removeFirst();
            deque.addLast(i);
        }
        if (!deque.isEmpty())
            result[index++] = nums[deque.peekFirst()];

        for (int i = k; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == i - k) deque.removeFirst();

            while (!deque.isEmpty() && nums[i] < nums[deque.peekLast()])
                deque.removeLast();
            deque.addLast(i);

            if (!deque.isEmpty())
                result[index++] = nums[deque.peekFirst()];
        }
        return result;
    }

    public static int[][] minAndMaxSlidingWindow(int[] nums, int k) {
        int[][] result = new int[nums.length - k + 1][2];

        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            // Remove elements outside of the window
            while (!maxDeque.isEmpty() && maxDeque.peekFirst() < i - k + 1) {
                maxDeque.removeFirst();
            }
            while (!minDeque.isEmpty() && minDeque.peekFirst() < i - k + 1) {
                minDeque.removeFirst();
            }

            // Remove elements from the deque that are smaller than current element for maxDeque
            while (!maxDeque.isEmpty() && nums[i] >= nums[maxDeque.peekLast()]) {
                maxDeque.removeLast();
            }
            // Remove elements from the deque that are greater than current element for minDeque
            while (!minDeque.isEmpty() && nums[i] <= nums[minDeque.peekLast()]) {
                minDeque.removeLast();
            }

            maxDeque.addLast(i);
            minDeque.addLast(i);

            if (i >= k - 1) {
                // First element in the window is the maximum, last element is the minimum
                if (!maxDeque.isEmpty())
                    result[index][0] = nums[maxDeque.peekFirst()];
                if (!minDeque.isEmpty())
                    result[index][1] = nums[minDeque.peekFirst()];
                index++;
            }
        }

        return result;
    }
}
