package com.learning.leet.code;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class CoinChange {

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(new int[]{186, 419, 83, 408}, 6249));
    }


    int[] minCoins;

    public int coinChange(int[] coins, int amount) {
        if (amount <= 0 || coins == null || coins.length == 0) return 0;
        minCoins = new int[amount + 1];
        Arrays.fill(minCoins, Integer.MAX_VALUE);
        minCoins[0] = 0;
        int minCoins = coinCount(coins, amount);
        return minCoins < Integer.MAX_VALUE ? minCoins : -1;
    }

    private int coinCount(int[] coins, int amount) {
        if (amount <= 0) return 0;
        else if (minCoins[amount] != Integer.MAX_VALUE) return minCoins[amount];
        int totalCount = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (coin > amount) continue;
            totalCount = Math.min(totalCount, coinCount(coins, amount - coin));
        }
        if (totalCount < Integer.MAX_VALUE) totalCount++;
        minCoins[amount] = Math.min(minCoins[amount], totalCount);
        return minCoins[amount];
    }
}
