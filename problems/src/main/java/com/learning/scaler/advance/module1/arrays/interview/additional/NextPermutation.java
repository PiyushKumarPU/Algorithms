package com.learning.scaler.advance.module1.arrays.interview.additional;

import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description
    Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers for a given array A of size N.
    If such arrangement is not possible, it must be rearranged as the lowest possible order, i.e., sorted in ascending order.

NOTE:
    The replacement must be in-place, do not allocate extra memory.
    DO NOT USE LIBRARY FUNCTION FOR NEXT PERMUTATION. Use of Library functions will disqualify your submission retroactively and will give you penalty points.

Problem Constraints
    1 <= N <= 5 * 10^5
    1 <= A[i] <= 10^9

Input Format
    The first and the only argument of input has an array of integers, A.

Output Format
    Return an array of integers, representing the next permutation of the given array.

Example Input
    Input 1:
        A = [1, 2, 3]
    Input 2:
        A = [3, 2, 1]

Example Output
    Output 1:
        [1, 3, 2]
    Output 2:
        [1, 2, 3]

Example Explanation
    Explanation 1:
        Next permutation of [1, 2, 3] will be [1, 3, 2].
    Explanation 2:
        No arrangement is possible such that the number are arranged into the numerically next greater permutation of numbers.
        So will rearranges it in the lowest possible order.
* */
public class NextPermutation {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextPermutation(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(nextPermutation(new int[]{3, 2, 1})));
    }


    // approach 1
    public static int[] nextPermutation(int[] A) {
        int size = A.length, i, j;
        for (i = size - 2; i >= 0; i--) {
            if (A[i] < A[i + 1]) {
                break;
            }
        }

        if (i < 0) {
            reverse(A, 0, A.length - 1);
        } else {
            for (j = size - 1; j > i; j--) {
                if (A[j] > A[i]) {
                    break;
                }
            }
            swap(A, i, j);
            reverse(A, i + 1, A.length - 1);
        }
        return A;
    }

    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
