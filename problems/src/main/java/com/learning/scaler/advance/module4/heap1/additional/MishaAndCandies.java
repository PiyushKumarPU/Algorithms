package com.learning.scaler.advance.module4.heap1.additional;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
Problem Description
    Misha loves eating candies. She has been given N boxes of Candies.
    She decides that every time she will choose a box having the minimum number of candies, eat half of the candies and put the remaining candies in the other box that has the minimum number of candies.
    Misha does not like a box if it has the number of candies greater than B so she won't eat from that box. Can you find how many candies she will eat?

    NOTE 1: If a box has an odd number of candies then Misha will eat the floor(odd / 2).
    NOTE 2: The same box will not be chosen again.

Problem Constraints
    1 <= N <= 10^5
    1 <= A[i] <= 10^5
    1 <= B <= 10^6

Input Format
    The first argument is A an Array of Integers, where A[i] is the number of candies in the ith box.
    The second argument is B, the maximum number of candies Misha like in a box.

Output Format
    Return an integer denoting the number of candies Misha will eat.

Example Input
    Input 1:
         A = [3, 2, 3]
         B = 4
    Input 2:
         A = [1, 2, 1]
         B = 2

Example Output
    Output 1:
        2
    Output 2:
        1

Example Explanation
    Explanation 1:
         1st time Misha will eat from 2nd box, i.e 1 candy she'll eat and will put the remaining 1 candy in the 1st box.
         2nd time she will eat from the 3rd box, i.e 1 candy she'll eat and will put the remaining 2 candies in the 1st box.
         She will not eat from the 3rd box as now it has candies greater than B.
         So the number of candies Misha eat is 2.
    Explanation 2:
         1st time Misha will eat from 1st box, i.e she can't eat any and will put the remaining 1 candy in the 3rd box.
         2nd time she will eat from the 3rd box, i.e 1 candy she'll eat and will put the remaining 1 candies in the 2nd box.
         She will not eat from the 2nd box as now it has candies greater than B.
         So the number of candies Misha eat is 1.
* */
public class MishaAndCandies {

    public static void main(String[] args) {
        System.out.println(new MishaAndCandies().solveHeap(new ArrayList<>(List.of(9, 818, 174, 237, 892, 109, 522, 27, 59, 336, 605, 865, 714, 86, 708, 535, 138, 948, 836, 287, 179, 754, 466, 856, 153, 53, 958, 951, 262, 341, 769, 491, 772, 509, 336, 120, 98, 805, 169, 984, 520, 447, 256, 266, 348, 351, 60, 563, 45, 638, 29, 479, 400)), 852));
        //System.out.println(new MishaAndCandies().solve(new ArrayList<>(List.of(1, 2, 1)), 2));

    }

    public int solve(ArrayList<Integer> A, int B) {
        int totalCount = 0;
        PriorityQueue<Integer> candies = new PriorityQueue<>();
        for (Integer i : A) {
            candies.offer(i);
        }

        while (!candies.isEmpty()) {
            Integer current = candies.poll();
            if (current != null && current <= B) {
                int candiesCount = current / 2;
                totalCount += candiesCount;
                current = candies.poll();
                if (current != null) {
                    current += candiesCount;
                    candies.offer(current);
                }
            }
        }
        return totalCount;
    }

    public int solveHeap(ArrayList<Integer> A, int B) {
        int size = A.size();
        int totalCount = 0;
        while (size > 0) {
            A = constructHeap(A);
            Integer current = A.get(0);
            A.set(0, A.get(size - 1));
            size--;
            heapify(A, 0, size);
            if (current != null && current <= B) {
                int candiesCount = current / 2;
                totalCount += candiesCount;
                current = A.get(0);
                if (current != null) {
                    current += candiesCount;
                    A.set(0, current);
                }
            }
        }
        return totalCount;

    }


    private ArrayList<Integer> constructHeap(ArrayList<Integer> input) {
        if (input == null || input.size() == 1) return input;
        int start = (input.size() - 2) / 2;
        for (int i = start; i >= 0; i--) {
            heapify(input, i, input.size());
        }
        return input;
    }

    private void heapify(ArrayList<Integer> A, int index1, int size) {
        int i = index1, left = 2 * i + 1, right = 2 * i + 2;
        while (left <= A.size()) {
            int currentMin = Math.min(A.get(i), A.get(left));
            if (right < A.size()) {
                currentMin = Math.min(currentMin, A.get(right));
            }
            if (currentMin == A.get(i)) break;
            else if (currentMin == A.get(left)) {
                int temp = A.get(i);
                A.set(i, A.get(left));
                A.set(left, temp);
                i = left;
            } else if (currentMin == A.get(right)) {
                int temp = A.get(i);
                A.set(i, A.get(right));
                A.set(right, temp);
                i = right;
            }
            left = 2 * i + 1;
            right = 2 * i + 2;
        }
    }
}
