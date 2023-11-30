package com.learning.scaler.advance.module2.binary_search.problems.assignment;

import java.util.List;

/*
Problem Description
Given a sorted array of integers A of size N and an integer B,
where array A is rotated at some pivot unknown beforehand.

For example, the array [0, 1, 2, 4, 5, 6, 7] might become [4, 5, 6, 7, 0, 1, 2].

Your task is to search for the target value B in the array. If found, return its index; otherwise, return -1.

You can assume that no duplicates exist in the array.

NOTE: You are expected to solve this problem with a time complexity of O(log(N)).


Problem Constraints
1 <= N <= 1000000
1 <= A[i] <= 109
All elements in A are Distinct.


Input Format
The First argument given is the integer array A.
The Second argument given is the integer B.


Output Format
Return index of B in array A, otherwise return -1


Example Input
Input 1:

A = [4, 5, 6, 7, 0, 1, 2, 3]
B = 4
Input 2:

A : [ 9, 10, 3, 5, 6, 8 ]
B : 5


Example Output
Output 1:

 0
Output 2:

 3


Example Explanation
Explanation 1:

Target 4 is found at index 0 in A.
Explanation 2:

Target 5 is found at index 3 in A.
* */
public class RotatedSortedArraySearch {

    public static void main(String[] args) {
        System.out.println(search(List.of(1, 3, 5), 5));
        //System.out.println(search(List.of(9, 10, 3, 5, 6, 8),5));

    }

    public static int search(final List<Integer> A, int B) {
        int start = 0, end = A.size() - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (A.get(mid).equals(B)) return mid;
            // check if target is in part 1
            if (B >= A.get(0)) {
                // if mid is in part 1
                if (A.get(mid) >= A.get(0)) {
                    // apply bs here
                    if (A.get(mid) > B) end = mid - 1;
                    else start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                // target is in part2
                // if mid is in part 1
                if (A.get(mid) >= A.get(0)) {
                    start = mid + 1;
                } else {
                    if (A.get(mid) > B) end = mid - 1;
                    else start = mid + 1;
                }
            }
        }
        return -1;
    }

}
