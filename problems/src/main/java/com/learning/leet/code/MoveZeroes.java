package com.learning.leet.code;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i : nums) {
            if (i > 0) nums[index++] = i;
        }
        while (index < nums.length) nums[index++] = 0;
    }

    public void moveZeroes2(int[] nums) {
        int left = 0, right = 0;
        while (left < nums.length) {
            if (nums[left] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right++] = temp;
            }
            left++;
        }
    }

}
