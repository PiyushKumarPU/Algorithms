package com.learning.scaler.advance.module4.dp2.assignment;

/*
Problem Description
    Find out the number of A digit positive numbers, whose digits on being added equals to a given number B.
    Note that a valid number starts from digits 1-9 except the number 0 itself. i.e. leading zeroes are not allowed.
    Since the answer can be large, output answer modulo 1000000007

Problem Constraints
    1 <= A <= 1000
    1 <= B <= 10000

Input Format
    First argument is the integer A
    Second argument is the integer B

Output Format
    Return a single integer, the answer to the problem

Example Input
    Input 1:
        A = 2
        B = 4
    Input 2:
        A = 1
        B = 3


Example Output
    Output 1:
        4
    Output 2:
        1

Example Explanation
    Explanation 1:
        Valid numbers are {22, 31, 13, 40}
        Hence output 4.
    Explanation 2:
        Only valid number is 3
* */
public class NDigitNumbers {

    static final int MOD = 1000000007;

    public static void main(String[] args) {
        System.out.println(new NDigitNumbers().solveBF(2, 5));
    }

    // Brute Force
    int count = 0;
    int[][] digitSumMatrix;

    public int solveBF(int A, int B) {
        if (B < 0)
            return 0;
        if (A == 0 && B == 0)
            return 1;
        if (A == 0)
            return 0;
        for (int digit = 0; digit <= 9; digit++) {
            if (digit > A || (A == 1 && digit == 0)) continue;
            count += solveBF(A - 1, B - digit);
        }
        return count % MOD;
    }

    public static int solveRecursive(int A, int B) {
        long[][] dp = new long[A + 1][B + 1];
        for (int j = 1; j < Math.min(10, B + 1); j++) {
            dp[1][j] = 1;
        }

        // Build up the solution
        for (int i = 2; i <= A; i++) {
            for (int j = 1; j <= B; j++) {
                for (int k = 0; k < 10; k++) {
                    if (j - k >= 0) {
                        dp[i][j] = dp[i][j] + (dp[i - 1][j - k] % MOD);
                    }
                }
            }
        }

        return (int) (dp[A][B] % MOD);
    }
}
