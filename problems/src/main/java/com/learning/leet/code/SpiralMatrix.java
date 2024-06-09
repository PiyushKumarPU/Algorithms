package com.learning.leet.code;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        System.out.println(List.of(1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10));
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int count = m * n;
        List<Integer> result = new ArrayList<>();

        if (n == 0) {
            return result;
        }

        int i = 0, j = 0;

        while (count > 0) {
            // Traverse from Left to Right
            for (int index = 0; index < n && count > 0; index++) {
                result.add(matrix[i][j++]);
                count--;
            }
            i++;
            j--;
            m--;

            // Traverse from Top to Bottom
            for (int index = 0; index < m && count > 0; index++) {
                result.add(matrix[i++][j]);
                count--;
            }
            i--;
            j--;
            n--;

            // Traverse from Right to Left
            for (int index = 0; index < n && count > 0; index++) {
                result.add(matrix[i][j--]);
                count--;
            }
            i--;
            j++;
            m--;

            // Traverse from Bottom to Top
            for (int index = 0; index < m && count > 0; index++) {
                result.add(matrix[i--][j]);
                count--;
            }
            i++;
            j++;
            n--;
        }
        return result;
    }
}
