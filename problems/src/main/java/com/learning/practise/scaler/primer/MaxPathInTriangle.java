package com.learning.practise.scaler.primer;

import java.util.Arrays;

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
