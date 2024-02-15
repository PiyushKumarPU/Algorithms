package com.learning.scaler.intermediate.twod.matrix.assignment;

import java.util.ArrayList;
import java.util.List;

/*
Problem Description
    Give a N * N square matrix A, return an array of its anti-diagonals. Look at the example for more details.

Problem Constraints
    1<= N <= 1000
    1<= A[i][j] <= 10^9

Input Format
    Only argument is a 2D array A of size N * N.

Output Format
    Return a 2D integer array of size (2 * N-1) * N, representing the anti-diagonals of input array A.
    The vacant spaces in the grid should be assigned to 0.

Example Input
    Input 1:
        1 2 3
        4 5 6
        7 8 9
    Input 2:
        1 2
        3 4

Example Output
    Output 1:
        1 0 0
        2 4 0
        3 5 7
        6 8 0
        9 0 0
    Output 2:
        1 0
        2 3
        4 0

Example Explanation
    For input 1:
        The first anti diagonal of the matrix is [1 ], the rest spaces shoud be filled with 0 making the row as [1, 0, 0].
        The second anti diagonal of the matrix is [2, 4 ], the rest spaces shoud be filled with 0 making the row as [2, 4, 0].
        The third anti diagonal of the matrix is [3, 5, 7 ], the rest spaces shoud be filled with 0 making the row as [3, 5, 7].
        The fourth anti diagonal of the matrix is [6, 8 ], the rest spaces shoud be filled with 0 making the row as [6, 8, 0].
        The fifth anti diagonal of the matrix is [9 ], the rest spaces shoud be filled with 0 making the row as [9, 0, 0].
    For input 2:
        The first anti diagonal of the matrix is [1 ], the rest spaces shoud be filled with 0 making the row as [1, 0, 0].
        The second anti diagonal of the matrix is [2, 4 ], the rest spaces shoud be filled with 0 making the row as [2, 4, 0].
        The third anti diagonal of the matrix is [3, 0, 0 ], the rest spaces shoud be filled with 0 making the row as [3, 0, 0].

* */
public class AntiDiagonals {


    public ArrayList<ArrayList<Integer>> diagonal1(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int N = 2 * n - 1;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < N; i++)
            result.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result.get(i + j).add(A.get(i).get(j));
            }
        }
        for (ArrayList<Integer> data : result) {
            while (data.size() < n) {
                data.add(0);
            }
        }
        return result;
    }

    public ArrayList<ArrayList<Integer>> diagonalScaler(ArrayList<ArrayList<Integer>> A) {
        int l = A.size();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < 2 * l - 1; ++i) {
            int offset = i < l ? 0 : i - l + 1;
            ArrayList<Integer> row = new ArrayList<Integer>();
            int k = 0;
            for (int j = offset; j <= i - offset; ++j) {
                row.add(A.get(j).get(i - j));
                k++;
            }
            for (int j = k; j < l; j++) {
                row.add(0);
            }
            res.add(row);
        }
        return res;
    }

    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int i = 0;
        for (int j = 0; j < A.get(0).size(); j++) {
            result.add(constructRow(A, i, j));
        }
        for (i = 1; i < A.size(); i++) {
            result.add(constructRow(A, i, A.get(i).size() - 1));
        }
        return result;
    }

    private ArrayList<Integer> constructRow(ArrayList<ArrayList<Integer>> inputs, int i, int j) {
        int start = i, end = j;
        ArrayList<Integer> row = new ArrayList<>();
        while (end > -1 && start < inputs.get(0).size()) {
            row.add(inputs.get(start).get(end));
            start++;
            end--;
        }
        while (row.size() < inputs.get(0).size()) row.add(0);
        return row;
    }
}
