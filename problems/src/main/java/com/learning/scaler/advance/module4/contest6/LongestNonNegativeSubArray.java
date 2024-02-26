package com.learning.scaler.advance.module4.contest6;


import java.util.ArrayList;

/*
Given an array, return the length of the longest subarray of non-negative integers
*
* */
public class LongestNonNegativeSubArray {

    public int solve(ArrayList<Integer> A) {
        int maxLength = 0, size = A.size();
        for (int i = 0; i < A.size(); i++) {
            int currCount = 0;
            while (i < size && A.get(i) >= 0) {
                currCount++;
                i++;
            }
            maxLength = Math.max(maxLength, currCount);

        }
        return maxLength;
    }
}
