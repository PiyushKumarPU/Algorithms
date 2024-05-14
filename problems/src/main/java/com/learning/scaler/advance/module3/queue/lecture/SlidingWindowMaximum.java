package com.learning.scaler.advance.module3.queue.lecture;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] nums = {7, 2, 4};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 2)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.peekFirst()]) deque.removeFirst();
            deque.addLast(i);
        }
        if (!deque.isEmpty())
            result[index++] = nums[deque.peekFirst()];

        for (int i = k; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == i - k) deque.removeFirst();

            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()])
                deque.removeLast();
            deque.addLast(i);

            if (!deque.isEmpty())
                result[index++] = nums[deque.peekFirst()];
        }
        return result;
    }

}
