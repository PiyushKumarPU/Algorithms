package com.learning.leet.code;

import java.util.HashSet;
import java.util.PriorityQueue;

public class SmallestNumberInInfiniteSet {


}

class SmallestInfiniteSet {
    PriorityQueue<Integer> minHeap;
    HashSet<Integer> availabilityCheck;

    public SmallestInfiniteSet() {
        minHeap = new PriorityQueue<>();
        availabilityCheck = new HashSet<>();
    }

    public int popSmallest() {
        return minHeap.isEmpty() ? -1 : minHeap.poll();
    }

    public void addBack(int num) {
        if (!availabilityCheck.contains(num)) {
            availabilityCheck.add(num);
            minHeap.add(num);
        }
    }
}
