package com.learning.scaler.advance.module1.array2d.lecture;


/*
 Problem Description
        Given a binary sorted matrix A of N * N. Find row with max number of 1
* */
public class MaxNumberOf1sInRow {

    public static void main(String[] args) {
        int[][] A = {{0, 0, 1, 1, 1}, {0, 0, 1, 1, 1}, {0, 1, 1, 1, 1}, {1, 1, 1, 1, 1}};
        System.out.println(maxNoOf1s(A));
    }

    public static int maxNoOf1s(int[][] A) {
        int count = 0, start = 0, end = A[0].length - 1;
        while (start < A.length && end >= 0) {
            int current = A[start][end];
            if (current == 1) {
                count++;
                end--;
            } else {
                start++;
            }
        }
        return count;
    }
}
