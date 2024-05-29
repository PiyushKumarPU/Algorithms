package com.learning.leet.code;

public class FindPeakElement {

    public int findPeakElementNIteration(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean isPeak = ((i > 0 && nums[i] > nums[i - 1]) || i == 0) &&
                    ((i < nums.length - 1 && nums[i] > nums[i + 1]) || i == nums.length - 1);
            if (isPeak) return i;
        }
        return -1;
    }

    public int findPeakElementlogNIteration(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
