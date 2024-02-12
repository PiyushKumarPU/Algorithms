package com.learning.scaler.intermediate.prefix.sum.assignment;

import java.util.ArrayList;

/*
Problem Description
    You are given an integer array A of length N.
    You are also given a 2D integer array B with dimensions M x 2, where each row denotes a [L, R] query.
    For each query, you have to find the sum of all elements from L to R indices in A (0 - indexed).
    More formally, find A[L] + A[L + 1] + A[L + 2] +... + A[R - 1] + A[R] for each query.


Problem Constraints
    1 <= N, M <= 10^5
    1 <= A[i] <= 10^9
    0 <= L <= R < N

Input Format
    The first argument is the integer array A.
    The second argument is the 2D integer array B.

Output Format
    Return an integer array of length M where ith element is the answer for ith query in B.

Example Input
    Input 1:
        A = [1, 2, 3, 4, 5]
        B = [[0, 3], [1, 2]]
    Input 2:
        A = [2, 2, 2]
        B = [[0, 0], [1, 2]]

Example Output
    Output 1:
        [10, 5]
    Output 2:
        [2, 4]

Example Explanation
Explanation 1:
    The sum of all elements of A[0 ... 3] = 1 + 2 + 3 + 4 = 10.
    The sum of all elements of A[1 ... 2] = 2 + 3 = 5.
Explanation 2:
    The sum of all elements of A[0 ... 0] = 2 = 2.
    The sum of all elements of A[1 ... 2] = 2 + 2 = 4.
* */
public class RangeSumQuery {
    public ArrayList<Long> rangeSum(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Long> result = new ArrayList<>(B.size());
        // calculate prefix sum
        ArrayList<Long> prefixSum = new ArrayList<>(A.size());
        prefixSum.add(Long.valueOf(A.get(0)));
        for (int i = 1; i < A.size(); i++) {
            prefixSum.add(prefixSum.get(i - 1) + A.get(i));
        }
        for (ArrayList<Integer> row : B) {
            int L = row.get(0);
            int R = row.get(1);
            result.add(prefixSum.get(R) - (L > 0 ? prefixSum.get(L - 1) : 0));
        }
        return result;
    }
}
