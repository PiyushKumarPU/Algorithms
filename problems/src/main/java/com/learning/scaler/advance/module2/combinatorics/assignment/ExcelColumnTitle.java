package com.learning.scaler.advance.module2.combinatorics.assignment;


/*
Problem Description
    Given a positive integer A, return its corresponding column title as it appears in an Excel sheet.
    For example:

        1 -> A
        2 -> B
        3 -> C
        ...
        26 -> Z
        27 -> AA
        28 -> AB

Problem Constraints
    1 <= A <= 10^9

Input Format
    First and only argument of input contains single integer A

Output Format
    Return a string denoting the corresponding title.

Example Input
    Input 1:
        A = 3
    Input 2:
        A = 27

Example Output
    Output 1:
        "C"
    Output 2:
        "AA"

Example Explanation
    Explanation 1:
        3 corrseponds to C.
    Explanation 2:
            1 -> A,
            2 -> B,
            3 -> C,
            ...
            26 -> Z,
            27 -> AA,
            28 -> AB
* */
public class ExcelColumnTitle {

    public String convertToTitle(int A) {
        String result = "";
        while (A > 0) {
            int rem = A % 26;
            if (rem == 0) {
                result = "Z" + result;
                A = (A / 26) - 1;
            }else{
                result = ((char)((rem - 1) + 'A')) + result;
                A = A / 26;
            }
        }
        return result;
    }
}
