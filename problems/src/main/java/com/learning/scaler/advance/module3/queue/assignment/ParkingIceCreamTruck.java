package com.learning.scaler.advance.module3.queue.assignment;


import java.util.*;

/*
Problem Description
    Imagine you're an ice cream truck driver in a beach side town. The beach is divided into several sections,
    and each section has varying numbers of beachgoers wanting ice cream given by the array of integers A.
    For simplicity, let's say the beach is divided into 8 sections. One day, you note down the number of
    potential customers in each section: [5, 12, 3, 4, 8, 10, 2, 7]. This means there are 5 people in the
    first section, 12 in the second, and so on.
    You can only stop your truck in B consecutive sections at a time because of parking restrictions.
    To maximize sales, you want to park where the most customers are clustered together.
    For all B consecutive sections, identify the busiest stretch to park your ice cream truck and serve
    the most customers. Return an array C, where C[i] is the busiest section in each of the B consecutive sections.
    Refer to the given example for clarity.
    NOTE: If B > length of the array, return 1 element with the max of the array.

Problem Constraints
    1 <= |A|, B <= 10^6

Input Format
    The first argument given is the integer array A.
    The second argument given is the integer B.

Output Format
    Return an array C, where C[i] is the maximum value from A[i] to A[i+B-1].

Example
    Input 1:
         A = [1, 3, -1, -3, 5, 3, 6, 7]
         B = 3
    Input 2:
         A = [1, 2, 3, 4, 2, 7, 1, 3, 6]
         B = 6


Example
    Output 1:
         [3, 3, 5, 5, 6, 7]
    Output 2:
         [7, 7, 7, 7]


Example
    Explanation 1:
         Window position     | Max
         --------------------|-------
         [1 3 -1] -3 5 3 6 7 | 3
         1 [3 -1 -3] 5 3 6 7 | 3
         1 3 [-1 -3 5] 3 6 7 | 5
         1 3 -1 [-3 5 3] 6 7 | 5
         1 3 -1 -3 [5 3 6] 7 | 6
         1 3 -1 -3 5 [3 6 7] | 7
    Explanation 2:
         Window position     | Max
         --------------------|-------
         [1 2 3 4 2 7] 1 3 6 | 7
         1 [2 3 4 2 7 1] 3 6 | 7
         1 2 [3 4 2 7 1 3] 6 | 7
         1 2 3 [4 2 7 1 3 6] | 7
* */
public class ParkingIceCreamTruck {
    public static void main(String[] args) {
        int[] A = {718, 622, 531, 279, 442, 893, 282, 875, 252, 70, 402, 663, 22, 69, 611, 412, 302, 840, 589, 668, 346, 983, 227, 23, 703, 818, 100, 943, 728, 305, 72, 772, 35, 721, 550, 12, 405, 454, 902, 978, 579};
        int B = 9;
        System.out.println(Arrays.toString(new int[]{893, 893, 893, 893, 893, 893, 875, 875, 663, 840, 840, 840, 840, 983, 983,
                983, 983, 983, 983, 983, 983, 983, 943, 943, 943, 943, 943, 943, 772, 772, 902, 978, 978}));

        System.out.println(Arrays.toString(slidingMaximum(A, B)));
    }

    public static int[] slidingMaximum(final int[] A, int B) {
        int[] result = new int[A.length - B + 1];
        int index = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < B; i++) {
            while (!deque.isEmpty() && A[i] > A[deque.peekFirst()]) deque.removeFirst();
            while (!deque.isEmpty() && A[i] > A[deque.peekLast()]) deque.removeLast();
            deque.addLast(i);
        }
        if (!deque.isEmpty())
            result[index++] = A[deque.peekFirst()];

        for (int i = B; i < A.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == i - B) deque.removeFirst();

            while (!deque.isEmpty() && A[i] > A[deque.peekLast()])
                deque.removeLast();
            deque.addLast(i);

            if (!deque.isEmpty())
                result[index++] = A[deque.peekFirst()];
        }
        return result;
    }

    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        int n = A.size();
        int i;
        ArrayList<Integer> res = new ArrayList<>();
        int window = Math.min(A.size(), B);
        Deque<Node> deque = new LinkedList<>();
        int val;
        Node ans;
        for (i = 0; i < window - 1; i++) {
            val = A.get(i);
            while (!deque.isEmpty() && deque.peekFirst().val <= val) {
                deque.pollFirst();
            }
            deque.addFirst(new Node(i, val));
        }
        for (; i < n; i++) {
            val = A.get(i);
            // removes the elements not in range
            while (!deque.isEmpty() && (i - deque.peekLast().index >= window)) {
                deque.pollLast();
            }
            // removes the elements lesser than A[i]
            while (!deque.isEmpty() && deque.peekFirst().val <= val) {
                deque.pollFirst();
            }
            deque.addFirst(new Node(i, val));
            ans = deque.peekLast();
            res.add(ans.val);
        }
        return res;
    }

    class Node {
        int val;
        int index;

        public Node(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }
}
