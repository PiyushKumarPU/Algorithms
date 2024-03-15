package com.learning.mock_preparation.day11_recursion_backtracking;

public class PowerOfNumbers {


    // https://www.geeksforgeeks.org/problems/power-of-numbers-1587115620/1

    public static void main(String[] args) {
        PowerOfNumbers powerOfNumbers = new PowerOfNumbers();
        System.out.println(powerOfNumbers.powerCalculate(11, 11));
        System.out.println(Math.pow(11, 11));
    }

    long powerCalculate(int N, int R) {
        long[] powerDp = new long[R + 1];
        powerDp[0] = 1;
        powerDp[1] = N;
        return power(N, R, powerDp);
    }

    long power(int N, int R, long[] powerDp) {
        if (R <= 0) return powerDp[0];
        if (powerDp[R] > 0) return powerDp[R];
        long result = ((R % 2 == 0) ? (power(N, R / 2, powerDp) * power(N, R / 2, powerDp)) :
                (N * power(N, (R - 1) / 2, powerDp) * power(N, (R - 1) / 2, powerDp))) % 1000000007;
        powerDp[R] = result % 1000000007;
        return powerDp[R];
    }
}
