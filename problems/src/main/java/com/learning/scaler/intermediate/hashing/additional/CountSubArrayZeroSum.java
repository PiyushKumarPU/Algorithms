package com.learning.scaler.intermediate.hashing.additional;

import java.util.HashMap;
import java.util.List;

/*

Problem Description
Given an array A of N integers.

Find the count of the subarrays in the array which sums to zero. Since the answer can be very large, return the remainder on dividing the result with 109+7


Problem Constraints
1 <= N <= 105
-109 <= A[i] <= 109


Input Format
Single argument which is an integer array A.


Output Format
Return an integer.


Example Input
Input 1:

 A = [1, -1, -2, 2]
Input 2:

 A = [-1, 2, -1]


Example Output
Output 1:

3
Output 2:

1


Example Explanation
Explanation 1:

 The subarrays with zero sum are [1, -1], [-2, 2] and [1, -1, -2, 2].
Explanation 2:

 The subarray with zero sum is [-1, 2, -1].
*
* */
public class CountSubArrayZeroSum {

    public static void main(String[] args) {
        System.out.println(solve(List.of(1, -1, -2, 2)));
        System.out.println(solve(List.of(-1, 2, -1)));
    }


    public static int solve(List<Integer> A) {
        if (A.stream().allMatch(val -> val == 0)) return (A.size() * A.size() + 1) / 2;
        long count = 0;
        HashMap<Long, Integer> countMap = new HashMap<>();
        long[] pf = new long[A.size()];
        pf[0] = A.get(0);
        if (A.get(0) == 0) count++;
        countMap.put(pf[0], 1);
        for (int i = 1; i < A.size(); i++) {
            pf[i] = pf[i - 1] + A.get(i);
            int currentCount = countMap.getOrDefault(pf[i], 0);

            if (pf[i] == 0) count = ((count + 1) % 10000007);
            if (currentCount > 0) count = ((count + 1) % 10000007);

            countMap.put(pf[i], currentCount + 1);
        }
        return (int) (count % 10000007);
    }
}
