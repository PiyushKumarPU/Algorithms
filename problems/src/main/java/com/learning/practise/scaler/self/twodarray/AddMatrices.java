package com.learning.practise.scaler.self.twodarray;

public class AddMatrices {

    public static void main(String[] args) {

    }

    public int[][] solve(int[][] A, int[][] B) {
        for(int i =0; i < A.length; i++){
            for(int j = 0; j < A[0].length; j++){
                A[i][j] += B[i][j];
            }
        }
        return A;

    }
}
