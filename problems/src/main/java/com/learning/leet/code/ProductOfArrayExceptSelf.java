package com.learning.leet.code;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelfPrefixSum(new int[]{1, 2, 3, 4})));
        // System.out.println(Arrays.toString(productExceptSelfBF(new int[]{1, 2, 3, 4, 0})));
    }

    public static int[] productExceptSelfBF(int[] nums) {
        if (nums == null) return null;
        else if (nums.length == 1) return new int[]{0};
        long totalProd = 1;
        for (int num : nums) totalProd *= num;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (totalProd / nums[i]);
        }
        return nums;
    }

    public static int[] productExceptSelfPrefixSum(int[] nums) {
        int len = nums.length;
        int[] leftMultipliers = new int[len];
        int[] rightMultipliers = new int[len];

        leftMultipliers[0] = 1;
        rightMultipliers[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            leftMultipliers[i] = leftMultipliers[i - 1] * nums[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            rightMultipliers[i] = rightMultipliers[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < len; i++) {
            nums[i] = leftMultipliers[i] * rightMultipliers[i];
        }
        return nums;
    }

    public static int[] productExceptSelf(int[] nums) {
        if (nums == null) return null;
        int size = nums.length;
        if (size == 1) return new int[]{0};
        int[] result = new int[size];
        int temp = 1;
        for (int i = 0; i < size; i++) {
            result[i] = temp;
            temp *= nums[i];
        }
        temp = 1;
        for (int i = size - 1; i >= 0; i--) {
            result[i] *= temp;
            temp *= nums[i];
        }
        return result;
    }
}
