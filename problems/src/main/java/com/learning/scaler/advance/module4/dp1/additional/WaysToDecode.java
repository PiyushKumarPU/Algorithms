package com.learning.scaler.advance.module4.dp1.additional;

import java.util.Arrays;

/*
Problem Description
    A message containing letters from A-Z is being encoded to numbers using the following mapping:
    'A' -> 1
    'B' -> 2
    ...
    'Z' -> 26
    Given an encoded message denoted by string A containing digits, determine the total number of
    ways to decode it modulo 109 + 7.

Problem Constraints
    1 <= length(A) <= 10^5

Input Format
    The first and the only argument is a string A.

Output Format
    Return an integer, representing the number of ways to decode the string modulo 10^9 + 7.

Example Input
    Input 1:
        A = "12"
    Input 2:
        A = "8"

Example Output
    Output 1:
        2
    Output 2:
        1

Example Explanation
    Explanation 1:
         Given encoded message "12", it could be decoded as "AB" (1, 2) or "L" (12).
         The number of ways decoding "12" is 2.
    Explanation 2:
         Given encoded message "8", it could be decoded as only "H" (8).
         The number of ways decoding "8" is 1.
* */
public class WaysToDecode {

    public static void main(String[] args) {
        System.out.println(new WaysToDecode().numDecodingsScaler("123"));
    }

    public static int numDecodings(String A) {
        int n = A.length();
        if (n == 0 || A.charAt(0) == '0') return 0;
        int[] waysCount = new int[n + 1];
        int m = 1000000007;
        waysCount[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (A.charAt(i - 1) != '0') {
                waysCount[i] += waysCount[i - 1] % m;
            }
            if (i >= 2 && isValid(A.substring(i - 2, i))) {
                waysCount[i] += waysCount[i - 2] % m;
            }
        }
        return waysCount[n] % m;
    }

    private static boolean isValid(String str) {
        int num = Integer.parseInt(str);
        return (num >= 10 && num <= 26);
    }


    public int numDecodingsScaler(String A) {
        if (A == null)
            return 0;
        int N = A.length();
        int[] dp = new int[N];
        Arrays.fill(dp, -1);
        return rec(N - 1, dp, A);
    }

    private int rec(int index, int[] dp, String A) {
        if (index < 0)
            return 1;
        if (dp[index] != -1)
            return dp[index] % 1000000007;
        int ways = 0;
        if (A.charAt(index) > '0') {
            ways = rec(index - 1, dp, A);
            ways %= 1000000007;
        }
        if (isValidTwoDigits(index, A)) {
            ways += rec(index - 2, dp, A);
            ways %= 1000000007;
        }
        return dp[index] = ways;
    }

    private boolean isValidTwoDigits(int index, String A) {
        return index > 0 && (A.charAt(index - 1) == '1' || A.charAt(index - 1) == '2' && A.charAt(index) < '7');
    }
}
