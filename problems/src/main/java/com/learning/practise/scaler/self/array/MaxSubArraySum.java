package com.learning.practise.scaler.self.array;

public class MaxSubArraySum {

    public static void main(String[] args) {
        maxSubArraySum(new int[]{4,-1});
    }

    public static void maxSubArraySum(int[] ints) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < ints.length; i++) {
            for (int j = i; j < ints.length; j++) {
                int sum = ints[i];
                for (int index = i+1; index <= j; index++) {
                    sum+=ints[index];
                }
                maxSum = Math.max(maxSum,sum);
            }
        }
        System.out.println(maxSum);
    }
}
