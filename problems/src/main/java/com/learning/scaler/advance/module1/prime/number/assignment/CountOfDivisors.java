package com.learning.scaler.advance.module1.prime.number.assignment;


import java.util.ArrayList;

/*
Problem Description
    Given an array of integers A, find and return the count of divisors of each element of the array.
    NOTE: The order of the resultant array should be the same as the input array.



Problem Constraints
    1 <= length of the array <= 100000
    1 <= A[i] <= 10^6

Input Format
    The only argument given is the integer array A.

Output Format
    Return the count of divisors of each element of the array in the form of an array.

Example Input
    Input 1:
         A = [2, 3, 4, 5]
    Input 2:
         A = [8, 9, 10]

Example Output
    Output 1:
         [2, 2, 3, 2]
    Output 1:
         [4, 3, 4]

Example Explanation
    Explanation 1:
         The number of divisors of 2 : [1, 2], 3 : [1, 3], 4 : [1, 2, 4], 5 : [1, 5]
        So the count will be [2, 2, 3, 2].
    Explanation 2:
         The number of divisors of 8 : [1, 2, 4, 8], 9 : [1, 3, 9], 10 : [1, 2, 5, 10]
         So the count will be [4, 3, 4].
* */
public class CountOfDivisors {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList(A.size());
        for (Integer i : A) {
            result.add(divisorCount(i));
        }
        return result;
    }

    private int divisorCount(Integer number) {
        if (number == 1) return 1;
        int count = 0;
        for (int i = 1; i * i <= number; i++) {
            if (number % i == 0) count += (i == (number / i)) ? 1 : 2;
        }
        return count;
    }

    // Scaler
    int[] S;
    int SZ, NP = 1001001;

    void sieve() {
        int n = NP;
        S = new int[n];
        for (int i = 1; i < n; i++)
            S[i] = i;
        for (int i = 2; i * i <= n; i++) {
            if (S[i] != i)
                continue;
            for (int j = i * i; j < n; j += i) {
                if (S[j] == j)
                    S[j] = i;
            }
        }
    }

    int countDivisors(int x) {
        // Using prime factorization to get the number of divisors for every integer
        int ans = 1;
        while (S[x] > 1) {
            int cnt = 1, u = S[x];
            while (S[x] == u) {
                cnt++;
                x /= u;
            }
            ans *= cnt;
        }
        return ans;
    }

    public int[] solve(int[] a) {
        sieve();
        int n = a.length;
        int ans[] = new int[n];
        for (int i = 0; i < n; i++)
            ans[i] = countDivisors(a[i]);
        return ans;
    }
}
