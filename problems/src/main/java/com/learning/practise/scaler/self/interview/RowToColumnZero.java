package com.learning.practise.scaler.self.interview;

import java.util.Arrays;
import java.util.HashSet;

public class RowToColumnZero {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solve(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 0},
                {9, 2, 0, 4}
        })));
    }

    public static int[][] solve(int[][] A) {
        HashSet<Integer> rowSet = new HashSet<>();
        HashSet<Integer> colSet = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        for (int i = 0; i < A.length; i++) {
            boolean isZeroRow = rowSet.contains(i);
            for (int j = 0; j < A[0].length; j++) {
                if (isZeroRow || colSet.contains(j)) A[i][j] = 0;
            }
        }
        return A;
    }

    public static int[][] solveNoSpace(int[][] A) {
        HashSet<Integer> rowSet = new HashSet<>();
        HashSet<Integer> colSet = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        for (int i = 0; i < A.length; i++) {
            boolean isZeroRow = rowSet.contains(i);
            for (int j = 0; j < A[0].length; j++) {
                if (isZeroRow || colSet.contains(j)) A[i][j] = 0;
            }
        }
        return A;
    }
}
