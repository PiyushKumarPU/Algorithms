package com.learning.scaler.advance.module4.heap2.lecture;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class HeapSort {

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        System.out.println(heapSort.sortUsingMinHeap(List.of(3, 1, 9, 4, 6, 2, 10, 5)));
        System.out.println(heapSort.sortUsingMaxHeap(new ArrayList<>(List.of(3, 1, 9, 4, 6, 2, 10, 5))));
    }

    public List<Integer> sortUsingMinHeap(List<Integer> A) {
        List<Integer> result = new ArrayList<>(A.size());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.addAll(A);
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        return result;
    }

    public ArrayList<Integer> sortUsingMaxHeap(ArrayList<Integer> A) {
        int size = A.size();
        while (size > 0) {
            A = heapify(A, size);
            int current = A.get(0);
            int last = A.get(size - 1);
            A.set(size - 1, current);
            A.set(0, last);
            size--;
        }
        return A;
    }

    public ArrayList<Integer> heapify(ArrayList<Integer> A, int size) {
        int start = (size - 2) / 2;
        for (int index = start; index >= 0; index--) {
            int current = A.get(index), rightIndex = 2 * index + 2, leftIndex = 2 * index + 1,
                    left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
            int curMin = current;
            if (leftIndex < size) {
                left = A.get(leftIndex);
                curMin = Math.min(curMin, left);
            }
            if (rightIndex < size) {
                right = A.get(rightIndex);
                curMin = Math.min(curMin, right);
            }
            if (curMin == current) break;
            else if (curMin == left) {
                A.set((2 * index + 1), current);
                A.set(index, left);

            } else {
                A.set((2 * index + 2), current);
                A.set(index, right);
            }
        }
        return A;
    }
}

