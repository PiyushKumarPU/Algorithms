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
        System.out.println(new MishaAndCandies().solve(new ArrayList<>(List.of(9, 818, 174, 237, 892, 109, 522, 27, 59, 336, 605, 865, 714, 86, 708, 535, 138, 948, 836, 287, 179, 754, 466, 856, 153, 53, 958, 951, 262, 341, 769, 491, 772, 509, 336, 120, 98, 805, 169, 984, 520, 447, 256, 266, 348, 351, 60, 563, 45, 638, 29, 479, 400)), 852));
         System.out.println(new MishaAndCandies().solve1(new ArrayList<>(List.of(9, 818, 174, 237, 892, 109, 522, 27, 59, 336, 605, 865, 714, 86, 708, 535, 138, 948, 836, 287, 179, 754, 466, 856, 153, 53, 958, 951, 262, 341, 769, 491, 772, 509, 336, 120, 98, 805, 169, 984, 520, 447, 256, 266, 348, 351, 60, 563, 45, 638, 29, 479, 400)), 852));

    }

    public int solve(ArrayList<Integer> A, int B) {
        int totalCount = 0;
        PriorityQueue<Integer> candies = new PriorityQueue<>(Integer::compareTo);
        candies.addAll(A);

        while (!candies.isEmpty()) {
            Integer current = candies.poll();
            if (current > B) break;
            int candiesEaten = (current / 2);
            totalCount += candiesEaten;
            // getting current min Box
            Integer next = candies.poll();
            if (next != null) {
                next += (int) Math.ceil(current / 2.0);
                if (next <= B)
                    candies.add(next);
            }
        }
        return totalCount;
    }

    public int solve1(ArrayList<Integer> A, int B) {
        int candies_ate = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.addAll(A);
        while (!pq.isEmpty()) {
            int curr_box = pq.poll();
            if (curr_box > B)
                break;
            candies_ate += (curr_box / 2); // eat half of the candies
            if (pq.isEmpty())
                break;
            int next_box = pq.poll() + (int) Math.ceil(curr_box / 2.0); // push remaining half candies into next box
            if (next_box <= B)
                pq.offer(next_box);
        }
        // return candies she can eat.
        return candies_ate;
    }

}
