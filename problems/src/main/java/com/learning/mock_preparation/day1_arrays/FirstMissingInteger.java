package com.learning.mock_preparation.day1_arrays;

/*
Problem Description
    Given an unsorted integer array, A of size N. Find the first missing positive integer.
    Note: Your algorithm should run in O(n) time and use constant space.

Problem Constraints
    1 <= N <= 1000000
    -10^9 <= A[i] <= 10^9

Input Format
    First argument is an integer array A.

Output Format
     Returns an integer denoting the first missing positive integer.

Example
    Input 1:
        [1, 2, 0]
    Input 2:
        [3, 4, -1, 1]
    Input 3:
        [-8, -7, -6]

Example
    Output 1:
        3
    Output 2:
        2
    Output 3:
        1

Example
    Explanation 1:
        A = [1, 2, 0]
        First positive integer missing from the array is 3.
    Explanation 2:
        A = [3, 4, -1, 1]
        First positive integer missing from the array is 2.
    Explanation 3:
        A = [-8, -7, -6]
        First positive integer missing from the array is 1.
* */
public class FirstMissingInteger {

    public static void main(String[] args) {
        int[] input = new int[]{3, 4, -1, 1};
        System.out.println(firstMissingPositive(input));
    }


    public static int firstMissingPositive(int[] A) {
        int size = A.length;
        for (int i = 0; i < size; i++) {
            while (A[i] >= 1 && A[i] <= size
                    && A[i] != A[A[i] - 1]) {
                int temp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = temp;
            }
        }
        for (int i = 0; i < size; i++)
            if (A[i] != i + 1)
                return (i + 1);
        return (size + 1);
    }
}
