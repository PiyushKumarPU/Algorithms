package com.learning.scaler.intermediate.carry_forwar_contri.assignment;

import com.learning.scaler.advance.module3.ListNode;

import java.util.ArrayList;
import java.util.List;

/*
Problem Description
Given an array A, find the size of the smallest subarray such that it contains at least one occurrence of the maximum value of the array

and at least one occurrence of the minimum value of the array.



Problem Constraints
1 <= |A| <= 2000



Input Format
First and only argument is vector A



Output Format
Return the length of the smallest subarray which has at least one occurrence of minimum and maximum element of the array



Example Input
Input 1:

A = [1, 3, 2]
Input 2:

A = [2, 6, 1, 6, 9]


Example Output
Output 1:

 2
Output 2:

 3


Example Explanation
Explanation 1:

 Take the 1st and 2nd elements as they are the minimum and maximum elements respectievly.
Explanation 2:

 Take the last 3 elements of the array.
* */
public class ClosestMinMax {

    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<>(List.of(1, 1))));
    }

    public static int solve(ArrayList<Integer> A) {
        if (A.size() == 1) return 1;
        int length = Integer.MAX_VALUE, minValue = Integer.MAX_VALUE, maxValue = Integer.MIN_VALUE, minIndex = -1, maxIndex = -1;
        for (Integer integer : A) {
            minValue = Math.min(minValue, integer);
            maxValue = Math.max(maxValue, integer);
        }
        if (minValue == maxValue) return 1;
        for (int i = 0; i < A.size(); i++) {
            int current = A.get(i);
            if (current == minValue) minIndex = i;
            if (current == maxValue) maxIndex = i;
            if (minIndex >= 0 && maxIndex >= 0) {
                length = Math.min(length, (Math.abs(minIndex - maxIndex) + 1));
            }
        }
        return length;
    }
}
