package com.learning.scaler.advance.module2.binary_search.problems.additional;

import java.util.ArrayList;
import java.util.List;

/*
Problem Description
    Given a matrix of integers A of size N x M in which each row is sorted.
    Find and return the overall median of matrix A.
    NOTE: No extra memory is allowed.
    NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.



Problem Constraints
    1 <= N, M <= 10^5
    1 <= N*M <= 10^6
    1 <= A[i] <= 10^9
    N*M is odd

Input Format
    The first and only argument given is the integer matrix A.

Output Format
    Return the overall median of matrix A.

Example Input
    Input 1:
    A = [   [1, 3, 5],
            [2, 6, 9],
            [3, 6, 9]   ]
    Input 2:
        A = [   [5, 17, 100]]

Example Output
    Output 1:
        5
    Output 2:
        17

Example Explanation
    Explanation 1:
        A = [1, 2, 3, 3, 5, 6, 6, 9, 9]
        Median is 5. So, we return 5.
    Explanation 2:
        Median is 17.
* */
public class MatrixMedian {

    public static void main(String[] args) {
        /*System.out.println(findMedian(new ArrayList<>(List.of(
                new ArrayList<>(List.of(5, 17, 100))
        ))));

        System.out.println(findMedian(new ArrayList<>(List.of(
                new ArrayList<>(List.of(1, 3, 5)),
                new ArrayList<>(List.of(2, 6, 9)),
                new ArrayList<>(List.of(3, 6, 9))
        ))));*/


        // 1 2 3 3 5 6 6 9 9
        // 1 2 3 4 5 6


    }

    public static int findMedian(ArrayList<ArrayList<Integer>> A) {
        // find min and max of matrix
        int start = Integer.MAX_VALUE, end = Integer.MIN_VALUE, n = A.size(), m = A.get(0).size();
        for (ArrayList<Integer> row : A) {
            start = Math.min(start, row.get(0));
            end = Math.max(end, row.get(row.size() - 1));
        }
        int targetCount = (n * m) / 2;
        // need to find k smaller or equal element to the mid
        while (start <= end) {
            int mid = start + (end - start) / 2;

        }
        return 0;
    }

}
