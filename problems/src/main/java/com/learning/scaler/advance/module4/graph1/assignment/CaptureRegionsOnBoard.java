package com.learning.scaler.advance.module4.graph1.assignment;

import java.util.ArrayList;

/*
Problem Description
    Given a 2-D board A of size N x M containing 'X' and 'O', capture all regions surrounded by 'X'.
    A region is captured by flipping all 'O's into 'X's in that surrounded region.

Problem Constraints
1 <= N, M <= 1000

Input Format
    First and only argument is a N x M character matrix A.

Output Format
    Return nothing. Make changes to the the input only as matrix is passed by reference.

Example Input
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

Example Output
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

Example Explanation
    Explanation 1:
     O in (4,2) is not surrounded by X from below.
    Explanation 2:
     No O's are surrounded.
* */
public class CaptureRegionsOnBoard {

    public void solve(ArrayList<ArrayList<Character>> a) {
    }
}
