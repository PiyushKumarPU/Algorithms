package com.learning.leet.code;


public class MedianOfTwoSortedArrays {

    // https://leetcode.com/problems/median-of-two-sorted-arrays/description/

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] merged = new int[m + n];
        int firstIndex = 0, secondIndex = 0, index = 0;
        while (firstIndex < m && secondIndex < n) {
            int first = nums1[firstIndex];
            int second = nums2[secondIndex];
            if (first <= second) {
                merged[index++] = first;
                firstIndex++;
                if (first == second) {
                    merged[index++] = second;
                    secondIndex++;
                }
            } else {
                merged[index++] = second;
                secondIndex++;
            }
        }

        if (firstIndex < m) {
            while (firstIndex < m) {
                merged[index++] = nums1[firstIndex++];
            }
        }

        if (secondIndex < n) {
            while (secondIndex < n) {
                merged[index++] = nums2[secondIndex++];
            }
        }
        int length = merged.length;
        if (length % 2 != 0) {
            return merged[length / 2];
        } else {
            return (double) (merged[length / 2] + merged[length / 2 - 1]) / 2;
        }
    }
}
