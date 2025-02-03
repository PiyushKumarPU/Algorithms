package com.learning.leet.code;

public class MaximumSubarray {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public static int maxSubArray(int[] nums) {
        int currentMax = 0, totalMax = Integer.MIN_VALUE;
        for (int num : nums) {
            currentMax += num;
            totalMax = Math.max(currentMax, totalMax);
            if (currentMax < 0) currentMax = 0;
        }
        return totalMax;
    }

}
