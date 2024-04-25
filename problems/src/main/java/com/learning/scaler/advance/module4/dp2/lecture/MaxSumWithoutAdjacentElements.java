package com.learning.scaler.advance.module4.dp2.lecture;

import java.util.Arrays;

/*
Problem Description
    Given an array find max subsequence sum
* */
public class MaxSumWithoutAdjacentElements {

    public static void main(String[] args) {
        int[] arr = {2, -1, -4, 5, 6, -1, 4, 7};
        MaxSumWithoutAdjacentElements elements = new MaxSumWithoutAdjacentElements();
        System.out.println(elements.adjacentBF(arr));
        System.out.println(elements.adjacentDp1(arr));
        System.out.println(elements.adjacentDp2(arr));

    }

    public int adjacentBF(int[] A) {
        return adjacentBFRec(A, A.length - 1);
    }

    public int adjacentBFRec(int[] A, int i) {
        if (i < 0) return 0;
        return Math.max((A[i] + adjacentBFRec(A, i - 2)), adjacentBFRec(A, i - 1));
    }

    // Using top down approach
    int[] maxSumArray;
    public int adjacentDp1(int[] A) {
        maxSumArray = new int[A.length + 1];
        Arrays.fill(maxSumArray, -1);
        return adjacentTopDown(A, A.length - 1);
    }

    public int adjacentTopDown(int[] A, int i) {
        if (i < 0) return 0;
        if (maxSumArray[i] != -1) return maxSumArray[i];
        maxSumArray[i] = Math.max((A[i] + adjacentBFRec(A, i - 2)), adjacentBFRec(A, i - 1));
        return maxSumArray[i];
    }

    // using bottom up approach
    public int adjacentDp2(int[] A) {
        int first = Math.max(A[0], 0), second = Math.max(A[1], first);
        for (int i = 2; i < A.length; i++) {
            int current = Math.max((A[i] + first), second);
            first = second;
            second = current;
        }
        return second;
    }


}
