package com.learning.leet.code;

public class NoOfIsland {
    static char[][] matrix;


    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int count = 0;
        matrix = grid;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (matrix[i][j] == '1') {
                    count++;
                    bfs(i, j);
                }
            }
        }
        return count;
    }

    private static void bfs(int i, int j) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] != '1') return;
        if (matrix[i][j] == '1') matrix[i][j] = '0';
        bfs(i - 1, j);
        bfs(i + 1, j);
        bfs(i, j - 1);
        bfs(i, j + 1);
    }
}
