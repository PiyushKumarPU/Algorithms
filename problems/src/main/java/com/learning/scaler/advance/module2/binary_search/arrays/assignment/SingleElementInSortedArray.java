package com.learning.scaler.advance.module2.binary_search.arrays.assignment;

import java.util.List;

/*
Problem Description
Given a sorted array of integers A where every element appears twice except for one element which appears once,
find and return this single element that appears only once.

Elements which are appearing twice are adjacent to each other.

NOTE: Users are expected to solve this in O(log(N)) time.



Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 10^9



Input Format
The only argument given is the integer array A.



Output Format
Return the single element that appears only once.



Example Input
Input 1:

A = [1, 1, 7]
Input 2:

A = [2, 3, 3]


Example Output
Output 1:

 7
Output 2:

 2


Example Explanation
Explanation 1:

 7 appears once
Explanation 2:

 2 appears once
* */
public class SingleElementInSortedArray {

    public static void main(String[] args) {
        // System.out.println(approach2(List.of(1, 1, 2, 2, 3)));
        System.out.println(approach2(List.of(3, 3, 4, 4, 5)));

    }

    // return XOR of all the elements
    public int approach1(List<Integer> A) {
        int xor = A.get(0), start = 1, end = A.size() - 1;
        while (start < end) {
            xor = xor ^ A.get(start) ^ A.get(end);
            start++;
            end--;
        }
        return xor;
    }

    public static int approach2(List<Integer> A) {
        int start = 0, end = A.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2, ele = A.get(mid);
            if (start == end) return A.get(start);
            if (mid % 2 == 0) {
                if (mid > 0 && ele == A.get(mid - 1)) {
                    end = mid - 1;
                }
                if (mid == (A.size() - 2) && ele == A.get(mid + 1)) {
                    start = mid + 1;
                }
            } else {
                if (mid == (A.size() - 2) && ele == A.get(mid + 1)) {
                    end = mid - 1;
                }
                if (ele == A.get(mid - 1)) {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }


}
