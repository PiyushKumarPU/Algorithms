package com.learning.scaler.intermediate.intro.arrays.additional;

import java.util.ArrayList;
import java.util.Comparator;

/*
Problem Description
You are given an integer array A. You have to find the second largest element/value in the array or report that no such element exists.


Problem Constraints
1 <= |A| <= 105

0 <= A[i] <= 109



Input Format
The first argument is an integer array A.



Output Format
Return the second largest element. If no such element exist then return -1.



Example Input
Input 1:

 A = [2, 1, 2]
Input 2:

 A = [2]


Example Output
Output 1:

 1
Output 2:

 -1


Example Explanation
Explanation 1:

 First largest element = 2
 Second largest element = 1
Explanation 2:

 There is no second largest element in the array.
* */
public class SecondLargest {

    public int solve(ArrayList<Integer> A) {
        if (A.size() < 2) return -1;
        int max = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (Integer integer : A) {
            max = integer > max ? integer : max;
        }
        for (Integer integer : A) {
            if (integer != max) {
                secondLargest = secondLargest > integer ? secondLargest : integer;
            }
        }
        return secondLargest == Integer.MIN_VALUE ? -1 : secondLargest;
    }

    public int solveUsingSort(ArrayList<Integer> A) {
        if (A.size() < 2) return -1;
        A.sort(Comparator.reverseOrder());
        return A.get(1);
    }
}
