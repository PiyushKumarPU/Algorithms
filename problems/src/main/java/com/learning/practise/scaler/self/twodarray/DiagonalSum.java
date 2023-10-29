package com.learning.practise.scaler.self.twodarray;

public class DiagonalSum {

    public static void main(String[] args) {

    }

    public static int solve(final int[][] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i][i];
        }
        return sum;
    }
}
