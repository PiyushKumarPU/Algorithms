package com.learning.leet.code;

import java.util.Arrays;

// https://leetcode.com/problems/count-unguarded-cells-in-the-grid/description
public class CountUnguardedCellsInGrid {

    /*
     * Approach 1 : start from each guard and move in all four direction until it reaches wall or invalid index and mark those cell as guarded
     * */

    char[][] visited;

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        visited = new char[m][n];
        for (char[] chars : visited) Arrays.fill(chars, 'U');

        for (int[] wall : walls) {
            visited[wall[0]][wall[1]] = 'W';
        }

        for (int[] guard : guards) {
            visited[guard[0]][guard[1]] = 'G';
        }

        for (int[] guard : guards) {
            visitLeft(guard[0], guard[1], m, n);
            visitRight(guard[0], guard[1], m, n);
            visitTop(guard[0], guard[1], m, n);
            visitBottom(guard[0], guard[1], m, n);

        }
        int count = 0;
        for (char[] cell : visited) {
            for (char c : cell) {
                if (c == 'U') count++;
            }
        }
        return count;

    }

    private void visitRight(int i, int j, int m, int n) {
        if (isValidIndex(i, j, m, n) || visited[i][j] == 'W') return;
        if (visited[i][j] == 'U') {
            visited[i][j] = 'S';
        }
        visitRight(i + 1, j , m, n);
    }

    private void visitLeft(int i, int j, int m, int n) {
        if (isValidIndex(i, j, m, n) || visited[i][j] == 'W') return;
        if (visited[i][j] == 'U') {
            visited[i][j] = 'S';
        }
        visitLeft(i - 1, j, m, n);
    }

    private void visitTop(int i, int j, int m, int n) {
        if (isValidIndex(i, j, m, n) || visited[i][j] == 'W') return;
        if (visited[i][j] == 'U') {
            visited[i][j] = 'S';
        }
        visitTop(i, j - 1, m, n);
    }

    private void visitBottom(int i, int j, int m, int n) {
        if (isValidIndex(i, j, m, n) || visited[i][j] == 'W') return;
        if (visited[i][j] == 'U') {
            visited[i][j] = 'S';
        }
        visitBottom(i, j + 1, m, n);
    }


    private boolean isValidIndex(int i, int j, int m, int n) {
        return i < 0 || i >= m || j < 0 || j >= n;
    }


    public int countUnguarded1(int m, int n, int[][] guards, int[][] walls) {
        // Create a grid with 0 (empty), 1 (guard), 2 (wall), 3 (guarded)
        int[][] grid = new int[m][n];

        // Place guards and walls
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 1;
        }
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 2;
        }

        // Directions: up, down, left, right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Mark cells as guarded
        for (int[] guard : guards) {
            int x = guard[0], y = guard[1];
            for (int[] dir : directions) {
                int nx = x + dir[0], ny = y + dir[1];
                while (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] != 1 && grid[nx][ny] != 2) {
                    grid[nx][ny] = 3; // Mark as guarded
                    nx += dir[0];
                    ny += dir[1];
                }
            }
        }
        // Count unguarded cells
        int unguardedCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    unguardedCount++;
                }
            }
        }

        return unguardedCount;
    }
    public static void main(String[] args) {
        int m = 4, n = 6;
        int[][] guards = {{0, 0}, {1, 1}, {2, 3}};
        int[][] walls = {{0, 1}, {2, 2}, {1, 4}};
        System.out.println(new CountUnguardedCellsInGrid().countUnguarded(m, n, guards, walls));
    }
}
