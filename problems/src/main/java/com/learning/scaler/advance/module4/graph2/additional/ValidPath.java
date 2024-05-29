package com.learning.scaler.advance.module4.graph2.additional;

/*
Problem Description
    There is a rectangle with left bottom as (0, 0) and right up as (x, y).
    There are N circles such that their centers are inside the rectangle.
    Radius of each circle is R. Now we need to find out if it is possible that we can move from (0, 0) to (x, y)
    without touching any circle.
    Note : We can move from any cell to any of its 8 adjecent neighbours and we cannot move outside the boundary of the rectangle at any point of time.

Problem Constraints
    0 <= x , y, R <= 100
    1 <= N <= 1000
    Center of each circle would lie within the grid

Input Format
    1st argument given is an Integer x, denoted by A in input.
    2nd argument given is an Integer y, denoted by B in input.
    3rd argument given is an Integer N, number of circles, denoted by C in input.
    4th argument given is an Integer R, radius of each circle, denoted by D in input.
    5th argument given is an Array A of size N, denoted by E in input,
    where A[i] = x cordinate of ith circle
    6th argument given is an Array B of size N, denoted by F in input, where B[i] = y cordinate of ith circle

Output Format
    Return YES or NO depending on weather it is possible to reach cell (x,y) or not starting from (0,0).

Example Input
    Input 1:
         x = 2
         y = 3
         N = 1
         R = 1
         A = [2]
         B = [3]
    Input 2:
         x = 3
         y = 3
         N = 1
         R = 1
         A = [0]
         B = [3]

Example Output
    Output 1:
         NO
    Output 2:
         YES

Example Explanation
    Explanation 1:
         There is NO valid path in this case
    Explanation 2:
         There is many valid paths in this case.
        One of the path is (0, 0) -> (1, 0) -> (2, 0) -> (3, 0) -> (3, 1) -> (3, 2) -> (3, 3).
* */

import java.util.*;

public class ValidPath {

    public static void main(String[] args) {
        int A = 41, B = 67, C = 5, D = 0;
        int[] E = {17, 16, 12, 0, 40};
        int[] F = {52, 61, 61, 25, 31};
        ValidPath validPath = new ValidPath();
        System.out.println(validPath.solve(A, B, C, D, E, F));
    }

    public String solve(int A, int B, int C, int D, int[] E, int[] F) {
        boolean[][] grid = new boolean[A + 1][B + 1];

        for (int i = 0; i <= A; i++) {
            Arrays.fill(grid[i], true);
        }

        // Mark the cells that are blocked by circles
        for (int k = 0; k < C; k++) {
            int cx = E[k];
            int cy = F[k];
            for (int i = Math.max(0, cx - D); i <= Math.min(A, cx + D); i++) {
                for (int j = Math.max(0, cy - D); j <= Math.min(B, cy + D); j++) {
                    if ((i - cx) * (i - cx) + (j - cy) * (j - cy) <= D * D) {
                        grid[i][j] = false;
                    }
                }
            }
        }

        // Check if start or end points are blocked
        if (!grid[0][0] || !grid[A][B]) {
            return "NO";
        }

        // BFS initialization
        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[A + 1][B + 1];

        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        // Perform BFS
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            if (cx == A && cy == B) {
                return "YES";
            }

            for (int[] dir : directions) {
                int nx = cx + dir[0];
                int ny = cy + dir[1];
                if (isValidIndex(nx, ny, A, B) && grid[nx][ny] && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return "NO";
    }

    private boolean isValidIndex(int x, int y, int A, int B) {
        return (x >= 0 && x <= A && y >= 0 && y <= B);
    }
}