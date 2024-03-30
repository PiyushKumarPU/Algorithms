package com.learning.scaler.advance.module2.sort.merge.assignment;


import java.lang.reflect.Array;
import java.util.Arrays;

/*
Problem Description
    You are given an array A of N elements. You have to make all elements unique. To do so,
    in one step you can increase any number by one.
    Find the minimum number of steps.


Problem Constraints
    1 <= N <= 10^5
    1 <= A[i] <= 10^9

Input Format
    The only argument given is an Array A, having N integers.

Output Format
    Return the minimum number of steps required to make all elements unique.

Example
    Input 1:
         A = [1, 1, 3]
    Input 2:
         A = [2, 4, 5]

Example
    Output 1:
         1
    Output 2:
         0

Example
    Explanation 1:
         We can increase the value of 1st element by 1 in 1 step and will get all unique elements. i.e [2, 1, 3].
    Explanation 2:
         All elements are distinct.
* */
public class UniqueElements {

    public static void main(String[] args) {
        int[] arr = {51,
                6, 10, 8, 22, 61, 56, 48, 88, 85, 21, 98, 81, 76, 71, 68, 18, 6, 14, 23, 72, 18, 56, 30, 97, 100, 81, 5, 99, 2, 85, 67, 46, 32, 66, 51, 76, 53, 36, 31, 81, 56, 26, 75, 69, 54, 54, 54, 83, 41, 86, 48, 7, 32, 85, 23, 47, 23, 18, 45, 79, 95, 73, 15, 55, 16, 66, 73, 13, 85, 14, 80, 39, 92, 66, 20, 22, 25, 34, 14, 51, 14, 17, 10, 100, 35, 9, 83, 31, 60, 24, 37, 69, 62};

        System.out.println(new UniqueElements().solve(arr));
    }

    public int solve(int[] A) {
        // as per the constraint element should start from 1 and it will be till n
        Arrays.sort(A);
        int steps = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= A[i - 1]) {
                steps += A[i - 1] - A[i] + 1;
                A[i] = A[i - 1] + 1;
            }
        }
        return steps;
    }

    public int solveScaler(int[] A) {
        int n = A.length;
        // sort the array
        Arrays.sort(A);
        // initialize variables
        int steps = 0, i = 1, j = 0;
        // loop unitil you reach the end
        while (j < n) {
            // make current element unique
            if (i >= A[j]) {
                steps += (i - A[j++]);
                i += 1;
            } else {
                i = A[j] + 1;
                j += 1;
            }
        }
        // return the answer
        return steps;
    }
}
