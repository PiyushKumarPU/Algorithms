package com.learning.scaler.advance.module1.recursion3.assignment;

import java.util.ArrayList;
import java.util.Objects;

/*
Problem Description
    On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
    Given row number A and index B, return the Bth indexed symbol in row A. (The values of B are 0-indexed.).

Problem Constraints
    1 <= A <= 20
    0 <= B < 2A - 1

Input Format
    First argument is an integer A.
    Second argument is an integer B.

Output Format
    Return an integer denoting the Bth indexed symbol in row A.

Example Input
    Input 1:
         A = 3
         B = 0
    Input 2:
         A = 4
         B = 4

Example Output
    Output 1:
         0
    Output 2:
         1

Example Explanation
    Explanation 1:
         Row 1: 0
         Row 2: 01
         Row 3: 0110
    Explanation 2:
         Row 1: 0
         Row 2: 01
         Row 3: 0110
         Row 4: 01101001
* */
public class KthSymbolEasy {

    public static void main(String[] args) {
        KthSymbolEasy easy = new KthSymbolEasy();


        System.out.println(easy.solve(4, 4L));

    }


    public int solve(int A, Long B) {
        if (A == 1 || B == 0) {
            return 0;
        }

        int prevSymbol = solve(A - 1, B / 2);
        if (prevSymbol == 0) {
            return (B % 2 == 0) ? 0 : 1;
        } else {
            return (B % 2 == 0) ? 1 : 0;
        }
    }

    ArrayList<Integer> A_th_Row(int A) {
        if (A == 1) {
            ArrayList<Integer> v2 = new ArrayList<Integer>();
            v2.add(0);
            return v2;
        }
        ArrayList<Integer> v1 = A_th_Row(A - 1);
        ArrayList<Integer> v2 = new ArrayList<>();
        for (Integer integer : v1) {
            if (integer == 0) {
                v2.add(0);
                v2.add(1);
            } else {
                v2.add(1);
                v2.add(0);
            }
        }
        return v2;
    }

    public int solve(int A, int B) {
        return A_th_Row(A).get(B);
    }
}
