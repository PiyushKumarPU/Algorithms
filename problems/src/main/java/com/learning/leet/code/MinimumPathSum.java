package com.learning.leet.code;

import java.util.Arrays;

public class MinimumPathSum {


    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        MinimumPathSum sum = new MinimumPathSum();
        System.out.println(sum.minPathSum(grid));
    }

    int[][] minPathMatrix;

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[m - 1].length;
        minPathMatrix = new int[m][n];
        for (int[] arr : minPathMatrix) Arrays.fill(arr, Integer.MAX_VALUE);
        return calculatePath(m - 1, n - 1, grid);
    }

    private int calculatePath(int x, int y, int[][] grid) {
        if (!isValidIndex(x, y, grid)) return Integer.MAX_VALUE;
        if (minPathMatrix[x][y] != Integer.MAX_VALUE) return minPathMatrix[x][y];
        else if (x == 0 && y == 0) return grid[x][y];
        int remaining = Math.min(calculatePath(x - 1, y, grid), calculatePath(x, y - 1, grid));
        int total = grid[x][y] + (remaining == Integer.MAX_VALUE ? 0 : remaining);
        minPathMatrix[x][y] = total;
        return minPathMatrix[x][y];
    }

    private boolean isValidIndex(int x, int y, int[][] grid) {
        return (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length);
    }
}
