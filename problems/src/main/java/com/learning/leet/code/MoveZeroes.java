package com.learning.leet.code;

import java.util.Arrays;

public class MoveZeroes {

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        moveZeroes2(arr);
        System.out.println(Arrays.toString(arr));
    }

    // easy solution
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i : nums) {
            if (i > 0) nums[index++] = i;
        }
        while (index < nums.length) nums[index++] = 0;
    }


    public static void moveZeroes2(int[] nums) {
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
