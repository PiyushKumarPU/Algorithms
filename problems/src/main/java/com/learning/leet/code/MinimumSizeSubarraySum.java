package com.learning.leet.code;

public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 11;
        MinimumSizeSubarraySum sum = new MinimumSizeSubarraySum();
        System.out.println(sum.minSubArrayLen(target, nums));
    }

    // O(n)
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int start = 0, end = 0, totalSum = 0, minLength = Integer.MAX_VALUE;

        while (end < nums.length) {
            totalSum += nums[end++];

            while (totalSum >= target) {
                minLength = Math.min(minLength, end - start);
                totalSum -= nums[start++];
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    /*
    Here we will use
    * */
    private int solveNLogN(int s, int[] nums) {
        return 0;
    }
}
