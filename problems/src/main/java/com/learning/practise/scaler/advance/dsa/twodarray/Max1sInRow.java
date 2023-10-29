package com.learning.practise.scaler.advance.dsa.twodarray;

public class Max1sInRow {

    public static void main(String[] args) {
        System.out.println(solve(new int[][]{
                {0, 1, 1},
                {0, 0, 1},
                {0, 1, 1}
        }));

        System.out.println(solve(new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 1},
                {0, 0, 1, 1},
                {0, 1, 1, 1}
        }));

        System.out.println(solve(new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        }));
    }

    public static int solve(int[][] A) {
        int index = -1;
        int i = 0, j = A.length - 1;
        while (i < A.length && j >= 0) {
            if (A[i][j] == 1) {
                index = i;
                j--;
            } else i++;
        }
        return index;
    }
}
