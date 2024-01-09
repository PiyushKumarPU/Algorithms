package com.learning.scaler.advance.module4.heap2.assignment;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KPlacesApart {

    public static void main(String[] args) {

    }

    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i <= B; i++) {
            minHeap.add(A.get(i));
        }
        result.add(minHeap.poll());
        for (int i = B + 1; i < A.size(); i++) {
            minHeap.add(A.get(i));
            result.add(minHeap.poll());
        }
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        return result;
    }

    public int[] solve(int[] A, int B) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int i = 0, n = A.length;
        for (i = 0; i <= Math.min(B, n - 1); i++) {
            pq.offer(A[i]);
        }

        int j = 0;
        while (i < n) {
            if(pq.isEmpty()) break;
            A[j] = pq.poll();
            pq.offer(A[i]);
            i++;
            j++;
        }

        while (j < n) {
            if(pq.isEmpty()) break;
            A[j] = pq.poll();
            j++;
        }
        return A;
    }
}
