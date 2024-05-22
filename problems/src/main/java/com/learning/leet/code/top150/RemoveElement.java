package com.learning.leet.code.top150;

// https://leetcode.com/problems/remove-element/description/?envType=study-plan-v2&envId=top-interview-150
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int[] result = new int[nums.length];
        int index = 0, count = 0;
        for (int num : nums) {
            if (num != val) {
                result[index++] = num;
                count++;
            }
        }
        if (count >= 0) System.arraycopy(result, 0, nums, 0, count);
        return count;
    }
}
