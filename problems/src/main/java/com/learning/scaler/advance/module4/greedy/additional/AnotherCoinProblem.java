package com.learning.scaler.advance.module4.greedy.additional;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
Problem Description
    The monetary system in DarkLand is really simple and systematic. The locals-only use coins. The coins come in different values. The values used are:
     1, 5, 25, 125, 625, 3125, 15625, ...
    Formally, for each K >= 0 there are coins worth 5K.
    Given an integer A denoting the cost of an item, find and return the smallest number of coins necessary to pay exactly the cost of the item (assuming you have a sufficient supply of coins of each of the types you will need).


Problem Constraints
    1 <= A <= 2×10^9


Input Format
    The only argument given is integer A.

Output Format
    Return the smallest number of coins necessary to pay exactly the cost of the item.

Example Input
    Input 1:
        A = 47
    Input 2:
        A = 9

Example Output
    Output 1:
        7
    Output 2:
        5

Example Explanation
    Explanation 1:
        Representation of 7 coins will be : (1 + 1 + 5 + 5 + 5 + 5 + 25).
    Explanation 2:
        Representation of 5 coins will be : (1 + 1 + 1 + 1 + 5).
* */
public class AnotherCoinProblem {

    static Map<Integer, BigInteger> powerMap = new HashMap<>(9);
    static int index = 0;

    static {
        powerMap.put(0, BigInteger.ONE);
        BigInteger currentVal = powerMap.get(0);
        while (currentVal.compareTo(BigInteger.valueOf(2000000000)) < 1) {
            currentVal = currentVal.multiply(BigInteger.valueOf(5));
            powerMap.put(++index, currentVal);
        }
    }

    public static void main(String[] args) {

        AnotherCoinProblem coinProblem = new AnotherCoinProblem();
        System.out.println(coinProblem.solve(2000000000));   // 2

    }

    public int solve(int A) {
        int count = 0;
        BigInteger value = BigInteger.valueOf(A);
        for (int i = index; i >= 0 && value.compareTo(BigInteger.ZERO) > 0; i--) {
            BigInteger val = powerMap.get(i);
            if (value.compareTo(val) > 0) {
                count += value.divide(val).intValue();
                value = value.mod(val);
            }
        }
        return count;
    }

    public int solveScaler(int A) {
        ArrayList<Integer> v = new ArrayList<>();
        int val = 1;
        // Storing all denominations of coins
        while (val <= 2000000000) {
            v.add(val);
            val = val * 5;
        }
        // Sort in decreasing order
        Collections.reverse(v);

        int ans = 0;
        // Loop from the largest denomination
        for (Integer integer : v) {
            ans += A / integer;
            A = A % integer;
        }
        return ans;
    }
}
