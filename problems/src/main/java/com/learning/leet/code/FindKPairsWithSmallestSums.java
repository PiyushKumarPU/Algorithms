package com.learning.leet.code;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums {

    public List<List<Integer>> kSmallestPairsBF(int[] nums1, int[] nums2, int k) {
        PriorityQueue<SumPair> minHeap = new PriorityQueue<>(Comparator.comparingInt(p -> p.sum));
        for (int value : nums1) {
            for (int value2 : nums2) {
                int currentSum = value + value2;
                SumPair newPair = new SumPair(value, value, currentSum);
                if (minHeap.size() < k) minHeap.add(newPair);
                else if (currentSum < minHeap.peek().sum) {
                    minHeap.poll();
                    minHeap.offer(newPair);
                }
            }
        }
        return minHeap.stream().map(sumPair -> {
            List<Integer> row = new ArrayList<>();
            row.add(sumPair.x);
            row.add(sumPair.y);
            return row;
        }).toList();
    }

}

class SumPair {
    int x, y, sum;

    public SumPair(int x, int y, int sum) {
        this.x = x;
        this.y = y;
        this.sum = sum;
    }
}
