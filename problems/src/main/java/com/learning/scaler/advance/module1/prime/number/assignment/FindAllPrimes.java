package com.learning.scaler.advance.module1.prime.number.assignment;


import java.util.ArrayList;

/*
Problem Description
    Given an integer A. Find the list of all prime numbers in the range [1, A].
Problem Constraints
    1 <= A <= 10^6

Input Format
    Only argument A is an integer.

Output Format
    Return a sorted array of prime number in the range [1, A].

Example Input
    Input 1:
        A = 7
    Input 2:
        A = 12

Example Output
    Output 1:
        [2, 3, 5, 7]
    Output 2:
        [2, 3, 5, 7, 11]

Example Explanation
For Input 1:
    The prime numbers from 1 to 7 are 2, 3, 5 and 7.
For Input 2:
    The prime numbers from 1 to 12 are 2, 3, 5, 7 and 11.
* */
public class FindAllPrimes {

    public ArrayList<Integer> solve(int A) {
        boolean[] isPrime = new boolean[A + 1];
        for (int i = 2; i <= A; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i <= A; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= A; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 2; i <= A; i++) {
            if (isPrime[i]) {
                res.add(i);
            }

        }
        return res;
    }

    // scaler
    public int[] sieve(int n) {
        // sieve of eratosthenes
        int[] prime = new int[n + 1];
        for (int i = 2; i * i <= n; i++) {
            if (prime[i] == 0) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = 1;
                }
            }
        }
        return prime;
    }

    public int[] solveScaler(int A) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int[] prime = sieve(A);
        for (int i = 2; i <= A; i++) {
            if (prime[i] == 0) {
                ans.add(i);
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
}
