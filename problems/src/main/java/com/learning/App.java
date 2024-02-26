package com.learning;

import java.util.Arrays;

/**
 * Hello world!
 */
public class App {

    /*public static void main(String[] args) {
        int[] nums1 = {1, 3}, nums2 = {2};
        int j = 0, k = 0;
        int[] res = new int[nums1.length + nums2.length];
        int s = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (k < nums2.length && j < nums1.length && (nums1[j] < nums2[k])) {
                res[s] = nums1[j];
                s++;
                j++;
            } else if (k < nums2.length && j < nums1.length && (nums2[k] < nums1[j])) {
                res[s] = nums1[k];
                s++;
                k++;
            }
        }
        while (j < nums1.length) {
            // s++;
            res[s] = nums1[j];
            j++;
            s++;
        }
        while (k < nums2.length) {
            //s++;
            res[s] = nums2[k];
            k++;
            s++;
        }
        Arrays.stream(res).forEach(System.out::print);
    }*/

    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeSortedArray(new int[]{1, 3}, new int[]{3})));
    }

    public static int[] mergeSortedArray(int[] A, int[] B) {
        int[] res = new int[A.length + B.length];
        int first = 0, second = 0, firstIndex = 0, secondIndex = 0, resultIndex = 0;
        for (int i = 0; i < Math.min(A.length, B.length); i++) {
            first = firstIndex < A.length ? A[firstIndex] : Integer.MAX_VALUE;
            second = secondIndex < B.length ? B[secondIndex] : Integer.MAX_VALUE;
            if (first < second) {
                res[resultIndex++] = first;
                firstIndex++;
            } else {
                res[resultIndex++] = second;
                secondIndex++;
            }
        }

        while (firstIndex < A.length) {
            res[resultIndex++] = A[firstIndex++];
        }
        while (secondIndex < B.length) {
            res[resultIndex++] = B[secondIndex++];
        }

        return res;
    }
}
