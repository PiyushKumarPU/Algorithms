package com.learning.scaler.advance.module2.sort.quick.lecture;


import java.util.Arrays;
import java.util.stream.StreamSupport;

/*
Given an integer array, consider first element as pivot elemenet. Rearrange the elements in such a way that for all
    i:
        if A[i] <= p then it should present on left side
        if A[i] > p then it should present on right side

    Note: Given that all elements are distinct.
* */
public class PivotElement {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(pivot(new int[]{56, 77, 32, 11, 14, 97, 88, 1, 3, 6, 3, 17})));
    }

    public static int[] pivot(int[] A) {
        if (A == null || A.length == 1) return A;
        int start = 1, end = A.length - 1, pivot = A[0];
        while (start <= end) {
            if (A[start] > pivot && A[end] <= pivot) {
                int temp = A[start];
                A[start] = A[end];
                A[end] = temp;
                start++;
                end--;
            } else if (A[start] <= pivot) start++;
            else end--;
        }
        A[0] = A[end];
        A[end] = pivot;
        return A;
    }
}
