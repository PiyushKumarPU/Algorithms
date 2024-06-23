package com.learning.scaler.advance.module4.dp3.additional;

import java.util.Arrays;
import java.util.List;

/*
Problem Description
    As it is Tushar's Birthday on March 1st, he decided to throw a party to all his friends at TGI Fridays in Pune.
    Given is the eating capacity of each friend, filling capacity of each dish and cost of each dish?
    A friend is satisfied if the sum of the filling capacity of dishes he ate is equal to his capacity.
    Find the minimum cost such that all of Tushar's friends are satisfied (reached their eating capacity).
NOTE:
    Each dish is supposed to be eaten by only one person. Sharing is not allowed.
    Each friend can take any dish unlimited number of times.
    There always exists a dish with filling capacity 1 so that a solution always exists.

Problem Constraints
    |A| <= 1000
    |B| <= 1000
    |C| <= 1000

Input Format
    First Argument is vector A, denoting eating capacities
    Second Argument is vector B, denoting filling capacities
    Third Argument is vector C, denoting cost

Output Format
    Return a single integer, the answer to the problem

Example Input
Input 1:
    A = [2, 4, 6]
    B = [2, 1, 3]
    C = [2, 5, 3]
Input 2:
    A = [2]
    B = [1]
    C = [2]

Example Output
    Output 1:
        12
    Output 2:
        4

Example Explanation
    Explanation 1:
        First friend takes dish 1, Second friend takes dish 1 twice and third friend takes dish 3 twice.
        So 2 + 2*2 + 3*2 = 12.
    Explanation 2:
        Only way is to take 2 dishes of cost 2, hence 4.
* */
public class TusharSBirthdayParty {

    public static void main(String[] args) {
        List<Integer> A = List.of(2, 4, 6);
        List<Integer> B = List.of(2, 1, 3);
        List<Integer> C = List.of(2, 5, 3);
        System.out.println(new TusharSBirthdayParty().solve(A, B, C));
    }

    public int solve(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        //A --> eating capacity
        // B --> filling capacity
        // C --> cost
        // find max eating capacity and find the minimum cost for all the value from 1 to max eating capacity
        int maxCapacity = 0;
        for (Integer capacity : A) maxCapacity = Math.max(maxCapacity, capacity);
        int[] minCosts = new int[maxCapacity + 1];
        Arrays.fill(minCosts, Integer.MAX_VALUE);
        minCosts[0] = 0;
        calculateCost(maxCapacity, B, C, minCosts);
        int totalCost = 0;
        for (int capacity : A) totalCost += minCosts[capacity];
        return totalCost;
    }

    private int calculateCost(int capacity, final List<Integer> dishCapacities, final List<Integer> dishCosts, int[] minCosts) {
        if (capacity <= 0) return 0;
        else if (minCosts[capacity] != Integer.MAX_VALUE) return minCosts[capacity];

        for (int i = 0; i < dishCapacities.size(); i++) {
            int minCost = 0;
            int dishcapacity = dishCapacities.get(i);
            if (dishcapacity > capacity) continue;
            minCost = minCost + dishCosts.get(i) +
                    ((capacity - dishcapacity > 0) ? calculateCost(capacity - dishcapacity, dishCapacities, dishCosts, minCosts) : 0);
            minCosts[capacity] = Math.min(minCosts[capacity], minCost);
        }
        return minCosts[capacity];
    }
}
