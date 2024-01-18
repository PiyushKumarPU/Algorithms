package com.learning.scaler.advance.module4.dp2.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Problem Description
        The demons had captured the princess and imprisoned her in the bottom-right corner of a dungeon.
        The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight was initially positioned in the
        top-left room and must fight his way through the dungeon to rescue the princess.
        The knight has an initial health point represented by a positive integer.
        If at any point his health point drops to 0 or below, he dies immediately.
        Some of the rooms are guarded by demons, so the knight loses health (negative integers)
        upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the
        knight's health (positive integers).
        In order to reach the princess as quickly as possible, the knight decides to move only rightward or
        downward in each step.
        Given a 2D array of integers A of size M x N. Find and return the knight's minimum initial health so that
        he is able to rescue the princess.

    Problem Constraints
        1 <= M, N <= 500
        -100 <= A[i] <= 100

    Input Format
        First and only argument is a 2D integer array A denoting the grid of size M x N.

    Output Format
        Return an integer denoting the knight's minimum initial health so that he is able to rescue the princess.

    Example Input
        Input 1:
            A = [
                [-2, -3, 3],
                [-5, -10, 1],
                [10, 30, -5]
                ]
        Input 2:
            A = [
                [1, -1, 0],
                [-1, 1, -1],
                [1, 0, -1]
                ]

    Example Output
        Output 1:
            7
        Output 2:
            1

    Example Explanation
        Explanation 1:
            Initially knight is at A[0][0].
            If he takes the path RIGHT -> RIGHT -> DOWN -> DOWN, the minimum health required will be 7.
            At (0,0) he looses 2 health, so health becomes 5.
            At (0,1) he looses 3 health, so health becomes 2.
            At (0,2) he gains 3 health, so health becomes 5.
            At (1,2) he gains 1 health, so health becomes 6.
            At (2,2) he looses 5 health, so health becomes 1.
            At any point, the health point doesn't drop to 0 or below. So he can rescue the princess with minimum health 7.

        Explanation 2:
            Take the path DOWN -> DOWN ->RIGHT -> RIGHT, the minimum health required will be 1.
* */
public class DungeonPrincess {

    int[][] healthPoints;

    public static void main(String[] args) {
        DungeonPrincess princess = new DungeonPrincess();

        int result = princess.calculateMinimumHP(new ArrayList<>(List.of(
                new ArrayList<>(List.of(-2, -3, 3)),
                new ArrayList<>(List.of(-5, -10, 1)),
                new ArrayList<>(List.of(10, 30, -5))
        )));

        System.out.println(result);

    }

    public int calculateMinimumHP(ArrayList<ArrayList<Integer>> A) {
        int n = A.size(), m = A.get(0).size();
        healthPoints = new int[A.size()][A.get(0).size()];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == m - 1) {
                    healthPoints[i][j] = Math.max(1, 1 - A.get(i).get(j));
                } else if (i == n - 1) {
                    healthPoints[i][j] = Math.max(1, healthPoints[i][j + 1] - A.get(i).get(j));
                } else if (j == m - 1) {
                    healthPoints[i][j] = Math.max(1, healthPoints[i + 1][j] - A.get(i).get(j));
                } else {
                    healthPoints[i][j] = Math.max(1, Math.min(healthPoints[i][j + 1], healthPoints[i + 1][j])
                            - A.get(i).get(j));
                }
            }
        }
        return healthPoints[0][0];
    }


    public int calculateWithRec(ArrayList<ArrayList<Integer>> A, int start, int end) {
        int n = A.size(), m = A.get(0).size();
        if (start == n - 1 && end == m - 1) return 1 - (A.get(start).get(end));

        if (start < n - 1 && healthPoints[start + 1][end] == -1) {
            healthPoints[start + 1][end] = Math.max(1, calculateWithRec(A, start + 1, end));
        }
        if (end < m - 1 && healthPoints[start][end + 1] == -1) {
            healthPoints[start][end + 1] = Math.max(1, calculateWithRec(A, start, end + 1));
        }
        int down = (start == n - 1 ? Integer.MAX_VALUE : healthPoints[start + 1][end]),
                right = (end == m - 1 ? Integer.MAX_VALUE : healthPoints[start][end + 1]);

        return Math.max(1, (A.get(start).get(end) - Math.min(down, right)));
    }
}
