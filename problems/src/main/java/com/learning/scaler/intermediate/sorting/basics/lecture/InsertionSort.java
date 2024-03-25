package com.learning.scaler.intermediate.sorting.basics.lecture;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new InsertionSort().insertionSort(new int[]{5, 2, 9, 2, 1})));
    }

    public int[] insertionSort(int[] A) {
        for (int i = 1; i < A.length; i++) {
            int j = i - 1, current = A[i];
            while (j >= 0 && A[j] > current) {
                A[j + 1] = A[j];
                j--;
            }
            A[j + 1] = current;
        }
        return A;
    }
}
