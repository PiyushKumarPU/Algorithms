package com.learning.scaler.advance.module2.sort.merge.lecture;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArray(new int[]{85, 14, 897, 25, 4, 36, 45, 89})));
    }

    public static int[] sortArray(int[] A) {
        if (A == null || A.length == 1) return A;
        mergeSort(A, 0, A.length - 1);
        return A;
    }

    private static void mergeSort(int[] A, int start, int end) {
        if (start == end) return;
        int mid = (end + start) / 2;
        mergeSort(A, start, mid);
        mergeSort(A, mid + 1, end);
        merge(A, start, mid, end);
    }

    private static void merge(int[] arr, int l, int y, int r) {
        int[] result = new int[r - l + 1];
        int currentIndex = 0, index2 = y + 1, index1 = l;
        while (index1 <= y && index2 <= r) {
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
        // copy a result array to the main array
        int start = 0, i = l;
        while (i <= r) {
            arr[i++] = result[start++];
        }
    }

}
