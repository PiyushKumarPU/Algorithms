package com.learning.practise.scaler.self.array;

public class CountingSubArrays {

    public static void main(String[] args) {
        System.out.println(solve(new int[]{1, 11, 2, 3, 15}, 10));
    }

    public static int solve(int[] A, int B) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            int currentSum = 0;
            for (int j = i; j < A.length; j++) {
                currentSum += A[j];
                if (currentSum < B) count++;
            }
        }
        return count;
    }
}
