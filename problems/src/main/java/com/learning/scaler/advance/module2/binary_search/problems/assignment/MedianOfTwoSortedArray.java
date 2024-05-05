package com.learning.scaler.advance.module2.binary_search.problems.assignment;

import java.util.List;

/*
Problem Description
There are two sorted arrays A and B of sizes N and M respectively.

Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).

NOTE:

The overall run time complexity should be O(log(m+n)).
IF the number of elements in the merged array is even, then the median is the average of (n/2)th and (n/2+1)th element. For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5.


Problem Constraints
1 <= N + M <= 2*106



Input Format
The first argument is an integer array A of size N.
The second argument is an integer array B of size M.



Output Format
Return a decimal value denoting the median of two sorted arrays.



Example Input
Input 1:

 A = [1, 4, 5]
 B = [2, 3]
Input 2:

 A = [1, 2, 3]
 B = [4]


Example Output
Output 1:

 3.0
Output 2:

 2.5


Example Explanation
Explanation 1:

 The median of both the sorted arrays will be 3.0.
Explanation 2:

 The median of both the sorted arrays will be (2+3)/2 = 2.5.
* */
public class MedianOfTwoSortedArray {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(List.of(-37, -9, 10, 19), List.of(-29, 18, 46)));

    }


    public static double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        // we did this to perform search on smallest list to keep smaller search space
        if (a.isEmpty() || b.isEmpty()) {
            List<Integer> finalList = a.isEmpty() ? b : a;
            int size = Math.max(a.size(), b.size()), mid = (size - 1) / 2;
            if (size % 2 == 0) {
                return (double) (finalList.get(mid) + finalList.get(mid + 1)) / 2;
            } else {
                return finalList.get(mid);
            }

        }
        if (b.size() < a.size()) return findMedianSortedArrays(b, a);
        boolean isBalancedResult = ((a.size() + b.size()) % 2) == 0;
        int partitionSize = (a.size() + b.size() + 1) / 2, start = 0, end = a.size();
        while (start <= end) {
            int cntA = (start + end) / 2, cntB = partitionSize - cntA;
            int l1 = cntA > 0 ? a.get(cntA - 1) : Integer.MIN_VALUE;
            int l2 = cntB > 0 ? b.get(cntB - 1) : Integer.MIN_VALUE;
            int r1 = cntA < a.size() ? a.get(cntA) : Integer.MAX_VALUE;
            int r2 = cntB < b.size() ? b.get(cntB) : Integer.MAX_VALUE;
            if (l1 <= r2 && l2 <= r1) {
                return isBalancedResult ? (double) (Math.max(l1, l2) + Math.min(r1, r2)) /2 : Math.max(l1, l2);
            } else if (l1 > r2) {
                end = cntA - 1;
            } else {
                start = cntA + 1;
            }
        }
        return 0;
    }

}
