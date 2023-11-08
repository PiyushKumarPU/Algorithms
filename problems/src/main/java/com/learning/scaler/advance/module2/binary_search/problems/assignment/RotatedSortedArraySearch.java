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
        int checkElement = A.get(0), start = 0, end = A.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (A.get(mid) == B) return mid;
            if (B >= checkElement) { // target is in part1
                // mid is in part 1 and target is in part1 then move right else move left
                if (A.get(mid) >= checkElement) {
                    if (B < A.get(mid)) start = mid + 1;
                    else end = mid - 1;
                } else {
                    end = mid - 1;
                }
            } else {  // target is in part 2
                if (A.get(mid) < checkElement) {
                    if (B < A.get(mid)) start = mid + 1;
                    else end = mid - 1;
                } else end = mid - 1;
            }
        }
        return -1;
    }

    public int search(final int[] A, int B) {
        int s = 0, e = A.length - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (A[mid] == B) {
                return mid;
            }
            if (B >= A[0]) { //part1
                if (A[mid] >= A[0]) {
                    if (B < A[mid]) {
                        e = mid - 1;
                    } else {
                        s = mid + 1;
                    }
                } else {
                    e = mid - 1;
                }
            } else { //part2
                if (A[mid] <= A[0]) {
                    if (B < A[mid]) {
                        e = mid - 1;
                    } else {
                        s = mid + 1;
                    }
                } else {
                    s = mid + 1;
                }
            }
        }
        return -1;
    }
}
