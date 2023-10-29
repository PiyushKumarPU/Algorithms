package com.learning.practise.scaler.self.twodarray;

public class MinorDiagonal {

    public static void main(String[] args) {
        System.out.println(solve(new int[][]{
                {3, 2},
                {2, 3}
        }));
    }

    public static int solve(final int[][] A) {
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (i + j + 2 == A.length + 1) result += A[i][j];
            }
        }
        return result;
    }
}
