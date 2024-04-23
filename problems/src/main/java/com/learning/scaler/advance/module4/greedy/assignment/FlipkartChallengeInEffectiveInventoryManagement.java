package com.learning.scaler.advance.module4.greedy.assignment;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
Problem Description
    In the recent expansion into grocery delivery, Flipkart faces a crucial challenge in effective inventory management.
    Each grocery item on the platform carries its own expiration date and profit margin, represented by two arrays,
    A and B of size N. A[i] denotes the time left before expiration date for the ith item, and B[i] denotes profit
    margin for the ith item. To mitigate potential losses due to expiring items, Flipkart is seeking a strategic solution.
    The goal is to identify a method to strategically buy certain items, ensuring they are sold before their expiration date,
    thereby maximizing overall profit. Can you assist Flipkart in developing an innovative approach to optimize their
    grocery inventory and enhance profitability?
    Your task is to find the maximum profit one can earn by buying groceries considering that you can only buy one grocery
    item at a time.
    NOTE:
        You can assume that it takes 1 minute to buy a grocery item, so you can only buy the ith grocery item when
        the current time <= A[i] - 1.
        You can start buying from day = 0.
        Return your answer modulo 10^9 + 7.

Problem Constraints
    1 <= N <= 10^5
    1 <= A[i] <= 10^9
    0 <= B[i] <= 10^9

Input Format
    The first argument is an integer array A represents the deadline for buying the grocery items.
    The second argument is an integer array B represents the profit obtained after buying the grocery items.

Output Format
     Returns an integer denoting the maximum profit you can earn.

Example Input
    Input 1:
         A = [1, 3, 2, 3, 3]
         B = [5, 6, 1, 3, 9]
    Input 2:
         A = [3, 8, 7, 5]
         B = [3, 1, 7, 19]

Example Output
    Output 1:
         20
    Output 2:
         30

Example Explanation
    Explanation 1:
         At time 0, buy item with profit 5.
         At time 1, buy item with profit 6.
         At time 2, buy item with profit 9.
         At time = 3 or after , you can't buy any item, as there is no item with deadline >= 4.
         So, total profit that one can earn is 20.
    Explanation 2:
         At time 0, buy item with profit 3.
         At time 1, buy item with profit 1.
         At time 2, buy item with profit 7.
         At time 3, buy item with profit 19.
         We are able to buy all items within their deadline. So, the total profit that one can earn is 30.
* */
public class FlipkartChallengeInEffectiveInventoryManagement {

    public static void main(String[] args) {

    }

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        if (A == null || B == null) return 0;
        ArrayList<Grocery> groceries = new ArrayList<>(A.size());
        for (int i = 0; i < A.size(); i++) {
            groceries.add(new Grocery(A.get(i), B.get(i)));
        }
        groceries.sort(Comparator.comparingInt(g -> g.expiration));
        PriorityQueue<Integer> minProfitHeap = new PriorityQueue<>();
        int time = 0;
        for (Grocery grocery : groceries) {
            if (grocery.expiration > time) {
                minProfitHeap.offer(grocery.profit);
                time++;
            } else if (!minProfitHeap.isEmpty() && grocery.profit > minProfitHeap.peek()) {
                minProfitHeap.poll();
                minProfitHeap.offer(grocery.profit);
            }
        }
        int totalSum = 0;
        while (!minProfitHeap.isEmpty()){
            totalSum += minProfitHeap.poll();
            totalSum %= 1000000007;
        }
        return totalSum;
    }

}

class Grocery {
    int expiration;
    int profit;

    public Grocery(int expiration, int profit) {
        this.expiration = expiration;
        this.profit = profit;
    }
}
