package com.learning.practise.scaler.self.twodarray;

import java.util.Arrays;

public class TransposeMatrix {

    public static void main(String[] args) {
        int[][] input = new int[][]{{1, 2}, {3, 4}};
        int[][] input2 = new int[][]{{1, 2}, {1, 2}, {1, 2}};

        System.out.println(Arrays.toString(solve(input)));

    }

    public static int[][] solve(int[][] A) {
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < A.length - 1; j++) {
                int temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
            }
        }
        return A;
    }
}