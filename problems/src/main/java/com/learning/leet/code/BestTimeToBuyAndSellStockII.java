package com.learning.leet.code;

public class BestTimeToBuyAndSellStockII {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 2, 3, 4, 5}));
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int currentProfit = prices[i + 1] - prices[i];
            if (currentProfit > 0) maxProfit += currentProfit;
        }
        return maxProfit;
    }
}
