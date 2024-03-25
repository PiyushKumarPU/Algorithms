package com.learning.leet.code;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums == null) return result;
        int start = 0, end = nums.length - 1, startIndex = -1;
        // find first index
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                startIndex = mid;
                end = mid - 1;
            } else if (nums[mid] > target)
                end = mid - 1;
            else start = mid + 1;
        }
        if (startIndex == -1) return result;
        result[0] = startIndex;
        start = startIndex;
        end = nums.length - 1;
        int endIndex = -1;
        // find last index
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                endIndex = mid;
                start = mid + 1;
            } else if (nums[mid] > target)
                end = mid - 1;
            else start = mid + 1;
        }
        result[1] = endIndex;
        return result;
    }
}
