package com.learning.leet.code;

public class FindMinimumRotatedSortedArray {

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        // check if rotated or not if not return first element
        if (nums[0] < nums[nums.length - 1]) return nums[0];
        // use bs to find minimum
        int first = nums[0], start = 0, end = nums.length - 1, ans = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= first) {
                start = mid + 1;
            } else {
                ans = nums[mid];
                end = mid - 1;
            }
        }
        return ans;
    }
}
