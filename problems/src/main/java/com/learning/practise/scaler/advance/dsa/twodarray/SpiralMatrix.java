package com.learning.practise.scaler.advance.dsa.twodarray;

import java.util.Arrays;

public class SpiralMatrix {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(1)));
        System.out.println(Arrays.deepToString(generateMatrix(2)));
        System.out.println(Arrays.deepToString(generateMatrix(3)));
        System.out.println(Arrays.deepToString(generateMatrix(5)));

    }

    public static int[][] generateMatrix(int A) {
        int[][] result = new int[A][A];
        int startVal = 1, i = 0, j = 0;
        while (A > 1) {
            // L to R
            for (int index = 1; index < A; index++) {
                result[i][j] = startVal++;
                j++;
            }

            // T to B
            for (int index = 1; index < A; index++) {
                result[i][j] = startVal++;
                i++;
            }

            // R to L
            for (int index = 1; index < A; index++) {
                result[i][j] = startVal++;
                j--;
            }

            // B to T
            for (int index = 1; index < A; index++) {
                result[i][j] = startVal++;
                i--;
            }
            A -= 2;
            i += 1;
            j += 1;
        }
        if (A == 1) result[i][j] = startVal;
        return result;
    }
}
