package com.learning.scaler.advance.module2.combinatorics.assignment;


/*
Problem Description
    Given three integers A, B, and C, where A represents n, B represents r, and C represents m,
    find and return the value of nCr % m where nCr % m = (n!/((n-r)!*r!))% m.
    x! means factorial of x i.e. x! = 1 * 2 * 3... * x.

Problem Constraints
    1 <= A * B <= 10^6
    1 <= B <= A
    1 <= C <=10^6

Input Format
    The first argument given is integer A ( = n).
    The second argument given is integer B ( = r).
    The third argument given is integer C ( = m).

Output Format
    Return the value of nCr % m.

Example Input
    Input 1:
         A = 5
         B = 2
         C = 13
    Input 2:
         A = 6
         B = 2
         C = 13

Example Output
    Output 1:
         10
    Output 2:
         2

Example Explanation
    Explanation 1:
         The value of 5C2 % 11 is 10.
    Explanation 2:
         The value of 6C2 % 13 is 2.
* */
public class ComputeNCRMODM {

    public int solve(int A, int B, int C) {
        if(B == 1) return A % C;
        java.math.BigInteger top = factL(A);
        java.math.BigInteger bottom1 = factL(A-B);
        java.math.BigInteger bottom2 = factL(B);
        if(bottom1.equals(java.math.BigInteger.ZERO) || bottom2.equals(java.math.BigInteger.ZERO)) return 0;
        return top.divide(bottom1.multiply(bottom2)).mod(new java.math.BigInteger(String.valueOf(C))).intValue();
    }

    private static java.math.BigInteger factL(int n){
        java.math.BigInteger fact = java.math.BigInteger.ONE;
        int start = 2, end = n;
        while (start <= end){
            fact = fact.multiply(new java.math.BigInteger(String.valueOf(start)));
            if(start != end){
                fact = fact.multiply(new java.math.BigInteger(String.valueOf(end)));
            }
            start++;
            end--;
        }
        return fact;
    }

    // Scaler
    public int solveScaler(int A, int B, int C) {
        // dp[n][r] stores the value of nCr
        int[][] dp = new int[A + 1][B + 1];
        for(int i = 0; i <= A; i++) {
            for(int j = 0; j <= Math.min(i, B); j++) {
                if(j == i || j == 0) {
                    dp[i][j] = 1;
                } else {
                    // nCr = (n - 1)C(r - 1) + (n - 1)Cr
                    dp[i][j] = (dp[i - 1][j - 1] % C + dp[i - 1][j] % C) % C;
                }
            }
        }
        return dp[A][B] % C;
    }
}
