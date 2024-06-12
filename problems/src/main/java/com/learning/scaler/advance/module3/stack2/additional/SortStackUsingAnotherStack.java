package com.learning.scaler.advance.module3.stack2.additional;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
Problem Description
    Given a stack of integers A, sort it using another stack.
    Return the array of integers after sorting the stack using another stack.

Problem Constraints
    1 <= |A| <= 5000
    0 <= A[i] <= 10^9

Input Format
    The only argument is a stack given as an integer array A.

Output Format
    Return the array of integers after sorting the stack using another stack.

Example
    Input 1:
         A = [5, 4, 3, 2, 1]
    Input 2:
         A = [5, 17, 100, 11]

Example
    Output 1:
         [1, 2, 3, 4, 5]
    Output 2:
         [5, 11, 17, 100]

Example
    Explanation 1:
         Just sort the given numbers.
    Explanation 2:
         Just sort the given numbers.
* */
public class SortStackUsingAnotherStack {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(new int[]{5, 4, 3, 2, 1})));
    }
    public static int[] solve(int[] A) {
        Stack<Integer> sorted = new Stack<>();
        for (int ele : A) {
            if (sorted.isEmpty()) sorted.push(ele);
            else {
                List<Integer> popped = new ArrayList<>();
                while (!sorted.isEmpty() && sorted.peek() < ele) popped.add(sorted.pop());
                sorted.push(ele);
                for (int i = popped.size() - 1; i >= 0; i--) sorted.push(popped.get(i));
            }
        }
        int[] result = new int[A.length];
        int index = 0;
        while (!sorted.isEmpty()) result[index++] = sorted.pop();
        return result;
    }
}
