package com.learning.practise.scaler.self.twodarray;

import java.util.Arrays;

public class ColumnSum {

    public static void main(String[] args) {
        int[][] inputs = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 2, 3, 4}
        };
        System.out.println(Arrays.toString(solve(inputs)));
    }


    public static int[] solve(int[][] A) {
        int[] result = new int[A[0].length];
        for (int i = 0; i < A[0].length; i++) {
            result[i] = A[0][i];
            for (int j = 1; j < A.length; j++) {
                result[i] += A[j][i];
            }
        }
        return result;
    }
}
