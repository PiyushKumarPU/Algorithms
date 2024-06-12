package com.learning.scaler.advance.module3.stack2.additional;

import java.util.Arrays;
import java.util.Stack;

/*
Problem Description
    Given a 2-D binary matrix A of size N x M filled with 0's and 1's, find the largest rectangle containing
    only ones and return its area.

Problem Constraints
    1 <= N, M <= 100

Input Format
    The first argument is a 2-D binary array A.

Output Format
    Return an integer denoting the area of the largest rectangle containing only ones.

Example
    Input 1:
         A = [
               [1, 1, 1]
               [0, 1, 1]
               [1, 0, 0]
             ]
    Input 2:
         A = [
               [0, 1, 0]
               [1, 1, 1]
             ]

Example
    Output 1:
         4
    Output 2:
         3

Example
    Explanation 1:
         As the max area rectangle is created by the 2x2 rectangle created by (0, 1), (0, 2), (1, 1) and (1, 2).
    Explanation 2:
         As the max area rectangle is created by the 1x3 rectangle created by (1, 0), (1, 1) and (1, 2).
* */
public class MaxRectangleInBinaryMatrix {

    public static void main(String[] args) {
        System.out.println(maximalRectangle(new int[][]{{}}));
        System.out.println(maximalRectangleUsingDp(new int[][]{{}}));
    }

    // using the largest rectangle of histogram,
    /*
    The approach used in this solution, similar to the previous explanation, is based on the concept of calculating the largest rectangle within a histogram. Here's a breakdown of the approach:

    1. Height Calculation:
       - For each row of the input matrix `A`, we maintain an array `heights` which represents the heights of the histogram bars. Each element `heights[i]` corresponds to the height of the histogram bar at column `i`.
       - When iterating through each row of `A`, if the value is `1`, we increment the corresponding element in `heights` by 1. If the value is `0`, we reset the height to `0`.

    2. Largest Rectangle in Histogram:
       - We use the `largestRectangleArea` method to find the largest rectangle area within the histogram represented by the `heights` array. This method is responsible for calculating the largest rectangle area given the heights of histogram bars.
       - It uses a stack-based approach to efficiently find the maximum area. The stack keeps track of indices of histogram bars in non-decreasing order of their heights.

    3. Iterating through Rows:
       - For each row in the input matrix `A`, we update the `heights` array according to the heights of the bars in that row.
       - After updating the `heights` array, we calculate the largest rectangle area within the histogram represented by the updated `heights`.

    4. Maximal Rectangle:
       - During the iteration through the rows, we continuously update the `maxArea` variable with the maximum rectangle area encountered so far.

    5. Final Result:
       - After processing all rows, the `maxArea` variable holds the maximum area of the rectangle contained within the input matrix. We return this value as the output.
    * */
    public static int maximalRectangle(int[][] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int maxArea = 0;
        int[] heights = new int[A[0].length];
        for (int[] row : A) {
            for (int i = 0; i < row.length; i++) {
                heights[i] = row[i] == 1 ? heights[i] + 1 : 0;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }

    private static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;
        int n = heights.length;
        int[] extendedHeights = new int[n + 1];
        System.arraycopy(heights, 0, extendedHeights, 0, n);
        extendedHeights[n] = 0;

        for (int i = 0; i < extendedHeights.length; i++) {
            while (stack.peek() != -1 && extendedHeights[i] < extendedHeights[stack.peek()]) {
                int h = extendedHeights[stack.pop()];
                int w = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, h * w);
            }
            stack.push(i);
        }
        return maxArea;
    }

    // Using dynamic Programming
    /*
    1. Height Calculation:
       - For each row of the input matrix, we maintain an array `heights` which stores the height of the rectangle ending at each column.
       - When encountering a `1` in the input matrix, we increment the corresponding height in the `heights` array by 1. If it's `0`, we reset the height to `0`.

    2. Left Boundary Calculation:
       - For each position `(i, j)` in the input matrix, we calculate the left boundary of the rectangle. The left boundary represents the leftmost index of the rectangle that includes the current position `(i, j)`.
       - We initialize a variable `currLeft` to keep track of the left boundary while traversing the row. Whenever we encounter a `1` in the row, we update the left boundary of that position to `Math.max(left[j], currLeft)`, ensuring it includes the current position.

    3. Right Boundary Calculation:
       - Similar to the left boundary calculation, we calculate the right boundary for each position in the row. The right boundary represents the rightmost index of the rectangle that includes the current position `(i, j)`.
       - We initialize a variable `currRight` to keep track of the right boundary while traversing the row in reverse order. Whenever we encounter a `1` in the row, we update the right boundary of that position to `Math.min(right[j], currRight)`, ensuring it includes the current position.

    4. Area Calculation:
       - Once we have the heights, left boundaries, and right boundaries for each position in the row, we calculate the area of the rectangle ending at each position.
       - The area is calculated as `(right[j] - left[j]) * heights[j]`. This gives the width of the rectangle (difference between right and left boundaries) multiplied by its height.

    5. Max Area Update:
       - We update the `maxArea` variable with the maximum area encountered so far during the iteration over the rows of the input matrix.

    6. Final Result:
       - After processing all rows, the `maxArea` variable holds the maximum area of the rectangle contained within the input matrix. We return this value as the output.

    This approach effectively finds the maximal rectangle within the given matrix by maintaining and updating the necessary information for each position in the matrix.
    * */
    public static int maximalRectangleUsingDp(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }

        int maxArea = 0, n = A[0].length;
        // Initialize arrays to store heights and left and right boundaries for each position
        int[] heights = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];

        // Initialize right boundary array with the rightmost index for each position
        Arrays.fill(right, n);

        for (int[] row : A) {
            // Calculate heights and left boundaries for each position
            int currLeft = 0;
            for (int j = 0; j < n; j++) {
                if (row[j] == 1) {
                    heights[j]++;
                    left[j] = Math.max(left[j], currLeft);
                } else {
                    heights[j] = 0;
                    left[j] = 0;
                    currLeft = j + 1;
                }
            }

            // Calculate right boundaries for each position
            int currRight = n;
            for (int j = n - 1; j >= 0; j--) {
                if (row[j] == 1) {
                    right[j] = Math.min(right[j], currRight);
                } else {
                    right[j] = n;
                    currRight = j;
                }
            }

            // Update max area using dynamic programming approach
            for (int j = 0; j < n; j++) {
                maxArea = Math.max(maxArea, (right[j] - left[j]) * heights[j]);
            }
        }
        return maxArea;
    }

}
