package com.learning.leet.code;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayII {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1};
        int count = removeDuplicates(nums);
        System.out.println(count);
        System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {
        //if (nums.length < 2) return nums.length;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }

    public int removeDuplicates1(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;

    }

}
