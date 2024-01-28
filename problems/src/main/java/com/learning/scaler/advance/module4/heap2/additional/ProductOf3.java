package com.learning.scaler.advance.module4.heap2.additional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
Problem Description
    Given an integer array A of size N.
    You have to find the product of the three largest integers in array A from range 1 to i, where i goes from 1 to N.
    Return an array B where B[i] is the product of the largest 3 integers in range 1 to i in array A. If i < 3, then the integer at index i in B should be -1.

Problem Constraints
    1 <= N <= 10^5
    0 <= A[i] <= 10^3

Input Format
    First and only argument is an integer array A.

Output Format
    Return an integer array B.
    B[i] denotes the product of the largest 3 integers in range 1 to i in array A.

Example Input
    Input 1:
        A = [1, 2, 3, 4, 5]
    Input 2:
        A = [10, 2, 13, 4]

Example Output
    Output 1:
        [-1, -1, 6, 24, 60]
    Output 2:
        [-1, -1, 260, 520]

Example Explanation
    Explanation 1:
         For i = 1, ans = -1
         For i = 2, ans = -1
         For i = 3, ans = 1 * 2 * 3 = 6
         For i = 4, ans = 2 * 3 * 4 = 24
         For i = 5, ans = 3 * 4 * 5 = 60

         So, the output is [-1, -1, 6, 24, 60].

    Explanation 2:
         For i = 1, ans = -1
         For i = 2, ans = -1
         For i = 3, ans = 10 * 2 * 13 = 260
         For i = 4, ans = 10 * 13 * 4 = 520

         So, the output is [-1, -1, 260, 520].
* */
public class ProductOf3 {

    public static void main(String[] args) {

        System.out.println(new ProductOf3().solve(new ArrayList<>(List.of(1, 2, 3, 4, 5))));
        System.out.println(new ProductOf3().solve(new ArrayList<>(List.of(10, 2, 13, 4))));

    }

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        if (A == null || A.isEmpty()) return new ArrayList<>(List.of(0));
        ArrayList<Integer> result = new ArrayList<>();
        if (A.size() < 3) {
            for (int i = 0; i < A.size(); i++) {
                result.add(-1);
            }
            return result;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.addAll(A.subList(0, 3));
        result.addAll(List.of(-1, -1));
        result.add(findHeapMul(minHeap));
        for (int i = 3; i < A.size(); i++) {
            minHeap.add(A.get(i));
            minHeap.poll();
            result.add(findHeapMul(minHeap));
        }
        return result;
    }

    public int[] solve(int[] A) {
        // n is the size of the vector
        int n = A.length;
        // Initialize an answer vector
        ArrayList<Integer> ans = new ArrayList<>();
        // Initialize a priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < n; i++) {

            // Add element in priority queue
            pq.offer(A[i]);

            // Append -1 to the answer as number of elements are < 3.
            if (i < 2) {
                ans.add(-1);
            } else {
                //take 3 maximum elements from queue.
                int a = pq.poll();
                int b = pq.poll();
                int c = pq.poll();

                //add all these numbers back to queue
                pq.offer(a);
                pq.offer(b);
                pq.offer(c);

                //append the product to answer
                ans.add(a * b * c);
            }
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++)
            res[i] = ans.get(i);
        return res;
    }

    private int findHeapMul(PriorityQueue<Integer> minHeap) {
        return minHeap.stream().reduce(1, (a, b) -> a * b);
    }
}

