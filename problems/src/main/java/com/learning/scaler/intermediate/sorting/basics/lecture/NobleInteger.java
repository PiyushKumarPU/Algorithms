package com.learning.scaler.intermediate.sorting.basics.lecture;


import java.util.Arrays;

/*
Problem Description
    Given an integer array A, find if an integer p exists in the array such that the number of
    integers greater than p in the array equals p.

Problem Constraints
    1 <= |A| <= 2*10^5
    -10^8 <= A[i] <= 10^8

Input Format
    First and only argument is an integer array A.

Output Format
    Return 1 if any such integer p is present else, return -1.

Example Input
    Input 1:
         A = [3, 2, 1, 3]
    Input 2:
         A = [1, 1, 3, 3]

Example Output
    Output 1:
         1
    Output 2:
         -1

Example Explanation
    Explanation 1:
         For integer 2, there are 2 greater elements in the array.
    Explanation 2:
         There exist no integer satisfying the required conditions.
* */
public class NobleInteger {

    public static void main(String[] args) {
        int[] arr = {-4,7,5,3,5,-4,2,-1,-9,-8,-3,0,9,-7,-4,-10,-4,2,6,1,-2,-3,-1,-8,0,-8,-7,-3,5,-1,-8,-8,8,-1,-3,3,6,1,-8,-1,3,-9,9,-6,7,8,-6,5,0,3,-4,1,-10,6,3,-8,0,6,-9,-5,-5,-6,-3,6,-5,-4,-1,3,7,-6,5,-8,-5,4,-3,4,-6,-7,0,-3,-2,6,8,-2,-6,-7,1,4,9,2,-10,6,-2,9,2,-4,-4,4,9,5,0,4,8,-3,-9,7,-8,7,2,2,6,-9,-10,-4,-9,-5,-1,-6,9,-10,-1,1,7,7,1,-9,5,-1,-3,-3,6,7,3,-4,-5,-4,-7,9,-6,-2,1,2,-1,-7,9,0,-2,-2,5,-10,-1,6,-7,8,-5,-4,1,-9,5,9,-2,-6,-2,-9,0,3,-10,4,-6,-6,4,-3,6,-7,1,-3,-5,9,6,2,1,7,-2,5};

    System.out.println(solve(arr));
    }

    public static int solve(int[] A) {
        Arrays.sort(A);
        reverse(A);
        int nobleCount = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == i) nobleCount++;
        }
        return nobleCount;
    }

    private static void reverse(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            start++;
            end--;
        }
    }
}
