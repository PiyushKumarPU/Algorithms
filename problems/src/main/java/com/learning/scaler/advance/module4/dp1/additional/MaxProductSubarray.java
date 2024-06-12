package com.learning.scaler.advance.module4.dp1.additional;

import java.util.List;

/*
Problem Description
    Given an integer array A of size N. Find the contiguous subarray within the given array
    (containing at least one number) which has the largest product.
    Return an integer corresponding to the maximum product possible.
    NOTE: Answer will fit in 32-bit integer value.

Problem Constraints
    1 <= N <= 5 * 10^5
    -100 <= A[i] <= 100

Input Format
    First and only argument is an integer array A.

Output Format
    Return an integer corresponding to the maximum product possible.

Example Input
    Input 1:
        A = [4, 2, -5, 1]
    Input 2:
        A = [-3, 0, -5, 0]

Example Output
    Output 1:
        8
    Output 2:
        0

Example Explanation
    Explanation 1:
         We can choose the subarray [4, 2] such that the maximum product is 8.
    Explanation 2:
         0 will be the maximum product possible.
* */
public class MaxProductSubarray {


    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{-2}));
    }

    public static int maxProduct(final int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int max_product = A[0];
        int current_max = A[0];
        int current_min = A[0];

        for (int i = 1; i < A.length; i++) {
            if (A[i] < 0) {
                // Swap current_max and current_min
                int temp = current_max;
                current_max = current_min;
                current_min = temp;
            }

            // Calculate current_max and current_min
            current_max = Math.max(A[i], current_max * A[i]);
            current_min = Math.min(A[i], current_min * A[i]);

            // Update max_product
            max_product = Math.max(max_product, current_max);
        }
        return max_product;
    }

}
