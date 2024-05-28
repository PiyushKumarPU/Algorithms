package com.learning.leet.code;

public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 11;
        MinimumSizeSubarraySum sum = new MinimumSizeSubarraySum();
        System.out.println(sum.minSubArrayLen(target, nums));
    }

    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0 || target <= 0) return 0;
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = nums[i] + prefixSum[i - 1];
        }
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                int currentSum = prefixSum[j] - (i > 0 ? prefixSum[i - 1] : 0);
                if (currentSum >= target) minLength = Math.min(minLength, (j - i + 1));
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
