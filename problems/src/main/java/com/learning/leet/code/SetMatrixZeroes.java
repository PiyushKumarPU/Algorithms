package com.learning.leet.code;

import java.util.Arrays;

public class SetMatrixZeroes {


    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        SetMatrixZeroes zeroes = new SetMatrixZeroes();
        for (int[] arr : matrix) System.out.println(Arrays.toString(arr));
        System.out.println("\n");
        zeroes.setZeroes(matrix);
        for (int[] arr : matrix) System.out.println(Arrays.toString(arr));
    }

    public void setZeroes(int[][] matrix) {
        boolean firstRowZero = false, firstColZero = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) firstRowZero = true;
                    if (j == 0) firstColZero = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (firstRowZero) {
            Arrays.fill(matrix[0], 0);
        }
        if (firstColZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

    }

}
