package com.learning.scaler.advance.module1.contest1;

import java.util.ArrayList;
import java.util.List;

/*
Problem Statement:

You are given an array of N integers A. You are also given Q queries given the array B.
For every query B[i], you need to find the count of pairs from the array A such that
the bitwise AND of them has the B[i]-th bit set i.e. 1 (a bit is considered "set" when it has a value of 1).

Note: It is guaranteed that the answer will fit in 32 bits

Constraints:
    1 <= N <= 10^5
    1 <= Q <= 50
    0 <= B[i] <= 31
    0 <= A[i] <= 10^9

Example Input:
    Input 1:
        A = [1,2,3]
        B = [0,1,2]
    Input 2:
       A = [2,5,6,7]
       B = [1,2]

Example Output:
    Output 1:
        [1,1,0]
    Output 2:
        [3,3]

Output Explanation:
    Output 1:
        The pair with 0-th bit set is (1, 3).
        The pair with 1-th bit set is (2, 3).
        There are no pairs with 2-th bit set.
    Output 2:
        The pairs with 1-th bit set are (2, 6), (2, 7) and (6, 7).
        The pairs with 2-th bit set are (5, 6), (5, 7) and (6, 7).
*
* */
public class CountAndPairs {

    public static void main(String[] args) {

    }


    // Approach 1
    public List<Integer> approach1(List<Integer> A, List<Integer> B) {
        List<Integer> result = new ArrayList<>();
        for (Integer query : B) {
            int count = 0, temp = (1 << query);
            for (int currentElement : A) {
                if ((currentElement & temp) > 0) {
                    count++;
                }
            }
            result.add(((count * (count - 1)) / 2));
        }
        return result;
    }

    public List<Integer> approach2(List<Integer> A, List<Integer> B) {
        List<Integer> result = new ArrayList<>();
        List<Integer> countPairs = new ArrayList<>();
        for (int pos = 0; pos < 32; pos++) {
            int count = 0;
            for (int currentElement : A) {
                if ((currentElement & (1 << pos)) != 0) {
                    count++;
                }
            }
            countPairs.add((((count - 1) * count) / 2));
        }
        for (Integer query : B) {
            result.add(countPairs.get(query));
        }
        return result;
    }
}
