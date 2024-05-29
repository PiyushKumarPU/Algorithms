package com.learning.leet.code;


public class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int N = matrix.length, M = matrix[0].length, start = 0, end = N * M - 1;
        if (target < matrix[0][0] || target > matrix[N - 1][M - 1]) return false;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int i = mid / M, j = mid % M;
            int current = matrix[i][j];
            if (current == target) return true;
            else if (current > target) {
                end = mid - 1;
            } else start = mid + 1;
        }
        return false;
    }
}
