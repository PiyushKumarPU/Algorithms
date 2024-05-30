package com.learning.scaler.advance.module3.stack2.assignment;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Problem Description
    Given an array of integers A.
    A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.
    Find the area of the largest rectangle formed by the histogram.

Problem Constraints
    1 <= |A| <= 100000
    1 <= A[i] <= 10000

Input Format
    The only argument given is the integer array A.

Output Format
     Returns the area of the largest rectangle in the histogram.

Example
    Input 1:
         A = [2, 1, 5, 6, 2, 3]
    Input 2:
         A = [2]

Example
    Output 1:
         10
    Output 2:
         2

Example
    Explanation 1:
        The largest rectangle has area = 10 unit. Formed by A[3] to A[4].
    Explanation 2:
        Largest rectangle has area 2.
* */
public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new ArrayList<>(List.of(90, 58, 69, 70, 82, 100, 13, 57, 47, 18))));
    }

    public static int largestRectangleArea(ArrayList<Integer> A) {
        if (A == null || A.isEmpty()) return 0;
        int[] leftSmaller = new int[A.size()];
        int[] rightSmaller = new int[A.size()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.size(); i++) {
            while (!stack.isEmpty() && A.get(stack.peek()) >= A.get(i)) stack.pop();
            leftSmaller[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = A.size() - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A.get(stack.peek()) >= A.get(i)) stack.pop();
            rightSmaller[i] = stack.isEmpty() ? A.size() : stack.peek();
            stack.push(i);
        }
        // if left stack is -1 it means current index is left boundary
        // if right stack is -1 it means current index is right boundary
        int maxArea = 0;
        for (int i = 0; i < A.size(); i++) {
            // find the current area
            maxArea = Math.max(maxArea, ((rightSmaller[i] - leftSmaller[i] - 1) * A.get(i)));
        }
        return maxArea;
    }

    public int largestRectangleArea(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int index = 0;

        while (index < A.length) {
            if (stack.isEmpty() || A[index] >= A[stack.peek()]) {
                stack.push(index);
                index++;
            } else {
                int topOfStack = stack.pop();
                int area = A[topOfStack] * ((stack.isEmpty() ? index : index - stack.peek() - 1));
                maxArea = Math.max(maxArea, area);
            }
        }

        while (!stack.isEmpty()) {
            int topOfStack = stack.pop();
            int area = A[topOfStack] * ((stack.isEmpty() ? index : index - stack.peek() - 1));
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

}
