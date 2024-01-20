package com.learning.scaler.advance.module4.contest5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/*

Problem Description
 You are given an array of integers A of size N, where each element represents the weight of a stone.
 We are playing a game with the stones. On each turn, we choose the two heaviest stones and smash them together.
 Suppose the stones have weights x and y with x <= y.
 The result of this smash is:
    If x == y, both stones are totally destroyed.
    If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y - x.
    At the end, there is at most one stone left.
    Return the weight of this stone (or 0 if there are no stones left).

Problem Constraints
    1 <= N <= 10^4
    1 <= A[i] <= 106

Input Format
    First and only argument is the Integer array A.

Output Format
    An integer representing the weight of the last remaining stone, or 0 if there are no stones left.

Example Input

 Input 1:A = [1, 2, 3, 4, 5]

Input 2:A = [3, 5, 7, 1, 4, 2, 8, 6]

Example Output

Output 1:
	1

Output 2:
	0

Example Explanation

 Explanation 1:

	Initially, the two heaviest stones are 4 and 5. Smash them together, and the remaining stone weights are [1,2,3,1].

	Next, the two heaviest stones are 2 and 3. Smash them together, and the remaining stone weights are [1,1,1].

	Now the heaviest stone remaining is 1.

Explanation 2:
	Initially, stones are [3, 5, 7, 1, 4, 2, 8, 6]. We choose the heaviest two, 8 and 7, and smash them together. The resulting stone has weight 1.

	Now, stones are [3, 5, 1, 4, 2, 1, 6]. We choose the heaviest two, 6 and 5, and smash them together. The resulting stone has weight 1.

	Now, stones are [3, 1, 4, 2, 1, 1]. We choose the heaviest two, 4 and 3, and smash them together. The resulting stone has weight 1.

	Now, stones are [2, 1, 1, 1, 1]. We choose the heaviest two, 2 and 1, and smash them together. The resulting stone has weight 1.

	Now, stones are [1, 1, 1, 1]. We choose the heaviest two, 1 and 1, and smash them together. Remove both stones.

	Now, stones are [1, 1]. We choose the heaviest two, 1 and 1, and smash them together. Remove both stones.

	Since no stones are left, the answer is 0.

* */
public class WinnerStone {

    public int solve(ArrayList<Integer> A) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.addAll(A);
        while (!maxHeap.isEmpty()) {
            if (maxHeap.size() == 1) return maxHeap.poll();
            int first = maxHeap.poll();
            int second = maxHeap.poll();
            if (first != second) {
                maxHeap.add(first - second);
            }
        }
        return 0;
    }
}
