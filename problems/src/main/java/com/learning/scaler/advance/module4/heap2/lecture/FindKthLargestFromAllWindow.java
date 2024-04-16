package com.learning.scaler.advance.module4.heap2.lecture;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FindKthLargestFromAllWindow {

    public static void main(String[] args) {
        int[] arr = {10, 18, 7, 5, 16, 19, 3};
        System.out.println(Arrays.toString(kthLargestInAllWindows(arr, 3)));
    }

    public static int[] kthLargestInAllWindows(int[] arr, int k) {
        int[] result = new int[arr.length - k + 1];
        int index = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) minHeap.offer(arr[i]);
        result[index++] = minHeap.peek();
        for (int i = k; i < arr.length; i++) {
            if (arr[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(arr[i]);
            }
            result[index++] = minHeap.peek();
        }
        return result;
    }
}
