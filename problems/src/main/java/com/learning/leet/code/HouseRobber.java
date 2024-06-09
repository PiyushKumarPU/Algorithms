package com.learning.leet.code;

import java.util.Arrays;

public class HouseRobber {

    int[] money;

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        money = new int[nums.length];
        Arrays.fill(money, -1);
        money[0] = nums[0];
        return calculateMoney(nums, nums.length - 1);
    }

    private int calculateMoney(int[] nums, int index) {
        if (index < 0) return 0;
        if (money[index] != -1) return money[index];
        int take = nums[index] + calculateMoney(nums, index - 2);
        int dontTake = calculateMoney(nums, index - 1);
        money[index] = Math.max(take, dontTake);
        return money[index];
    }

}
