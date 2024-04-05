package com.learning.leet.code;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4, 0})));
        System.out.println(Arrays.toString(productExceptSelfBF(new int[]{1, 2, 3, 4, 0})));
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
