package com.learning.scaler.advance.module4.heap2.assignment;

import java.util.ArrayList;
import java.util.PriorityQueue;

/*
Problem Description
    N people having different priorities are standing in a queue.
    The queue follows the property that each person is standing at most B places away from its position
    in the sorted queue.
    Your task is to sort the queue in the increasing order of priorities.
    NOTE:
        No two persons can have the same priority.
        Use the property of the queue to sort the queue with complexity O(NlogB).

Problem Constraints
    1 <= N <= 100000
    0 <= B <= N

Input Format
    The first argument is an integer array A representing the priorities and initial order of N persons.
    The second argument is an integer B.

Output Format
    Return an integer array representing the sorted queue.

Example Input
Input 1:
    A = [1, 40, 2, 3]
    B = 2
Input 2:
    A = [2, 1, 17, 10, 21, 95]
    B = 1


Example Output
Output 1:

 [1, 2, 3, 40]
Output 2:

 [1, 2, 10, 17, 21, 95]


Example Explanation
Explanation 1:

 Given array A = [1, 40, 2, 3]
 After sorting, A = [1, 2, 3, 40].
 We can see that difference between initial position of elements amd the final position <= 2.
Explanation 2:

 After sorting, the array becomes [1, 2, 10, 17, 21, 95].
* */
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
