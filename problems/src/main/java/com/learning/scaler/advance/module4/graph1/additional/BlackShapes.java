package com.learning.scaler.advance.module4.graph1.additional;

import java.util.ArrayList;
import java.util.List;

/*
Problem Description
    Given character matrix A of dimensions N×M consisting of O's and X's, where O = white, X = black.
    Return the number of black shapes. A black shape consists of one or more adjacent X's (diagonals not included)

Problem Constraints
    1 <= N, M <= 1000
    A[i][j] = 'X' or 'O'


Input Format
    The First and only argument is character matrix A.

Output Format
    Return a single integer denoting number of black shapes.

Example Input
    Input 1:
     A = [ [X, X, X], [X, X, X], [X, X, X] ]
    Input 2:
     A = [ [X, O], [O, X] ]

Example Output
    Output 1:
     1
    Output 2:
     2

Example Explanation
    Explanation 1:
     All X's belong to single shapes
    Explanation 2:
     Both X's belong to different shapes
* */
public class BlackShapes {

    public static void main(String[] args) {
        List<String> input = List.of("XXX","XXX","XXX");
        BlackShapes blackShapes = new BlackShapes();
        System.out.println(blackShapes.black(new ArrayList<>(input)));
    }

    public int black(ArrayList<String> A) {
        int count = 0;
        char[][] inputs = new char[A.size()][A.get(0).length()];
        for (int i = 0; i < A.size(); i++) {
            String current = A.get(i);
            for (int j = 0; j < A.get(0).length(); j++) {
                inputs[i][j] = current.charAt(j);
            }
        }

        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.get(0).length(); j++) {
                if (inputs[i][j] == 'X') {
                    count++;
                    DFS(inputs, i, j);
                }
            }
        }
        return count;
    }

    private static void DFS(char[][] A, int i, int j) {
        if (i < 0 || i >= A.length || j < 0 || j >= A[0].length || A[i][j] != 'X') return;
        A[i][j] = 'Z';

        DFS(A, i, j - 1);
        DFS(A, i, j + 1);
        DFS(A, i + 1, j);
        DFS(A, i - 1, j);

    }
}
