package com.learning.scaler.advance.module4.heap1.lecture;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
Problem Description
    You are given an array A of integers that represent the lengths of ropes.
    You need to connect these ropes into one rope. The cost of joining two ropes equals the sum of
    their lengths.
    Find and return the minimum cost to connect these ropes into one rope.

Problem Constraints
    1 <= length of the array <= 100000
    1 <= A[i] <= 1000

Input Format
    The only argument given is the integer array A.

Output Format
     Returns an integer denoting the minimum cost to connect these ropes into one rope.

Example Input
     1:
        A = [1, 2, 3, 4, 5]
    2:
        A = [5, 17, 100, 11]

Example Output
     1:
        33
     2:
        182

Example Explanation
    1:
         Given array A = [1, 2, 3, 4, 5].
         Connect the ropes in the following manner:
         1 + 2 = 3
         3 + 3 = 6
         4 + 5 = 9
         6 + 9 = 15

         So, the total cost to connect the ropes into one is 3 + 6 + 9 + 15 = 33.
    2:
         Given array A = [5, 17, 100, 11].
         Connect the ropes in the following manner:
         5 + 11 = 16
         16 + 17 = 33
         33 + 100 = 133

         So, total cost  to connect the ropes into one is 16 + 33 + 133 = 182.
* */
public class ConnectRopes {

    public static void main(String[] args) {
        ConnectRopes connectRopes = new ConnectRopes();
        /*System.out.println(connectRopes.solve(new ArrayList<>(List.of(1, 2, 3, 4, 5))));
        System.out.println(connectRopes.solve(new int[]{16, 7, 3, 5, 9, 8, 6, 15}));
        System.out.println(connectRopes.solve1(new ArrayList<>(List.of(16, 7, 3, 5, 9, 8, 6, 15))));*/

        System.out.println(connectRopes.solve(new ArrayList<>(List.of(1, 2, 3, 4, 5))));
        System.out.println(connectRopes.connectingRopes(new ArrayList<>(List.of(1, 2, 3, 4, 5))));

    }

    public int connectingRopes(List<Integer> A) {
        if (A.size() == 1) return A.get(0);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(A);
        int totalCost = 0;
        while (minHeap.size() != 1) {
            int firstMin = !minHeap.isEmpty() ? minHeap.poll() : 0;
            int secondMin = minHeap.isEmpty() ? 0 : minHeap.poll();
            totalCost += (firstMin + secondMin);
            minHeap.add(firstMin + secondMin);
        }
        return totalCost;
    }

    public int solve(ArrayList<Integer> A) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cost = 0;

        // insert all elements in the queue
        for (int x : A) {
            pq.offer(x);
        }

        // keep on removing elements from the queue untill there is one element in the queue
        while (pq.size() != 1) {

            // Take the two ropes with smallest length
            int l1 = pq.poll();
            int l2 = pq.poll();
            // cost of combining these two ropes is l1 + l2.
            cost += l1 + l2;

            // add the newly formed rope of length l1 + l2 to the queue.
            pq.offer(l1 + l2);
        }

        return cost;
    }
}
