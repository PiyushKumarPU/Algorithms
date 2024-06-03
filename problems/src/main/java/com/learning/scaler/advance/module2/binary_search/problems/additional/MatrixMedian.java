package com.learning.scaler.advance.module2.binary_search.problems.additional;

/*
Problem Description
    Given a matrix of integers A of size N x M in which each row is sorted.
    Find and return the overall median of matrix A.
    NOTE: No extra memory is allowed.
    NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.



Problem Constraints
    1 <= N, M <= 10^5
    1 <= N*M <= 10^6
    1 <= A[i] <= 10^9
    N*M is odd

Input Format
    The first and only argument given is the integer matrix A.

Output Format
    Return the overall median of matrix A.

Example Input
    Input 1:
    A = [   [1, 3, 5],
            [2, 6, 9],
            [3, 6, 9]   ]
    Input 2:
        A = [   [5, 17, 100]]

Example Output
    Output 1:
        5
    Output 2:
        17

Example Explanation
    Explanation 1:
        A = [1, 2, 3, 3, 5, 6, 6, 9, 9]
        Median is 5. So, we return 5.
    Explanation 2:
        Median is 17.
* */
public class MatrixMedian {

    public static void main(String[] args) {

        int[][] A = {{1, 3, 6}, {2, 6, 9}, {3, 6, 9}};
        System.out.println(findMedian(A));
    }

    public static int findMedian(int[][] A) {
        int N = A.length, M = A[0].length, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        // Find the minimum and maximum elements in the matrix
        for (int[] ints : A) {
            min = Math.min(min, ints[0]);
            max = Math.max(max, ints[M - 1]);
        }

        int desiredCount = (N * M) / 2;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            int count = 0;
            // Count how many numbers are less than or equal to mid
            for (int[] ints : A) {
                count += countLessOrEqual(ints, mid);
            }

            if (count <= desiredCount) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        return min;
    }

    private static int countLessOrEqual(int[] row, int x) {
        if (x < row[0] && x > row[row.length - 1]) return 0;
        int low = 0;
        int high = row.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (row[mid] <= x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
