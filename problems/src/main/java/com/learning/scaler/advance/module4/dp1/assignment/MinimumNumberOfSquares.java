package com.learning.scaler.advance.module4.dp1.assignment;

import java.util.Arrays;

/*
Problem Description
    Given an integer A. Return minimum count of numbers, sum of whose squares is equal to A.

Problem Constraints
    1 <= A <= 10^5

Input Format
    First and only argument is an integer A.

Output Format
    Return an integer denoting the minimum count.

Example Input
    Input 1:
        A = 6
    Input 2:
        A = 5

Example Output
    Output 1:
        3
    Output 2:
        2

Example Explanation
Explanation 1:
    Possible combinations are : (12 + 12 + 12 + 12 + 12 + 12) and (12 + 12 + 22).
    Minimum count of numbers, sum of whose squares is 6 is 3.
Explanation 2:
    We can represent 5 using only 2 numbers i.e. 12 + 22 = 5
* */
public class MinimumNumberOfSquares {

    int[] squareCount;

    public static void main(String[] args) {
        MinimumNumberOfSquares squares = new MinimumNumberOfSquares();
        System.out.println(squares.countMinSquares(6));
    }

    public int countMinSquares(int A) {
        if (squareCount == null) {
            squareCount = new int[A + 1];
            Arrays.fill(squareCount, -1);
        }
        if (A == 0) return 0;
        if (squareCount[A] != -1) return squareCount[A];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i <= A; i++) {
            min = Math.min(min, countMinSquares(A - i * i));
        }
        squareCount[A] = min + 1;
        return squareCount[A];
    }
}
