package com.learning.scaler.advance.module1.array2d.assignment;


/*
Problem Description
    Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order and return the generated square matrix.

Problem Constraints
    1 <= A <= 1000

Input Format
    First and only argument is integer A

Output Format
    Return a 2-D matrix which consists of the elements added in spiral order.

Example Input
    Input 1:
        1
    Input 2:
        2
    Input 3:
        5

Example Output
Output 1:
    [ [1] ]
Output 2:
    [ [1, 2],
      [4, 3] ]
Output 2:
    [ [1,   2,  3,  4, 5],
      [16, 17, 18, 19, 6],
      [15, 24, 25, 20, 7],
      [14, 23, 22, 21, 8],
      [13, 12, 11, 10, 9] ]

Example Explanation
    Explanation 1:
        Only 1 is to be arranged.
    Explanation 2:

        1 --> 2
              |
              |
        4<--- 3
* */
public class SpiralOrderMatrix {

    public static int[][] generateMatrix(int A) {
        int[][] result = new int[A][A];
        int startVal = 1, i = 0, j = 0;
        while (A > 1) {
            // L to R
            for (int index = 1; index < A; index++) {
                result[i][j] = startVal++;
                j++;
            }

            // T to B
            for (int index = 1; index < A; index++) {
                result[i][j] = startVal++;
                i++;
            }

            // R to L
            for (int index = 1; index < A; index++) {
                result[i][j] = startVal++;
                j--;
            }

            // B to T
            for (int index = 1; index < A; index++) {
                result[i][j] = startVal++;
                i--;
            }
            A -= 2;
            i += 1;
            j += 1;
        }
        if (A == 1) result[i][j] = startVal;
        return result;
    }
}
