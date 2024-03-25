package com.learning.scaler.intermediate.sorting.basics.lecture;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SelectionSort().selectionSort(new int[]{5, 2, 9, 2, 1})));
    }


    public int[] selectionSort(int[] A) {
        for (int i = 0; i < A.length; i++) {
            int currentMin = Integer.MAX_VALUE, currentMinIndex = -1;
            for (int j = i; j < A.length; j++) {
                if (A[j] < currentMin) {
                    currentMin = A[j];
                    currentMinIndex = j;
                }
            }
            int temp = A[i];
            A[i] = A[currentMinIndex];
            A[currentMinIndex] = temp;
        }
        return A;
    }
}
