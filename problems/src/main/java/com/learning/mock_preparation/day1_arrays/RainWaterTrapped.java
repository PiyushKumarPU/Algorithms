package com.learning.mock_preparation.day1_arrays;

/*
Problem Description
    Given a vector A of non-negative integers representing an elevation map where the width of each bar is 1,
    compute how much water it is able to trap after raining.

Problem Constraints
    1 <= |A| <= 100000

Input Format
    First and only argument is the vector A

Output Format
     Returns one integer, the answer to the question

Example
    Input 1:
        A = [0, 1, 0, 2]
    Input 2:
        A = [1, 2]

Example
    Output 1:
        1
    Output 2:
        0

Example
    Explanation 1:
        1 unit is trapped on top of the 3rd element.
    Explanation 2:
        No water is trapped.
* */
public class RainWaterTrapped {

    public static void main(String[] args) {
        int[] input = new int[]{0, 1, 0, 2};
        System.out.println(trap(input));
    }

    public static int trap(final int[] A) {
        int trappedWater = 0, size = A.length;
        int[] leftMax = new int[size], rightMax = new int[size];
        leftMax[0] = rightMax[size - 1] = 0;
        for (int i = 0; i < size; i++) {
            int lastIndex = size - 1 - i;
            leftMax[i] = i > 0 ? Math.max(leftMax[i - 1], A[i - 1]) : 0;
            rightMax[lastIndex] = lastIndex < (size - 1) ? Math.max(rightMax[lastIndex + 1], A[lastIndex + 1]) : 0;
        }
        for (int i = 0; i < size; i++) {
            int currentWater = Math.min(leftMax[i], rightMax[i]) - A[i];
            if (currentWater > 0) trappedWater += currentWater;
        }
        return trappedWater;
    }


}
