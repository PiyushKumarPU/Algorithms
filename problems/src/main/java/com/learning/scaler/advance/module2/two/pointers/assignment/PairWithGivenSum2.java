package com.learning.scaler.advance.module2.two.pointers.assignment;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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
        System.out.println(solve(new ArrayList<>(List.of(1, 1, 1)), 2));
        System.out.println(solve(new ArrayList<>(List.of(1, 5, 7, 10)), 8));

    }

    public static int solve(ArrayList<Integer> A, int B) {
        if (A.size() == 1) return 0;
        ArrayList<Integer> uniques = new ArrayList<>(new HashSet<>(A));
        Map<Integer, Long> freqMap = A.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        if (uniques.size() == 1 && freqMap.get(uniques.get(0)) > 1) {
            return (A.size() * (A.size() - 1)) / 2;
        }
        int i = 0, j = uniques.size() - 1, count = 0;
        while (i < j) {
            int sum = uniques.get(i) + uniques.get(j);
            if (sum == B) {
                count += (int) (freqMap.get(uniques.get(i)) * freqMap.get(uniques.get(j)));
                i++;
                j--;
            } else if (sum < B) {
                i++;
            } else j--;

        }
        return count;
    }
}
