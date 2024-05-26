package com.learning.scaler.advance.module4.graph1.additional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
Problem Description
    Given a 2-D board A of size N x M containing 'X' and 'O', capture all regions surrounded by 'X'.
    A region is captured by flipping all 'O's into 'X's in that surrounded region.

Problem Constraints
1 <= N, M <= 1000

Input Format
    First and only argument is an N x M character matrix A.

Output Format
     Returns nothing. Make changes to the input only as matrix is passed by reference.

Example
    Input 1:
     A = [
           [X, X, X, X],
           [X, O, O, X],
           [X, X, O, X],
           [X, O, X, X]
         ]
    Input 2:
     A = [
           [X, O, O],
           [X, O, X],
           [O, O, O]
         ]

Example
    Output 1:
     After running your function, the board should be:
     A = [
           [X, X, X, X],
           [X, X, X, X],
           [X, X, X, X],
           [X, O, X, X]
         ]
    Output 2:
     After running your function, the board should be:
     A = [
           [X, O, O],
           [X, O, X],
           [O, O, O]
         ]

Example
    Explanation 1:
     O in (4,2) is not surrounded by X from below.
    Explanation 2:
     No O's are surrounded.
* */
public class CaptureRegionsOnBoard {

    public static void main(String[] args) {

        ArrayList<ArrayList<Character>> input = new ArrayList<>();
        input.add(new ArrayList<>(List.of('X', 'O', 'O', 'O', 'O', 'O', 'O', 'X')));
        input.add(new ArrayList<>(List.of('X', 'X', 'O', 'O', 'X', 'O', 'O', 'X')));
        input.add(new ArrayList<>(List.of('O', 'X', 'X', 'O', 'X', 'O', 'X', 'X')));
        new CaptureRegionsOnBoard().solve(input);
        System.out.println(input);
    }


    public void solve(ArrayList<ArrayList<Character>> board) {
        if (board == null || board.isEmpty()) {
            return;
        }

        int m = board.size();
        int n = board.get(0).size();

        for (int i = 0; i < m; i++) {
            ArrayList<Character> row = board.get(i);
            if (row.get(0) == 'O') {
                dfs(board, i, 0);
            }
            if (row.get(n - 1) == 'O') {
                dfs(board, i, n - 1);
            }
        }

        for (int j = 0; j < n; j++) {
            if (board.get(0).get(j) == 'O') {
                dfs(board, 0, j);
            }
            if (board.get(m - 1).get(j) == 'O') {
                dfs(board, m - 1, j);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board.get(i).get(j) == 'O') {
                    board.get(i).set(j, 'X');
                } else if (board.get(i).get(j) == 'S') {
                    board.get(i).set(j, 'O');
                }
            }
        }
    }


    private void dfs(ArrayList<ArrayList<Character>> board, int i, int j) {
        int m = board.size();
        int n = board.get(0).size();

        if (i < 0 || i >= m || j < 0 || j >= n || board.get(i).get(j) != 'O') {
            return;
        }
        board.get(i).set(j, 'S');

        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }
}



