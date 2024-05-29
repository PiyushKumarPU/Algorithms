package com.learning.scaler.advance.module2.binary_search.arrays.additional;

import java.util.ArrayList;
import java.util.List;

/*
Problem Description
Given a matrix of integers A of size N x M and an integer B. Write an efficient algorithm that searches for integer B in matrix A.

This matrix A has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than or equal to the last integer of the previous row.
Return 1 if B is present in A, else return 0.

NOTE: Rows are numbered from top to bottom, and columns are from left to right.



Problem Constraints
1 <= N, M <= 1000
1 <= A[i][j], B <= 106



Input Format
The first argument given is the integer matrix A.
The second argument given is the integer B.



Output Format
Return 1 if B is present in A else, return 0.



Example Input
Input 1:

A = [
      [1,   3,  5,  7]
      [10, 11, 16, 20]
      [23, 30, 34, 50]
    ]
B = 3
Input 2:

A = [
      [5, 17, 100, 111]
      [119, 120, 127, 131]
    ]
B = 3


Example Output
Output 1:

1
Output 2:

0


Example Explanation
Explanation 1:

 3 is present in the matrix at A[0][1] position so return 1.
Explanation 2:

 3 is not present in the matrix so return 0.
* */
public class MatrixSearch {

    public static void main(String[] args) {

        /*System.out.println(searchMatrix(new ArrayList<>(List.of(
                new ArrayList<>(List.of(1, 3, 5, 7)),
                new ArrayList<>(List.of(10, 11, 16, 20)),
                new ArrayList<>(List.of(23, 30, 34, 50))
        )), 3));
        System.out.println(searchMatrix(new ArrayList<>(List.of(
                new ArrayList<>(List.of(5, 17, 100, 111)),
                new ArrayList<>(List.of(119, 120, 127, 131))
        )), 3));

        System.out.println(searchMatrix(new ArrayList<>(List.of(
                new ArrayList<>(List.of(5, 17)),
                new ArrayList<>(List.of(119, 120))
        )), 120));*/


        System.out.println(searchMatrix(new ArrayList<>(List.of(
                new ArrayList<>(List.of(3)),
                new ArrayList<>(List.of(29)),
                new ArrayList<>(List.of(36)),
                new ArrayList<>(List.of(63)),
                new ArrayList<>(List.of(67)),
                new ArrayList<>(List.of(72)),
                new ArrayList<>(List.of(74)),
                new ArrayList<>(List.of(78)),
                new ArrayList<>(List.of(85))

        )), 41));

    }

    public static int searchMatrix(ArrayList<ArrayList<Integer>> A, int B) {
        int N = A.size(), M = A.get(0).size(), start = 0, end = N * M - 1;
        if (B < A.get(0).get(0) || B > A.get(N - 1).get(M - 1)) return 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int i = mid / M, j = mid % M;
            int current = A.get(i).get(j);
            if (current == B) return 1;
            else if (current > B) {
                end = mid - 1;
            } else start = mid + 1;
        }
        return 0;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int N = matrix.length, M = matrix[0].length, start = 0, end = N * M - 1;
        if (target < matrix[0][0] || target > matrix[N - 1][M - 1]) return false;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int i = mid / M, j = mid % M;
            int current = matrix[i][j];
            if (current == target) return true;
            else if (current > target) {
                end = mid - 1;
            } else start = mid + 1;
        }
        return false;
    }
}
