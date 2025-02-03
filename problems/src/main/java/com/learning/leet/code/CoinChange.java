package com.learning.leet.code;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(coinChange.coinChange(new int[]{2}, 3));
    }

    int[] coinCounts;

    public int coinChange(int[] coins, int amount) {
        if (amount == 0 || coins == null || coins.length == 0) return 0;
        coinCounts = new int[amount + 1];
        Arrays.fill(coinCounts, -2);
        coinCounts[0] = 0;
        return calculateCoinCounts(coins, amount);
    }

    private int calculateCoinCounts(int[] coins, int amount) {
        if (amount <= 0) return 0;
        if (coinCounts[amount] != -2) return coinCounts[amount];

        Integer count = null;
        for (int coin : coins) {
            if (coin > amount) continue;
            int coinCount = calculateCoinCounts(coins, amount - coin);
            if (coinCount < 0) continue;
            coinCount++;
            count = count == null ? coinCount : Math.min(count, coinCount);
        }
        coinCounts[amount] = count == null ? -1 : count;
        return coinCounts[amount];
    }

    public int coinChangeIterative(int[] coins, int amount) {
        int[] minCoinsCount = new int[amount + 1];
        minCoinsCount[0] = 0;

        for (int currentAmount = 1; currentAmount <= amount; currentAmount++) {
            // setting higher limit
            int minCount = amount + 1;
            for (int coin : coins) {
                if (coin > currentAmount) continue;
                minCount = Math.min(minCount, 1 + minCoinsCount[currentAmount - coin]);
            }
            minCoinsCount[currentAmount] = minCount;
        }
        return minCoinsCount[amount] == amount + 1 ? -1 : minCoinsCount[amount];
    }

    public int coinChangeFastSolution(int[] coins, int amount) {
        int[] sums = new int[amount + 1];
        Arrays.fill(sums, amount + 1);
        sums[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= amount; ++i) {
                sums[i] = Math.min(sums[i], sums[i - coin] + 1);
            }
        }

        return sums[amount] > amount ? -1 : sums[amount];
    }

}
