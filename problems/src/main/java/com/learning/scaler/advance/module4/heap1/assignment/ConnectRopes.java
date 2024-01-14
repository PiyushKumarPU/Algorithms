package com.learning.scaler.advance.module4.heap1.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
Problem Description
    You are given an array A of integers that represent the lengths of ropes.
    You need to connect these ropes into one rope. The cost of joining two ropes equals the sum of their lengths.
    Find and return the minimum cost to connect these ropes into one rope.

Problem Constraints
    1 <= length of the array <= 100000
    1 <= A[i] <= 1000

Input Format
    The only argument given is the integer array A.

Output Format
    Return an integer denoting the minimum cost to connect these ropes into one rope.

Example Input
    Input 1:
        A = [1, 2, 3, 4, 5]
    Input 2:
        A = [5, 17, 100, 11]

Example Output
    Output 1:
        33
    Output 2:
        182

Example Explanation
    Explanation 1:
     Given array A = [1, 2, 3, 4, 5].
     Connect the ropes in the following manner:
     1 + 2 = 3
     3 + 3 = 6
     4 + 5 = 9
     6 + 9 = 15

     So, total cost  to connect the ropes into one is 3 + 6 + 9 + 15 = 33.
    Explanation 2:
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
        System.out.println(connectRopes.solve(new ArrayList<>(List.of(1, 2, 3, 4, 5))));
        System.out.println(connectRopes.solve(new int[]{16, 7, 3, 5, 9, 8, 6, 15}));
        System.out.println(connectRopes.solve1(new ArrayList<>(List.of(16, 7, 3, 5, 9, 8, 6, 15))));

    }

    public int solve(ArrayList<Integer> A) {
        if (A.size() == 1) return A.get(0);
        int totalCost = 0;
        ArrayList<Integer> heap = constructHeap(A);
        while (heap.size() > 1) {
            int sum = heap.get(0) + heap.get(1);
            totalCost += sum;
            heap.add(sum);
            heap = constructHeap(new ArrayList<>(heap.subList(2, heap.size())));
        }
        return totalCost;
    }

    private ArrayList<Integer> constructHeap(ArrayList<Integer> input) {
        if (input == null || input.size() == 1) return input;
        int start = (input.size() - 2) / 2;
        for (int i = start; i >= 0; i--) {
            heapify(input, i);
        }
        return input;
    }

    public void heapify(ArrayList<Integer> A, int i) {
        int min = i, size = A.size();
        int l_c = (2 * min) + 1;
        int r_c = (2 * min) + 2;

        if (l_c < size && A.get(l_c) < A.get(min))
            min = l_c;

        if (r_c < size && A.get(r_c) < A.get(min))
            min = r_c;

        if (min != i) {
            int temp = A.get(min);
            A.set(min, A.get(i));
            A.set(i, temp);
            heapify(A, min);
        }

    }

    public int solve(int[] A) {
        int ans = 0;
        int size = A.length;
        //building heap
        for (int i = ((A.length) / 2) - 1; i >= 0; i--) {
            heapify(i, size, A);
        }


        while (size > 1) {
            int a = A[0];
            A[0] = A[size - 1];
            size--;
            heapify(0, size, A);
            int b = A[0];
            int c = a + b;
            A[0] = c;
            ans += c;
            heapify(0, size, A);
        }
        return ans;
    }


    public void heapify(int i, int size, int[] A) {
        int min = i;
        int l_c = (2 * min) + 1;
        int r_c = (2 * min) + 2;

        if (l_c < size && A[l_c] < A[min])
            min = l_c;

        if (r_c < size && A[r_c] < A[min])
            min = r_c;

        if (min != i) {
            int temp = A[min];
            A[min] = A[i];
            A[i] = temp;
            heapify(min, size, A);
        }

    }


    public int solve1(ArrayList<Integer> A) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cost = 0;

        // insert all elements in the queue
        for (int x : A) {
            pq.offer(x);
        }

        // keep on removing elements from the queue until there is one element in the queue
        while (!pq.isEmpty()) {
            int l1 = pq.poll();
            int l2 = !pq.isEmpty() ? pq.poll() : 0;
            cost += l1 + l2;
            pq.offer(l1 + l2);
        }
        return cost;
    }
}
