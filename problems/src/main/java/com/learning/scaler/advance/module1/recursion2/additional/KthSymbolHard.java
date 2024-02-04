package com.learning.scaler.advance.module1.recursion2.additional;


/*
Problem Description
    On the first row, we write a 0. Now in every subsequent row, we look at the previous row and
    replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
    Given row number A and index B, return the Bth indexed symbol in row A. (The values of B are 0-indexed.).

Problem Constraints
    1 <= A <= 10^5
    0 <= B <= min(2A - 1 - 1 , 10^18)

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
public class KthSymbolHard {

    public int solve(int A, long B) {
        return 0;
    }


    public int solve(int A, Long B) {
        StringBuilder sb = new StringBuilder("0");
        for (int i = 1; i < A; i++) {
            String str = sb.toString();
            sb = new StringBuilder();
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '0')
                    sb.append("01");
                else sb.append("10");
            }
        }
        return sb.charAt(Math.toIntExact(B)) - '0';
    }
}
