package com.learning.scaler.advance.module1.array1d.assignment;

import java.util.Arrays;
import java.util.List;

/*
Problem Description
    Given a vector A of non-negative integers representing an elevation map where the width of each bar is 1,
    compute how much water it is able to trap after raining.

Problem Constraints
    1 <= |A| <= 100000

Input Format
    First and only argument is the vector A

Output Format
    Return one integer, the answer to the question

Example Input
    Input 1:
        A = [0, 1, 0, 2]
    Input 2:
        A = [1, 2]

Example Output
    Output 1:
        1
    Output 2:
        0

Example Explanation
    Explanation 1:
        1 unit is trapped on top of the 3rd element.
    Explanation 2:
        No water is trapped.
* */
public class RainWaterTrapped {

    public static void main(String[] args) {
        System.out.println(trap(new int[]{56, 6, 52, 43, 23, 47, 48, 38, 96, 46, 30, 66, 80, 15, 62, 71, 61, 12, 98, 9, 28, 81, 70, 59, 95, 34, 9, 60, 70, 81, 71, 67, 58, 20, 22, 3, 95, 85, 20, 24, 74, 5, 23, 33, 75, 50, 38, 75, 68, 26, 46, 30, 75, 18, 4, 42, 51, 59, 8, 77}));

        System.out.println(trapScaler(new int[]{56, 6, 52, 43, 23, 47, 48, 38, 96, 46, 30, 66, 80, 15, 62, 71, 61, 12, 98, 9, 28, 81, 70, 59, 95, 34, 9, 60, 70, 81, 71, 67, 58, 20, 22, 3, 95, 85, 20, 24, 74, 5, 23, 33, 75, 50, 38, 75, 68, 26, 46, 30, 75, 18, 4, 42, 51, 59, 8, 77}));

        List<Integer> A = List.of(56, 6, 52, 43, 23, 47, 48, 38, 96, 46, 30, 66, 80, 15, 62, 71, 61, 12, 98, 9, 28, 81, 70, 59, 95, 34, 9, 60, 70, 81, 71, 67, 58, 20, 22, 3, 95, 85, 20, 24, 74, 5, 23, 33, 75, 50, 38, 75, 68, 26, 46, 30, 75, 18, 4, 42, 51, 59, 8, 77);
        System.out.println(trap(A));

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
        System.out.println(Arrays.toString(leftMax));
        System.out.println(Arrays.toString(rightMax));

        for (int i = 0; i < size; i++) {
            int currentAns = Math.min(leftMax[i], rightMax[i]) - A[i];
            if (currentAns > 0) trappedWater += currentAns;
        }
        return trappedWater;
    }

    public static int trap(final List<Integer> A) {
        int size = A.size();
        int[] leftMax = new int[size];
        int[] rightMax = new int[size];
        leftMax[0] = 0;
        rightMax[size - 1] = 0;
        for (int i = 1; i < size; i++) {
            leftMax[i] = Math.max(A.get(i - 1), leftMax[i - 1]);
        }

        for (int i = size - 2; i >= 0; i--) {
            rightMax[i] = Math.max(A.get(i + 1), rightMax[i + 1]);
        }
        System.out.println(Arrays.toString(leftMax));
        System.out.println(Arrays.toString(rightMax));
        int trapCount = 0;
        for (int i = 1; i < size - 1; i++) {
            int boundary = Math.min(leftMax[i], rightMax[i]);
            trapCount += (A.get(i) > boundary ? 0 : boundary - A.get(i));
        }
        return trapCount;
    }

    public static int trapScaler(final int[] A) {
        int n = A.length, left = 0, right = n - 1, res = 0, maxleft = 0, maxright = 0;
        while (left <= right) {
            if (A[left] <= A[right]) {
                if (A[left] >= maxleft)
                    maxleft = A[left];
                else
                    res += maxleft - A[left];
                left++;
            } else {
                if (A[right] >= maxright)
                    maxright = A[right];
                else
                    res += maxright - A[right];
                right--;
            }
        }
        return res;
    }
}
