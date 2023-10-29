package com.learning.practise.scaler.self.twodarray;

import java.util.Arrays;

public class RotateMatrix {

    public static void main(String[] args) {
        solve(new int[][]
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                });
    }

    public static void solve(int[][] A) {
        int N = A.length;
        for (int i = 0; i < N / 2; i++) {
            for (int j = i; j < N - i - 1; j++) {
                int temp = A[i][j];
                A[i][j] = A[N - 1 - j][i];
                A[N - 1 - j][i] = A[N - 1 - i][N - 1 - j];
                A[N - 1 - i][N - 1 - j] = A[j][N - 1 - i];
                A[j][N - 1 - i] = temp;
            }
        }
        System.out.println(Arrays.deepToString(A));
    }
}
