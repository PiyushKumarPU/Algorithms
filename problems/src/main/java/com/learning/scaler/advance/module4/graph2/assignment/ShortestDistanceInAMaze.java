package com.learning.scaler.advance.module4.graph2.assignment;

import java.util.ArrayList;
import java.util.List;

/*
Problem Description
    Given a matrix of integers A of size N x M describing a maze. The maze consists of empty locations and walls.
    1 represents a wall in a matrix and 0 represents an empty location in a wall.
    There is a ball trapped in a maze. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall (maze boundary is also considered as a wall). When the ball stops, it could choose the next direction.
    Given two array of integers of size B and C of size 2 denoting the starting and destination position of the ball.
    Find the shortest distance for the ball to stop at the destination. The distance is defined by the number of empty spaces traveled by the ball from the starting position (excluded) to the destination (included). If the ball cannot stop at the destination, return -1.

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
        ArrayList<ArrayList<Integer>> A = new ArrayList<>(List.of(new ArrayList<>(List.of(0, 0)), new ArrayList<>(List.of(0, 0))));
        ArrayList<Integer> B = new ArrayList<>(List.of(0, 0));
        ArrayList<Integer> C = new ArrayList<>(List.of(0, 1));

        System.out.println(solve(A, B, C));
    }

    static int destX, destY;
    static ArrayList<ArrayList<Integer>> maze;

    public static int solve(ArrayList<ArrayList<Integer>> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        destX = C.get(0);
        destY = C.get(1);
        maze = A;

        return findShortestDistance(B.get(0), B.get(1));
    }

    private static int findShortestDistance(int i, int j) {
        if (i == destX && j == destY) return 0;
        if (maze.get(i).get(j) == 1) return Integer.MAX_VALUE;

        int left = (isValidIndex(i, j - 1)) ? findShortestDistance(i, j - 1) : Integer.MAX_VALUE;
        int top = (isValidIndex(i - 1, j)) ? findShortestDistance(i - 1, j) : Integer.MAX_VALUE;
        int bottom = (isValidIndex(i + 1, j)) ? findShortestDistance(i + 1, j) : Integer.MAX_VALUE;
        int right = (isValidIndex(i, j + 1)) ? findShortestDistance(i, j + 1) : Integer.MAX_VALUE;
        /*if (left == Integer.MAX_VALUE && right == Integer.MAX_VALUE && bottom == Integer.MAX_VALUE
                && top == Integer.MAX_VALUE) return -1;
        return Math.min(Math.min(left, right), Math.min(top, bottom)) + 1;*/
        return 1;
    }

    private static boolean isValidIndex(int x, int y) {
        return x >= 0 && y >= 0 && x < maze.size() && y < maze.get(x).size();
    }
}
