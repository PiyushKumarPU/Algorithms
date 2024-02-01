package com.learning.scaler.advance.module1.recursion1.assignment;


/*
Problem Description
    Write a program to find the factorial of the given number A using recursion.
    Note: The factorial of a number N is defined as the product of the numbers from 1 to N.

Problem Constraints
    0 <= A <= 12

Input Format
    First and only argument is an integer A.

Output Format
    Return an integer denoting the factorial of the number A.

Example Input
    Input 1:
         A = 4
    Input 2:
         A = 1

Example Output
    Output 1:
         24
    Output 2:
         1

Example Explanation
    Explanation 1:
         Factorial of 4 = 4 * 3 * 2 * 1 = 24
    Explanation 2:
         Factorial of 1 = 1
* */
public class FindFactorialI {

    public static void main(String[] args) {
        FindFactorialI  findFactorialI = new FindFactorialI();

        System.out.println(findFactorialI.solve(4));
        System.out.println(findFactorialI.solveIterative(4));


    }

    public int solve(int A) {
        if (A == 1) return 1;
        return solve(A - 1) * A;
    }

    public int solveIterative(int A) {
        int f1 = 1;
        for (int i = 2; i <= A; i++) {
            f1 = i * f1;
        }
        return f1;
    }

}
