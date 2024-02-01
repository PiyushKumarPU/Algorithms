package com.learning.scaler.advance.module1.recursion1.assignment;


/*
Problem Description
    You are given an integer A, print 1 to A using using recursion.
    Note :- After printing all the numbers from 1 to A, print a new line.

Problem Constraints
    1 <= A <= 10^4

Input Format
    First argument A is an integer.

Output Format
    Print A space-separated integers 1 to A.
    Note: There should be exactly one space after each integer. After printing all the integers, print a new line

Example Input
    Input 1:
        A = 10
    Input 2:
        A = 5

Example Output
    Output 1:
        1 2 3 4 5 6 7 8 9 10
    Output 2:
        1 2 3 4 5

Example Explanation
    Explanation 1:
        Print 1 to 10 space separated integers.
    Explanation 2:
        Print 1 to 5 space separated integers.
* */
public class Print1ToAFunction {

    public void solve(int A) {
        print(A, 1);
        System.out.println();
    }

    private void print(int A, int i) {
        if (A > 0) {
            System.out.print(i + " ");
            print(A - 1, i + 1);
        }
    }
}
