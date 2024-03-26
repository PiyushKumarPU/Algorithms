package com.learning.scaler.advance.module2.sort.merge.lecture;

import java.util.Arrays;

public class MergeTwoSortedArray {

    public static void main(String[] args) {

        //   System.out.println(Arrays.toString(merge(, new int[]{2, 5, 6})));

        System.out.println(Arrays.toString(merge(new int[]{1, 2, 3, 2, 5, 6}, 1, 2, 5)));

    }

    public static int[] merge(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] result = new int[m + n];
        int index1 = 0, index2 = 0, currentIndex = 0;
        while (index1 < m && index2 < n) {
            int first = nums1[index1];
            int second = nums2[index2];
            if (first <= second) {
                result[currentIndex++] = first;
                index1++;
                if (first == second) {
                    result[currentIndex++] = second;
                    index2++;
                }
            } else {
                result[currentIndex++] = second;
                index2++;
            }
        }

        // check for a remaining element of a larger array
        if (index1 < m) {
            while (index1 < m) {
                result[currentIndex++] = nums1[index1];
                index1++;
            }
        }
        if (index2 < n) {
            while (index2 < n) {
                result[currentIndex++] = nums2[index2];
                index2++;
            }
        }
        return result;
    }

    public static int[] merge(int[] arr, int l, int y, int r) {
        int[] result = new int[r - l + 1];
        int currentIndex = 0, index2 = y + 1, index1 = l;
        while (index1 <= y && index2 < r) {
            int first = arr[index1];
            int second = arr[index2];
            if (first <= second) {
                result[currentIndex++] = first;
                index1++;
                if (first == second) {
                    result[currentIndex++] = second;
                    index2++;
                }
            } else {
                result[currentIndex++] = second;
                index2++;
            }
        }

        // check for a remaining element of a larger array
        if (index1 <= y) {
            while (index1 <= y) {
                result[currentIndex++] = arr[index1];
                index1++;
            }
        }
        if (index2 <= r) {
            while (index2 <= r) {
                result[currentIndex++] = arr[index2];
                index2++;
            }
        }
        return result;
    }
}
