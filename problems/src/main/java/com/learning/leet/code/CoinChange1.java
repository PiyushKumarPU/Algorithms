package com.learning.leet.code;

import java.util.Arrays;

public class CoinChange1 {

    public int coinChange(int[] coins, int amount) {
        // Use an array for memoization, initialized with a value that signifies "uncomputed".
        int[] minCoins = new int[amount + 1];
        Arrays.fill(minCoins, -2); // Using -2 to indicate that the value has not been computed yet.
        return coinChangeHelper(coins, amount, minCoins);
    }

    private int coinChangeHelper(int[] coins, int amount, int[] minCoins) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;

        if (minCoins[amount] != -2) return minCoins[amount]; // Use memoized value if it exists.

        int minCoin = Integer.MAX_VALUE;
        for (int coin : coins) {
            int result = coinChangeHelper(coins, amount - coin, minCoins);
            if (result >= 0 && result < minCoin) {
                minCoin = result + 1;
            }
        }
        minCoins[amount] = (minCoin == Integer.MAX_VALUE) ? -1 : minCoin; // Memoize the result.
        return minCoins[amount];
    }
}
