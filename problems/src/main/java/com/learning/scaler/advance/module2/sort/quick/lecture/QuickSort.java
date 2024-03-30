package com.learning.scaler.advance.module2.sort.quick.lecture;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 7, 1, 4, 6, 8, 2};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int pivotIndex = partition(arr, start, end);
        quickSort(arr, start, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, end);
    }


    private static int partition(int[] A, int start, int end) {
        int pivot = A[start], i = start + 1, j = end;
        while (i <= j) {
            if (A[i] >= pivot && A[j] < pivot) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i++;
                j--;
            } else if (A[i] < pivot) i++;
            else j--;
        }

        int temp = A[j];
        A[j] = pivot;
        A[start] = temp;
        return j;
    }

}
