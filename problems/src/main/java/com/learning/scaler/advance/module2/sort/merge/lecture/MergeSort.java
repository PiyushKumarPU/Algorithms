package com.learning.scaler.advance.module2.sort.merge.lecture;

public class MergeSort {

    public int[] sortArray(int[] A) {
        if (A == null || A.length == 1) return A;
        int start = 0, end = A.length - 1, mid = (end + start) / 2;
        return mergeSort(A, start, mid, end);
    }

    private int[] mergeSort(int[] A, int start, int mid, int end) {

        

        return null;
    }


    private int[] mergeSortedArray(int[] nums1, int[] nums2) {
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

}
