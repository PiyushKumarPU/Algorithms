package com.learning.leet.code;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        int k = 4;
        new RotateArray().rotate(arr, k);
        System.out.println(Arrays.toString(arr));


    }

    public void rotate(int[] nums, int k) {
        if (nums == null) return;
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
