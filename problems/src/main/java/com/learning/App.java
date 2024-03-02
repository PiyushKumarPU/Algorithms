package com.learning;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Hello world!
 */
public class App {

    public static int numWaysToSendSignal(int A) {
        if (A == 0) return 1;
        if (A == 1) return 2;

        final int MOD = 1000000007;
        int[] dp = new int[A + 1];
        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i <= A; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }

        return dp[A];
    }

    public static void main(String[] args) {
        System.out.println(numWaysToSendSignal(2));
    }
}
