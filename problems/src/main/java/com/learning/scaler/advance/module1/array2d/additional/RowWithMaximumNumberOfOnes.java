package com.learning.scaler.advance.module1.array2d.additional;

/*
Problem Description
    Given a binary sorted matrix A of size N x N. Find the row with the maximum number of 1.

    NOTE:
        If two rows have the maximum number of 1 then return the row which has a lower index.
        Rows are numbered from top to bottom and columns are numbered from left to right.
        Assume 0-based indexing.
        Assume each row to be sorted by values.
        Expected time complexity is O(rows + columns).

Problem Constraints
    1 <= N <= 1000
    0 <= A[i] <= 1

Input Format
    The only argument given is the integer matrix A.

Output Format
    Return the row with the maximum number of 1.

Example Input
    Input 1:
         A = [   [0, 1, 1]
                 [0, 0, 1]
                 [0, 1, 1]   ]
    Input 2:
         A = [   [0, 0, 0, 0]
                 [0, 0, 0, 1]
                 [0, 0, 1, 1]
                 [0, 1, 1, 1]    ]

Example Output
    Output 1:
         0
    Output 2:
         3

Example Explanation
    Explanation 1:
         Row 0 has maximum number of 1s.
    Explanation 2:
         Row 3 has maximum number of 1s.
* */
public class RowWithMaximumNumberOfOnes {

    public int solve(int[][] A) {
        int count = 0, start = 0, end = A[0].length - 1;
        while (start < A.length && end >= 0) {
            int current = A[start][end];
            if (current == 1) {
                count++;
                end--;
            } else {
                start++;
            }
        }
        return count;
    }
}
