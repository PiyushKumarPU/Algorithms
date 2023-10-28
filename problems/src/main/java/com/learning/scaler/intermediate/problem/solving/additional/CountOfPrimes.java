package com.learning.scaler.intermediate.problem.solving.additional;

/*
*Problem Description
* You will be given an integer n. You need to return the count of prime numbers less than or equal to n.
*
* Problem Constraints
0 <= n <= 10^3
* */
public class CountOfPrimes {

    public static void main(String[] args) {
        System.out.println(solve(19));
        System.out.println(solve(1));
    }

    public static int solve(int A) {
        int primeCount = 0;
        for (int index = 2; index <= A; index++) {
            primeCount += isPrime(index) ? 1 : 0;
        }
        return primeCount;
    }

    private static boolean isPrime(int A) {
        int factorCount = 0;
        for (int index = 1; index * index <= A; index++) {
            if (A % index == 0) {
                factorCount += (index == (A / index)) ? 1 : 2;
            }
        }
        return factorCount == 2;
    }
}
