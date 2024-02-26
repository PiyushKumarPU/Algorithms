package com.learning.practise.scaler.advance.dsa.array;

import java.util.List;

public class FindKthSmallestElement {

    public static void main(String[] args) {

    }

    /*
     * Edge case
     *   a. Array length is less than k
     *   b. All elements are same
     * */
    public int findKthSmallestElement(List<Integer> arr, int k) {
        if (arr.size() < k) return 0;
        int currentMax = 0, size = arr.size(), index = 0;
        while (k > 0) {
            int localMax = 0, localMaxIndex = 0, lastIndex = size - index;
            for (int i = 0; i < lastIndex; i++) {
                if (arr.get(i) > localMax) {
                    localMax = arr.get(i);
                    localMaxIndex = i;
                }
            }
            if (localMaxIndex != lastIndex - 1) {
                arr.set(localMaxIndex, arr.get(lastIndex - 1));
                arr.set(lastIndex, localMax);
            }
            currentMax = localMax;
            k--;
            index++;
        }
        return currentMax;
    }

    public int findKthSmallestElement(int[] nums, int k) {
        if (nums.length < k) return 0;
        int currentMax = 0, size = nums.length, index = 0;
        while (k > 0) {
            int localMax = Integer.MIN_VALUE, localMaxIndex = 0, lastIndex = size - index;
            for (int i = 0; i < lastIndex; i++) {
                if (nums[i] > localMax) {
                    localMax = nums[i];
                    localMaxIndex = i;
                }
            }
            if (localMaxIndex != lastIndex - 1) {
                nums[localMaxIndex] = nums[lastIndex - 1];
                nums[lastIndex - 1] = localMax;
            }
            currentMax = localMax;
            k--;
            index++;
        }
        return currentMax;
    }
}
