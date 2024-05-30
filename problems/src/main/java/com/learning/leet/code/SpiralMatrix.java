package com.learning.leet.code;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int i = 0, j = 0, m = matrix.length, n = matrix[0].length, count = matrix.length * matrix[0].length;
        List<Integer> result = new ArrayList<>();
        if (m * n == 1) {
            result.add(matrix[0][0]);
            return result;
        }
        while (count > 0) {
            // L to R
            for (int index = 1; index < n && count > 0; index++) {
                result.add(matrix[i][j++]);
                count--;
            }

            // T to B
            for (int index = 1; index < m && count > 0; index++) {
                result.add(matrix[i++][j]);
                count--;
            }

            // R to L
            for (int index = 1; index < n && count > 0; index++) {
                result.add(matrix[i][j--]);
                count--;
            }

            // B to T
            for (int index = 1; index < m && count > 0; index++) {
                result.add(matrix[i--][j]);
                count--;
            }
            i += 1;
            j += 1;
            n -= 1;
            m -= 1;
        }
        return result;
    }
}
