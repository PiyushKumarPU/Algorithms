package com.learning.scaler.advance.module4.dp3.additional;

/*
Problem Description
    Rishik likes candies a lot. So, he went to a candy-shop to buy candies.
    The shopkeeper showed him N packets each contain A[i] candies for cost of C[i] nibbles,
    each candy in that packet has a sweetness B[i]. The shopkeeper puts the condition that Rishik
    can buy as many complete candy-packets as he wants, but he can't buy a part of the packet.
    Rishik has D nibbles, can you tell him the maximum amount of sweetness he can get from
    candy-packets he will buy?

Problem Constraints
    1 <= N <= 700
    1 <= A[i] <= 1000
    1 <= B[i] <= 1000
    1 <= C[i],D <= 1000

Input Format
    First argument of input is an integer array A
    Second argument of input is an integer array B
    Third argument of input is an integer array C
    Fourth argument of input is an integer D

Output Format
    Return a single integer denoting maximum sweetness of the candies that he can buy

Example Input
    Input 1:
         A = [1, 2, 3]
         B = [2, 2, 10]
         C = [2, 3, 9]
         D = 8
    Input 2:
         A = [2]
         B = [5]
         C = [10]
         D = 99

Example Output
    Output 1:
        10
    Output 2:
        90

Example Explanation
    Explanation 1:
         Choose 1 Packet of kind 1 = 1 Candy of 2 Sweetness = 2 Sweetness
         Choose 2 Packet of kind 2 = 2 Candy of 2 Sweetness = 8 Sweetness
    Explanation 2:
        Buy 9 Packet of kind 1. 18 Candy each of 5 Sweetness = 90 Sweetness
* */
public class BuyingCandies {

    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        int[] B = {2, 2, 10};
        int[] C = {2, 3, 9};
        int D = 8;
        BuyingCandies candies = new BuyingCandies();
        System.out.println(candies.solve(A, B, C, D));
    }

    public int solve(int[] A, int[] B, int[] C, int D) {
        return 0;
    }



    /*public int solveScaler(int[] A, int[] B, int[] C, int D) {
        int[] dp = new int[D + 1];
        for (int i = 0; i < A.length; i++) {
            for (int j = C[i]; j <= D; j++) {
                dp[j] = Math.max(dp[j], dp[j - C[i]] + A[i] * B[i]);
            }
        }
        return dp[D];
    }

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B,
                     ArrayList<Integer> C, int D) {
        int[] sweetnessRange = new int[D + 1];
        sweetnessRange[0] = 0;
        for (int i = 1; i <= D; i++) {
            int maxValue = 0;
            for (int j = 0; j < A.size(); j++) {
                if (C.get(j) <= i) {
                    int remainingCost = i - C.get(j);
                    int totalSweetness = A.get(j) * B.get(j) +
                            (remainingCost > 0 ? sweetnessRange[remainingCost] : 0);
                    maxValue = Math.max(maxValue, totalSweetness);
                }
            }
            sweetnessRange[i] = maxValue;
        }
        return sweetnessRange[D];
    }*/

}
