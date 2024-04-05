package com.learning.scaler.advance.module2.sort.merge.lecture;


import com.learning.scaler.intermediate.sorting.basics.lecture.SelectionSort;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
Given two array A[n] and B[m]. Calculate no of pairs such that A[i] > B[j]
* */
public class NoOfPairsI {

    public static void main(String[] args) {
        System.out.println(countPairs(new int[]{8, 10, 15, 3, 6}, new
                int[]{18, 12, 7, 1, 2}));
    }

    public static int countPairs(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int count = 0, arr1Size = arr1.length, arr2Size = arr2.length, i = 0, j = 0;
        while (i < arr1Size && j < arr2Size) {
            while (i < arr1Size && arr1[i] <= arr2[j]) i++;
            count += (arr1Size - i);
            j++;
        }
        return count;
    }
}
