package com.learning.leet.code;

import java.util.Arrays;

public class UniquePathsII {

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        UniquePathsII pathsII = new UniquePathsII();
        System.out.println(pathsII.uniquePathsWithObstacles(grid));
    }

    int[][] totalPathCount;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) return 0;
        int m = obstacleGrid.length, n = obstacleGrid[m - 1].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return 0;
        totalPathCount = new int[m][n];
        for (int[] arr : totalPathCount) Arrays.fill(arr, -1);
        return calculateUqPath(m - 1, n - 1, obstacleGrid);
    }

    private int calculateUqPath(int x, int y, int[][] grid) {
        if (!isValidIndex(x, y, grid) || grid[x][y] == 1) return 0;
        else if (x == 0 && y == 0) return 1;
        else if (totalPathCount[x][y] != -1) return totalPathCount[x][y];
        totalPathCount[x][y] = calculateUqPath(x - 1, y, grid) + calculateUqPath(x, y - 1, grid);
        return totalPathCount[x][y];
    }

    private boolean isValidIndex(int x, int y, int[][] grid) {
        return (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length);
    }

}
