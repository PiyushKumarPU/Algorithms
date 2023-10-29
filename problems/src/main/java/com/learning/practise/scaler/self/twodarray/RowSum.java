package com.learning.practise.scaler.self.twodarray;

import java.util.Arrays;

public class RowSum {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(solve(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 2, 3, 4}
        })));

    }

    public static int[] solve(int[][] A) {
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                result[i] += A[i][j];
            }
        }
        return result;
    }
}
