package com.learning.leet.code;

import java.util.Arrays;

public class UniquePaths {

    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(3, 7));
    }

    int[][] totalPathCount;

    public int uniquePaths(int m, int n) {
        totalPathCount = new int[m][n];
        for (int[] arr : totalPathCount) Arrays.fill(arr, -1);
        return calculateUqPath(0, 0, m, n);
    }

    private int calculateUqPath(int x, int y, int m, int n) {
        if (!isValidIndex(x, y, m, n)) return 0;
        else if (x == m - 1 && y == n - 1) return 1;
        else if (totalPathCount[x][y] != -1) return totalPathCount[x][y];
        totalPathCount[x][y] = calculateUqPath(x + 1, y, m, n) + calculateUqPath(x, y + 1, m, n);
        return totalPathCount[x][y];
    }

    private boolean isValidIndex(int x, int y, int m, int n) {
        return (x >= 0 && x < m && y >= 0 && y < n);
    }

}
