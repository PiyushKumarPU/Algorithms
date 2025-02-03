package com.learning.leet.code;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public static int maxProfit(int[] prices) {
        int[] rightMax = new int[prices.length];
        rightMax[prices.length - 1] = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], prices[i]);
        }
        int maxProfit = rightMax[0] - prices[0];
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, rightMax[i] - prices[i]);
        }
        return maxProfit;
    }

    public int maxProfitOptimized(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int maxProfit = 0, maxPrice = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            maxProfit = Math.max(maxProfit, maxPrice - prices[i]);
            maxPrice = Math.max(maxPrice, prices[i]);
        }

        return maxProfit;
    }

    public int maxProfitBest(int[] prices) {
        int maxProfit = 0, minPrice = prices[0];
        for (int price : prices) {
            maxProfit = Math.max(maxProfit, price - minPrice);
            if (price < minPrice) minPrice = price;
        }
        return maxProfit;
    }
}
