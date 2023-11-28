package com.learning.scaler.advance.module2.binary_search.bs_answers.additional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
Problem Description
Given an array of integers A and an integer B, find and return the maximum value K such that there is no subarray in A of size K with the sum of elements greater than B.



Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 10^9

1 <= B <= 10^9



Input Format
The first argument given is the integer array A.

The second argument given is integer B.



Output Format
Return the maximum value of K (sub array length).



Example Input
Input 1:

A = [1, 2, 3, 4, 5]
B = 10
Input 2:

A = [5, 17, 100, 11]
B = 130


Example Output
Output 1:

 2
Output 2:

 3


Example Explanation
Explanation 1:

For K = 5, There are subarrays [1, 2, 3, 4, 5] which has a sum > B
For K = 4, There are subarrays [1, 2, 3, 4], [2, 3, 4, 5] which has a sum > B
For K = 3, There is a subarray [3, 4, 5] which has a sum > B
For K = 2, There were no subarray which has a sum > B.
Constraints are satisfied for maximal value of 2.
Explanation 2:

For K = 4, There are subarrays [5, 17, 100, 11] which has a sum > B
For K = 3, There were no subarray which has a sum > B.
Constraints are satisfied for maximal value of 3.
* */
public class SpecialInteger {

    public static void main(String[] args) {
        /*System.out.println(solveTwoPointers(new ArrayList<>(List.of(1, 2, 3, 4, 5)), 10));
        System.out.println(solveTwoPointers(new ArrayList<>(List.of(5, 17, 100, 11)), 130));*/
        System.out.println(solveBs(new ArrayList<>(List.of(2, 24, 38, 25, 35, 33, 43, 12, 49, 35, 45, 47, 5, 33)), 249));
    }


    public static int solveTwoPointers(ArrayList<Integer> A, int B) {
        A.sort(Comparator.naturalOrder());
        long totalSum = 0;
        int start = 0, end = A.size() - 1;
        for (Integer i : A) {
            totalSum += i;
        }
        if (totalSum <= B) return A.size();
        while (start <= end) {
            totalSum -= A.get(start);
            start++;
            if (totalSum <= B) {
                return (end - start) + 1;
            }
        }
        return 0;
    }

    public static int solveBs(ArrayList<Integer> A, int B) {
        A.sort(Comparator.naturalOrder());
        int start = 1, end = A.size(), ans = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (addLastXElement(A, mid) <= B) {
                ans = mid;
                start = mid + 1;
            } else end = mid - 1;
        }
        return ans;
    }

    private static long addLastXElement(ArrayList<Integer> A, int count) {
        int i = count;
        long totalSum = 0L;
        while (i > 0) {
            totalSum += A.get(A.size() - i);
            i--;
        }
        return totalSum;
    }
    // 0,1,2,3 .... n-3,n-2,n-1
}
