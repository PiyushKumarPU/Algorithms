package com.learning.practise.scaler.self.array;

public class MaxSubArray {

    public static void main(String[] args) {
        int[] C = new int[]{8,7};
        int A = 2;
        int B = 4;
        System.out.println(maxSubarray(A,B,C));
    }

    public static int maxSubarray(int A, int B, int[] C) {
        int result = Integer.MIN_VALUE;
        for(int i =0; i < A; i ++){
            int currentSum = 0;
            for(int j = i; j < A; j++){
                currentSum += C[j];
                if(currentSum <= B && currentSum > result) result = currentSum;
            }

        }
        return result;
    }
}
