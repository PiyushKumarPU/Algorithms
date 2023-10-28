package com.learning.scaler.primer;

/**
 * Given a 2D integer array A of size N * N representing a triangle of numbers.
 * <p>
 * Find the maximum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * <p>
 * NOTE:
 * <p>
 * Adjacent cells to cell (i,j) are only (i+1,j) and (i+1,j+1)
 * Row i contains i integer and n-i zeroes for all i in [1,n] where zeroes represents empty cells.
 * <p>
 * Problem Constraints
 * <p>
 * 0 <= N <= 1000
 * <p>
 * 0 <= A[i][j] <= 1000
 * <p>
 * Input 1:
 * <p>
 * A = [
 * [3, 0, 0, 0]
 * [7, 4, 0, 0]
 * [2, 4, 6, 0]
 * [8, 5, 9, 3]
 * ]
 * <p>
 * Output 1:
 * <p>
 * 23
 * <p>
 * Given triangle looks like:
 * 3
 * 7 4
 * 2 4 6
 * 8 5 9 3
 * So max path is (3 + 7 + 4 + 9) = 23
 */
public class MaxPathInTriangle {

    public static void main(String[] args) {
        System.out.println(solve(new int[][]{
                {3, 0, 0, 0},
                {7, 4, 0, 0},
                {2, 4, 6, 0},
                {8, 5, 9, 3}
        }));

        System.out.println(solve(new int[][]{
                {8, 0, 0, 0},
                {4, 4, 0, 0},
                {2, 2, 6, 0},
                {1, 1, 1, 1}
        }));
    }

    public static int solve(int[][] A) {
        for (int i = A.length - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                A[i][j] = A[i][j] + Math.max(A[i + 1][j], A[i + 1][j + 1]);
            }
        }
        return A[0][0];
    }

}
