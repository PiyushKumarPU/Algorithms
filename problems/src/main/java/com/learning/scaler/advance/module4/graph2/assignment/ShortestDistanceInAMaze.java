package com.learning.scaler.advance.module4.graph2.assignment;

import com.learning.scaler.advance.module4.graph3.Pair;

import java.util.*;

/*
Problem Description
    Given a matrix of integers A of size N x M describing a maze. The maze consists of empty locations and walls.
    1 represents a wall in a matrix and 0 represents an empty location in a wall.
    There is a ball trapped in a maze. The ball can go through empty spaces by rolling up, down, left or right,
    but it won't stop rolling until hitting a wall (maze boundary is also considered as a wall).
    When the ball stops, it could choose the next direction.
    Given two array of integers of size B and C of size 2 denoting the starting and destination position of the ball.
    Find the shortest distance for the ball to stop at the destination. The distance is defined by the number
    of empty spaces traveled by the ball from the starting position (excluded) to the destination (included).
    If the ball cannot stop at the destination, return -1.

Problem Constraints
    2 <= N, M <= 100
    0 <= A[i] <= 1
    0 <= B[i][0], C[i][0] < N
    0 <= B[i][1], C[i][1] < M

Input Format
    The first argument given is the integer matrix A.
    The second argument given is an array of integer B.
    The third argument if an array of integer C.

Output Format
    Return a single integer, the minimum distance required to reach destination

Example Input
    Input 1:
        A = [ [0, 0],
              [0, 0] ]
        B = [0, 0]
        C = [0, 1]
    Input 2:
        A = [ [0, 1],
              [1, 0] ]
        B = [0, 0]
        C = [1, 1]

Example Output
    Output 1:
         1
    Output 2:
         -1

Example Explanation
    Explanation 1:
         Go directly from start to destination in distance 1.
    Explanation 2:
         It is impossible to reach the destination from (0, 0) to (1, 1) as there are walls at (1, 0) and (0, 1)

* */
public class ShortestDistanceInAMaze {



    public static void main(String[] args) {
        int[][] A = {{1, 1, 0, 1}, {0, 0, 0, 1}, {1, 0, 0, 1}, {0, 0, 1, 0}};
        int[] B = {1, 1};
        int[] C = {2, 1};
        System.out.println(new ShortestDistanceInAMaze().solve(A, B, C));
    }

    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int solve(int[][] A, int[] B, int[] C) {
        int n = A.length;
        int m = A[0].length;
        int[][] distance = new int[n][m];
        for (int[] row : distance)
            Arrays.fill(row, Integer.MAX_VALUE);
        distance[B[0]][B[1]] = 0;

        Queue<Cell> queue = new LinkedList<>();
        queue.offer(new Cell(B[0], B[1]));
        while (!queue.isEmpty()) {
            Cell current = queue.poll();
            for (int[] dir : DIRECTIONS) {
                int x = current.xAxis + dir[0];
                int y = current.yAxis + dir[1];
                int rollCount = 0;
                while (isValidIndex(x, y, n, m) && A[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                    rollCount++;
                }
                int distanceFromCurrent = distance[current.xAxis][current.yAxis] + rollCount;
                int lastValidIndexDistance = distance[x - dir[0]][y - dir[1]];
                if (distanceFromCurrent < lastValidIndexDistance) {
                    distance[x - dir[0]][y - dir[1]] = distanceFromCurrent;
                    queue.offer(new Cell(x - dir[0], y - dir[1]));
                }
            }
        }
        distance[C[0]][C[1]] = (distance[C[0]][C[1]] == Integer.MAX_VALUE ? -1 : distance[C[0]][C[1]]);
        return distance[C[0]][C[1]];
    }

    private boolean isValidIndex(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}

class Cell {
    public Integer xAxis;
    public Integer yAxis;

    public Cell(Integer xAxis, Integer yAxis) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }
}
