package com.learning.leet.code;

import java.util.Arrays;

public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        PartitionEqualSubsetSum sum = new PartitionEqualSubsetSum();
        //System.out.println(sum.canPartition(new int[]{1, 5, 11, 5}));
        //System.out.println(sum.canPartition(new int[]{1, 2, 3, 5}));
        //System.out.println(sum.canPartition(new int[]{100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 99, 97}));
        System.out.println(sum.canPartition(new int[]{6, 1, 5, 12, 18, 10, 4, 17, 13}));
    }

    int[] totalSumDp;

    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int toalSum = 0;
        for (int ele : nums) {
            toalSum += ele;
        }
        if (toalSum % 2 != 0) return false;
        // check if totalSum/2 is possible using dp
        int requiredSum = toalSum / 2;
        totalSumDp = new int[requiredSum + 1];
        Arrays.fill(totalSumDp, -1);
        findSum(nums, requiredSum, nums.length - 1);
        return totalSumDp[requiredSum] != 0;
    }

    private int findSum(int[] nums, int totalSum, int index) {
        if (index < 0 || totalSum < 0) return 0;
        else if (totalSum == 0) return 1;
        else if (totalSumDp[totalSum] != -1) return totalSumDp[totalSum];
        // now we have two options take and dont take
        int currentEle = nums[index];
        int take = currentEle > totalSum ? 0 : (currentEle + findSum(nums, totalSum - currentEle, index - 1));
        int dontTake = findSum(nums, totalSum, index - 1);
        totalSumDp[totalSum] = (take == 1 || dontTake == 1) ? 1 : 0;
        return totalSumDp[totalSum];
    }

}
