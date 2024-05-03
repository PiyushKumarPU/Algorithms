package com.learning.scaler.advance.module4.dp4.lecture;

import java.util.Arrays;

/*
Problem Description
    You are given a set of coins A. In how many ways can you make sum B assuming you have infinite amount
    of each coin in the set.
    NOTE:
        Coins in set A will be unique. Expected space complexity of this problem is O(B).
        The answer can overflow. So, return the answer % (10^6 + 7).

Problem Constraints
    1 <= A <= 500
    1 <= A[i] <= 1000
    1 <= B <= 50000

Input Format
    First argument is an integer array A representing the set.
    The Second argument is an integer B.

Output Format
     Returns an integer denoting the number of ways.

Example
    Input 1:
    A = [1, 2, 3]
    B = 4
    Input 2:
    A = [10]
    B = 10

Example
    Output 1:
        7
    Output 2:
        1

Example
    Explanation 1:
    The 7 possible ways are:
        {1, 1, 1, 1}
        {1, 1, 2}
        {1, 2, 1}
        {2, 1, 1}
        {2, 2}
        {1, 3}
        {3, 1}
    Explanation 2:
    There is only 1 way to make sum 10.
* */
public class CoinSumInfiniteWithDuplicate {

    public static void main(String[] args) {
        CoinSumInfiniteWithDuplicate infinite = new CoinSumInfiniteWithDuplicate();
        System.out.println(infinite.coinSum(new int[]{1, 2, 3}, 4));
        System.out.println(infinite.coinSumTopDown(new int[]{1, 2, 3}, 4));
        System.out.println(infinite.coinSumRec(new int[]{1, 2, 3}, 4));
    }

    // Recursive/brute force approach
    public int coinSum(int[] A, int B) {
        if (A == null || A.length == 0 || B < 0) return 0;
        if (B == 0) return 1;
        int count = 0;
        for (int a : A) {
            if (a <= B) {
                count += coinSum(A, B - a);
            }
        }
        return count;
    }

    // top-down approach
    int[] waysMatrix;

    public int coinSumTopDown(int[] A, int B) {
        if (A == null || A.length == 0 || B < 0) return 0;
        waysMatrix = new int[B + 1];
        Arrays.fill(waysMatrix, -1);
        waysMatrix[0] = 1;
        return coinSumTopDownRec(A, B);
    }

    public int coinSumTopDownRec(int[] A, int B) {
        if (A == null || A.length == 0 || B < 0) return 0;
        if (B == 0) return 1;
        if (waysMatrix[B] != -1) return waysMatrix[B];
        int count = 0;
        for (int a : A) {
            if (a <= B) {
                count += coinSumTopDownRec(A, B - a);
            }
        }
        waysMatrix[B] = count;
        return waysMatrix[B];
    }


    // bottom up approach
    public int coinSumRec(int[] A, int B) {
        int[] coinCountMatrix = new int[B + 1];
        coinCountMatrix[0] = 1;
        // calculate number of ways from 1
        for (int i = 1; i <= B; i++) {
            for (int k : A) {
                if (k <= i) {
                    coinCountMatrix[i] = coinCountMatrix[i] + coinCountMatrix[i - k];
                }
            }
        }
        return coinCountMatrix[B];
    }
}
