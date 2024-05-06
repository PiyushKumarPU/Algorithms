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



    public void solve(ArrayList<ArrayList<Character>> a) {
        int n = a.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a.get(i).get(j) == 'O') {
                    isValidIndex(a, i, j, "");
                }
            }
        }
    }

    private boolean isValidIndex(ArrayList<ArrayList<Character>> A, int i, int j, String caller) {
        if (i < 0 || j < 0 || i >= A.size() || j > A.get(0).size() || A.get(i).get(j) == 'B'
                || (i == 0 && j == 0 && A.get(i).get(j) != 'X')
                || (i == A.size() - 1 && j == A.get(0).size() - 1 && A.get(i).get(j) != 'X')
        ) return false;
        if (A.get(i).get(j) == 'X') return true;
        if (!Objects.equals(caller, ""))
            System.out.println("Called by " + caller + " with i " + i + " and j " + j);




        if (isValidIndex(A, i, j - 1, "Left") && isValidIndex(A, i, j + 1, "Right")
                && isValidIndex(A, i - 1, j, "Up") && isValidIndex(A, i + 1, j, "Bottom")) {
            A.get(i).set(j, 'X');
            return true;
        } else {
            A.get(i).set(j, 'B');
            return false;
        }
    }
}



