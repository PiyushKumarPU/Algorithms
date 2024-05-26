package com.learning.leet.code;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(new int[]{1, 2, 5}, 11));
    }


    int[] minCoins;

    public int coinChange(int[] coins, int amount) {
        if (amount <= 0 || coins == null || coins.length == 0) return 0;
        minCoins = new int[amount + 1];
        Arrays.fill(minCoins, -1);
        minCoins[0] = 0;
        int minCoins = coinCount(coins, amount);
        return minCoins != Integer.MAX_VALUE ? minCoins : -1;
    }

    private int coinCount(int[] coins, int amount) {
        if (amount < 0 || coins == null || coins.length == 0) return 0;
        if(amount == 0) return 1;
        if (minCoins[amount] != -1) return minCoins[amount];
        int coinCount = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (coin > amount) continue;
            coinCount = Math.min(coinCount, (1 + coinCount(coins, amount - coin)));
        }
        System.out.println(amount);
        if (coinCount != Integer.MAX_VALUE)
            minCoins[amount] = coinCount;
        return minCoins[amount];
    }
}
