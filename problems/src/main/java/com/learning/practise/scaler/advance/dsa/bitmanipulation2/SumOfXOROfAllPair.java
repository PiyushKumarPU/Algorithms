package com.learning.practise.scaler.advance.dsa.bitmanipulation2;

public class SumOfXOROfAllPair {

    public static void main(String[] args) {
        System.out.println(solve(new int[]{1, 2, 3}));
        System.out.println(solve(new int[]{3, 4, 2}));
    }

    public static int solve(int[] A) {
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                result += (A[i] ^ A[j]);
                result %= 1000000007;
            }
        }
        return result;
    }
}
