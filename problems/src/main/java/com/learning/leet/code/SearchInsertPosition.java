package com.learning.leet.code;

public class SearchInsertPosition {

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5));
    }

    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int length = nums.length;
        if (target < nums[0]) return 0;
        else if (target > nums[length - 1]) return length;
        // use bs to find appropriate index
        int start = 0, end = length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) {
                if (mid < nums.length - 1 && target < nums[mid + 1]) return mid + 1;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return 0;
    }
}
