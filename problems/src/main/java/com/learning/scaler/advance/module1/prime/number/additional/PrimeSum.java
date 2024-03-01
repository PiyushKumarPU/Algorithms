package com.learning.scaler.advance.module1.prime.number.additional;

import java.util.ArrayList;

/*
Problem Description
    Given an even number A ( greater than 2 ), return two prime numbers whose sum will be equal to the given number.
    If there is more than one solution possible, return the lexicographically smaller solution.
    If [a, b] is one solution with a <= b, and [c,d] is another solution with c <= d, then
    [a, b] < [c, d], If a < c OR a==c AND b < d.
    NOTE: A solution will always exist. Read Goldbach's conjecture.


Problem Constraints
    4 <= A <= 2*10^7

Input Format
    First and only argument of input is an even number A.

Output Format
    Return a integer array of size 2 containing primes whose sum will be equal to given number.

Example Input
     4

Example Output
    [2, 2]

Example Explanation
    There is only 1 solution for A = 4.
* */
public class PrimeSum {

    public int[] sieve(int N) {
        // Generate isPrime List less equal than N
        int[] isPrime = new int[N + 1];
        isPrime[0] = 0;
        isPrime[1] = 0;
        for (int i = 2; i <= N; i++) {
            isPrime[i] = 1;
        }
        // Sieve of Erastothenes
        for (int i = 2; i <= N; i++) {
            if (isPrime[i] == 0)
                continue;
            if (i > N / i)
                break;
            for (int j = i * i; j <= N; j += i)
                isPrime[j] = 0;
        }
        return isPrime;
    }

    public int[] primesumScaler(int A) {
        int[] isPrime = sieve(A);
        int[] ans = new int[2];
        for (int i = 2; i <= A; ++i) {
            if (isPrime[i] == 1 && isPrime[A - i] == 1) {
                ans[0] = i;
                ans[1] = A - i;
                return ans;
            }
        }
        return ans;
    }

    public ArrayList<Integer> primesum(int A) {
        boolean[] isPrime = new boolean[A + 1];
        ArrayList<Integer> result = new ArrayList(2);
        findPrimeRange(A, isPrime);
        for (int i = 0; i < A; i++) {
            if (isPrime[i] && isPrime[A - i]) {
                result.add(i);
                result.add(A - i);
                return result;
            }
        }
        return result;
    }


    static boolean findPrimeRange(int A, boolean[] isPrime) {
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i <= A; i++)
            isPrime[i] = true;
        for (int p = 2; p * p <= A; p++) {
            if (isPrime[p] == true) {
                for (int i = p * p; i <= A; i += p)
                    isPrime[i] = false;
            }
        }
        return false;
    }
}
