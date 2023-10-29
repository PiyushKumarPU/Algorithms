package com.learning.practise.scaler.self.twodarray;

import java.util.Arrays;

public class ScalerMultiplication {

    public static void main(String[] args) {
        int[][] result = solve(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }, 2);
        System.out.println(Arrays.toString(result));
    }

    public static int[][] solve(int[][] A, int B) {
        for(int i =0; i< A.length; i++){
            for(int j = 0; j < A[0].length; j++){
                A[i][j] *= B;
            }
        }
        return A;
    }
}
