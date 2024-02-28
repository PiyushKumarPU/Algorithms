package com.learning.scaler.advance.module1.array2d.lecture;


/*
Problem Description:
    Given a matrix of N rows and M column. Determine sum of all possible sub matrix.
* */

public class SumOfAllSubMatrixSum {

    public int sumOfAllSubmatrix(int[][] A) {
        int result = 0, N = A.length, M = A[0].length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // contribution of i,j cell is
                int topLeftCount = (i + 1) * (j + 1);
                int bottomRightCount = (N - i) * (M - j);
                int contribution = A[i][j] * topLeftCount * bottomRightCount;
                result += contribution;
            }
        }
        return result;
    }

}
