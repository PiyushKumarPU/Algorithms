package com.learning.leet.code;


import java.util.List;

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m > n)
            return findMedianSortedArrays(nums2, nums1);
        int total = m + n, maxSelection = (total + 1) / 2, start = 0, end = m;
        double result = 0.0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int remaining = maxSelection - mid;

            // get the four points around possible median
            int left1 = (mid > 0) ? nums1[mid - 1] : Integer.MIN_VALUE;
            int right1 = (mid < m) ? nums1[mid] : Integer.MAX_VALUE;
            int left2 = (remaining > 0) ? nums2[remaining - 1] : Integer.MIN_VALUE;
            int right2 = (remaining < n) ? nums2[remaining] : Integer.MAX_VALUE;

            // partition is correct
            if (Math.max(left1, left2) <= Math.min(right1, right2)) {
                result = (total % 2 == 0) ? (Math.max(left1, left2) + Math.min(right1, right2)) /
                        2.0 : Math.max(left1, left2);
                break;
            }
            // partition is wrong (update left/right pointers)
            else if (left1 > right2) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }




}
