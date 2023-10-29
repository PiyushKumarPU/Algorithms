package com.learning.practise.scaler.advance.dsa.array3;

import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextPermutation(new int[]{1, 2, 3})));

        System.out.println(Arrays.toString(nextPermutation(new int[]{3, 2, 1})));
    }

    public static int[] nextPermutation(int[] A) {
        int size = A.length, i, j;
        for (i = size - 2; i >= 0; i--) {
            if (A[i] < A[i + 1]) {
                break;
            }
        }

        if (i < 0) {
            reverse(A, 0, A.length - 1);
        } else {
            for (j = size - 1; j > i; j--) {
                if (A[j] > A[i]) {
                    break;
                }
            }
            swap(A, i, j);
            reverse(A, i + 1, A.length - 1);
        }
        return A;
    }

    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
