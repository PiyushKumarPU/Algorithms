package com.learning.scaler.advance.module4.graph2.assignment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Problem Description
    Given a matrix of integers A of size N x M consisting of 0, 1 or 2.
    Each cell can have three values:
    The value 0 representing an empty cell.
    The value 1 representing a fresh orange.
    The value 2 representing a rotten orange.
    Every minute, any fresh orange that is adjacent (Left, Right, Top, or Bottom) to a rotten orange becomes rotten. Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1 instead.
    Note: Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.

Problem Constraints
    1 <= N, M <= 1000
    0 <= A[i][j] <= 2

Input Format
    The first argument given is the integer matrix A.

Output Format
    Return the minimum number of minutes that must elapse until no cell has a fresh orange.
    If this is impossible, return -1 instead.

Example Input
    Input 1:
        A = [   [2, 1, 1]
                [1, 1, 0]
                [0, 1, 1]   ]
    Input 2:
        A = [   [2, 1, 1]
                [0, 1, 1]
                [1, 0, 1]   ]

Example Output
    Output 1:
         4
    Output 2:
         -1

Example Explanation
    Explanation 1:
        Minute 0: [ [2, 1, 1]
                    [1, 1, 0]
                    [0, 1, 1] ]
        Minute 1: [ [2, 2, 1]
                    [2, 1, 0]
                    [0, 1, 1] ]
        Minute 2: [ [2, 2, 2]
                    [2, 2, 0]
                    [0, 1, 1] ]
        Minute 3: [ [2, 2, 2]
                    [2, 2, 0]
                    [0, 2, 1] ]
        Minute 4: [ [2, 2, 2]
                    [2, 2, 0]
                    [0, 2, 2] ]
        At Minute 4, all the oranges are rotten.
    Explanation 2:
        The fresh orange at 2nd row and 0th column cannot be rotten, So return -1.
* */
public class RottenOranges {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>(
                List.of(
                        new ArrayList<>(List.of(2, 0, 2, 2, 2, 0, 2, 1, 1, 0)),
                        new ArrayList<>(List.of(0, 1, 2, 0, 2, 0, 0, 1, 0, 1)),
                        new ArrayList<>(List.of(0, 1, 1, 1, 2, 0, 1, 1, 2, 1)),
                        new ArrayList<>(List.of(2, 0, 2, 0, 1, 1, 2, 1, 0, 1)),
                        new ArrayList<>(List.of(1, 0, 1, 1, 0, 1, 2, 0, 2, 2)),
                        new ArrayList<>(List.of(0, 2, 1, 1, 2, 2, 0, 2, 1, 2)),
                        new ArrayList<>(List.of(2, 1, 0, 2, 0, 0, 0, 0, 1, 1)),
                        new ArrayList<>(List.of(2, 2, 0, 2, 2, 1, 1, 1, 2, 2))
                )
        );
        System.out.println(solve(A));

    }

    public static int solve(ArrayList<ArrayList<Integer>> A) {
        int N = A.size(), M = A.get(0).size(), totalTime = 0;
        int[] row = {-1, 0, 1, 0};
        int[] col = {0, 1, 0, -1};
        Queue<Triplet> rottenQueue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A.get(i).get(j) == 2)
                    rottenQueue.add(new Triplet(i, j, 0));
            }
        }

        while (!rottenQueue.isEmpty()) {
            Triplet triplet = rottenQueue.poll();
            int i = triplet.i, j = triplet.j, time = triplet.time;
            totalTime = Math.max(totalTime, time);
            for (int nbr = 0; nbr < 4; nbr++) {
                int nbrI = i + row[nbr];
                int nbrJ = j + col[nbr];
                if (isValidIndex(nbrI, nbrJ, N, M) && A.get(nbrI).get(nbrJ) == 1) {
                    rottenQueue.add(new Triplet(nbrI, nbrJ, time + 1));
                    A.get(nbrI).set(nbrJ, 2);
                }
            }
        }
        for (List<Integer> rows : A) {
            for (Integer val : rows) {
                if (val == 1) return -1;
            }
        }
        return totalTime;
    }

    private static boolean isValidIndex(int i, int j, int N, int M) {
        return i >= 0 && j >= 0 && i < N && j < M;
    }

}

class Triplet {
    public int i;
    public int j;
    public int time;

    public Triplet(int i, int j, int time) {
        this.i = i;
        this.j = j;
        this.time = time;
    }
}
