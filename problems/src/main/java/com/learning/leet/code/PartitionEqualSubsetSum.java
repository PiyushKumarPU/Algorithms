package com.learning.leet.code;

import java.util.Arrays;

public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        PartitionEqualSubsetSum sum = new PartitionEqualSubsetSum();
        System.out.println(sum.canPartition(new int[]{28, 4, 26, 1, 36, 42, 10, 32, 27}));
    }

    int[] totalSumDp;

    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int totalSum = 0;

        // Calculate the total sum of the array
        for (int ele : nums) {
            totalSum += ele;
        }

        // If the total sum is odd, it's not possible to partition into two equal subsets
        if (totalSum % 2 != 0) return false;

        // We are looking for a subset with a sum equal to half of the total sum
        int requiredSum = totalSum / 2;

        // Initialize the dp array
        boolean[] dp = new boolean[requiredSum + 1];
        dp[0] = true; // Base case: A subset sum of 0 is always achievable (empty subset)

        // Fill the dp array
        for (int num : nums) {
            // Traverse from the back to avoid overwriting results from the same iteration
            for (int j = requiredSum; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        // The result is whether a subset sum equal to requiredSum is achievable
        return dp[requiredSum];
    }
}
