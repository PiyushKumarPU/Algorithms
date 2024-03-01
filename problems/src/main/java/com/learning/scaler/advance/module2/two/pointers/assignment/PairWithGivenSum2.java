package com.learning.scaler.advance.module2.two.pointers.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
Problem Description
Given a sorted array of integers (not necessarily distinct) A and an integer B,
find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.

Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7).



Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 10^9

1 <= B <= 10^9



Input Format
The first argument given is the integer array A.

The second argument given is integer B.



Output Format
Return the number of pairs for which sum is equal to B modulo (10^9+7).



Example Input
Input 1:

A = [1, 1, 1]
B = 2
Input 2:

A = [1, 5, 7, 10]
B = 8


Example Output
Output 1:

 3
Output 2:

 1


Example Explanation
Explanation 1:

 The pairs of A[i] and A[j] which sum up to 2 are (0, 1), (0, 2) and (1, 2).
 There are 3 pairs.
Explanation 2:

 There is only one pair, such that i = 0, and j = 2 sums up to 8.
* */
public class PairWithGivenSum2 {

    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<>(List.of(2, 2, 3, 4, 4, 5, 6, 7, 10)), 8));

    }

    public static int solve(ArrayList<Integer> A, int B) {
        int start = 0, end = A.size() - 1, MOD = 1000000007;
        long count = 0;
        while (start < end) {
            int currentSum = A.get(start) + A.get(end);
            if (currentSum > B) end--;
            else if (currentSum < B) start++;
            else {
                if (Objects.equals(A.get(start), A.get(end))) {
                    int freq = end - start + 1;
                    count += ((long) freq * (freq - 1) / 2) % MOD;
                    count = count % MOD;
                    break;
                } else {
                    int iCopy = start, jCopy = end, iCount, jCount;
                    while (iCopy < end && Objects.equals(A.get(iCopy), A.get(start))) iCopy++;
                    iCount = iCopy - start;
                    while (jCopy >= iCopy && Objects.equals(A.get(jCopy), A.get(end))) jCopy--;
                    jCount = end - jCopy;
                    count += ((long) iCount * jCount) % MOD;
                    count = count % MOD;
                    start = iCopy;
                    end = jCopy;
                }
            }
        }
        return (int) (count % MOD);
    }
}
