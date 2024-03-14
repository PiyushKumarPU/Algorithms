package com.learning.mock_preparation.day4_searching;


/*
Problem Description
    Given a sorted array of integers A of size N and an integer B,
    where array A is rotated at some pivot unknown beforehand.
    For example, the array [0, 1, 2, 4, 5, 6, 7] might become [4, 5, 6, 7, 0, 1, 2].
    Your task is to search for the target value B in the array. If found, return its index; otherwise, return -1.
    You can assume that no duplicates exist in the array.
    NOTE: You are expected to solve this problem with a time complexity of O(log(N)).


Problem Constraints
    1 <= N <= 1000000
    1 <= A[i] <= 10^9
    All elements in A are Distinct.

Input Format
    The First argument given is the integer array A.
    The Second argument given is the integer B.

Output Format
    Return index of B in array A, otherwise return -1

Example
Input 1:
    A = [4, 5, 6, 7, 0, 1, 2, 3]
    B = 4
Input 2:
    A : [ 9, 10, 3, 5, 6, 8 ]
    B : 5

Example Output
    Output 1:
         0
    Output 2:
         3

Example Explanation
    Explanation 1:
        Target 4 is found at index 0 in A.
    Explanation 2:
        Target 5 is found at index 3 in A.
* */
public class RotatedSortedArraySearch {

    public static void main(String[] args) {
        int[] A = new int[]{101, 103, 106, 109, 158, 164, 182, 187, 202, 205, 2, 3, 32, 57, 69, 74, 81, 99, 100};
        int B = 202;
        int result = search(A, B);
        assert result == 8;
    }


    // https://www.scaler.com/academy/mentee-dashboard/class/126667/assignment/problems/203?navref=cl_tt_lst_nm
    public static int search(final int[] A, int B) {
        int start = 0, end = A.length - 1;
        while (start <= end) {
            int midIndex = start + (end - start) / 2;
            int midValue = A[midIndex];
            if (B == midValue) return midIndex;
            int firstValue = A[0];
            if (midValue > firstValue) {
                if (B >= firstValue) {
                    if (B > midValue) {
                        start = midIndex + 1;
                    } else end = midIndex - 1;
                } else {
                    start = midIndex + 1;
                }
            } else {
                if (B < firstValue) {
                    if (B > midValue) {
                        start = midIndex + 1;
                    } else end = midIndex - 1;
                } else {
                    end = midIndex - 1;
                }
            }
        }
        return -1;
    }
}
