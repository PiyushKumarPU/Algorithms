package com.learning.leet.code;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/sliding-window-maximum/description/
public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(maxSlidingWindow(arr, 3)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 1 || k < 1) return null;
        int size = nums.length, index = 0, removeIndex = 0;
        int[] result = new int[size - k + 1];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < k; i++) maxHeap.offer(nums[i]);
        result[index++] = maxHeap.peek();
        for (int i = k; i < size; i++) {
            maxHeap.remove(nums[removeIndex++]);
            maxHeap.offer(nums[i]);
            result[index++] = maxHeap.peek();
        }
        return result;
    }


}
