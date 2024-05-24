package com.learning.leet.code;

import java.util.Arrays;

// https://leetcode.com/problems/merge-sorted-array/?envType=study-plan-v2&envId=top-interview-150
public class MergeSortedArray {

    public static void main(String[] args) {
        MergeSortedArray sortedArray = new MergeSortedArray();
        int[] nums1 = {1, 2, 4, 5, 6, 0};
        int[] nums2 = {3};
        sortedArray.merge(nums1, 5, nums2, 1);
        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) nums1[0] = nums2[0];
        else if (n == 0) return;
        int[] result = new int[m + n];
        int index = 0, firstIndex = 0, secondIndex = 0;
        while (firstIndex < m || secondIndex < n) {
            int first = firstIndex < m ? nums1[firstIndex] : Integer.MAX_VALUE;
            int second = secondIndex < n ? nums2[secondIndex] : Integer.MAX_VALUE;
            if (first > second) {
                result[index++] = second;
                secondIndex++;
            } else if (second > first) {
                result[index++] = first;
                firstIndex++;
            } else {
                result[index++] = first;
                result[index++] = second;
                firstIndex++;
                secondIndex++;
            }
        }
        System.arraycopy(result, 0, nums1, 0, result.length);
    }
}
