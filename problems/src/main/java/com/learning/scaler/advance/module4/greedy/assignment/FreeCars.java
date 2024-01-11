package com.learning.scaler.advance.module4.greedy.assignment;

import com.learning.scaler.advance.module4.greedy.Toy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
Problem Description
    Given two arrays, A and B of size N. A[i] represents the time by which you can buy the ith car without paying any money.
    B[i] represents the profit you can earn by buying the ith car. It takes 1 minute to buy a car, so you can only buy the ith car when the current time <= A[i] - 1.
    Your task is to find the maximum profit one can earn by buying cars considering that you can only buy one car at a time.

NOTE:
    * You can start buying from time = 0.
    * Return your answer modulo 109 + 7.


Problem Constraints
    1 <= N <= 10^5
    1 <= A[i] <= 10^9
    0 <= B[i] <= 10^9


Input Format
    The first argument is an integer array A represents the deadline for buying the cars.
    The second argument is an integer array B represents the profit obtained after buying the cars.

Output Format
    Return an integer denoting the maximum profit you can earn.

Example Input
    Input 1:
        A = [1, 3, 2, 3, 3]
        B = [5, 6, 1, 3, 9]
    Input 2:
        A = [3, 8, 7, 5]
        B = [3, 1, 7, 19]

Example Output
    Output 1:
        20
    Output 2:
        30


Example Explanation
    Explanation 1:
     At time 0, buy car with profit 5.
     At time 1, buy car with profit 6.
     At time 2, buy car with profit 9.
     At time = 3 or after , you can't buy any car, as there is no car with deadline >= 4.
     So, total profit that one can earn is 20.
    Explanation 2:
     At time 0, buy car with profit 3.
     At time 1, buy car with profit 1.
     At time 2, buy car with profit 7.
     At time 3, buy car with profit 19.
     We are able to buy all cars within their deadline. So, total profit that one can earn is 30.
* */
public class FreeCars {

    public static void main(String[] args) {
        FreeCars freeCars = new FreeCars();
        System.out.println(freeCars.solve(new ArrayList<>(List.of(1, 3, 2, 3, 3)), new ArrayList<>(List.of(5, 6, 1, 3, 9))));
    }

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Toy> toys = new ArrayList<>(A.size());
        for (int i = 0; i < A.size(); i++) {
            toys.add(new Toy(A.get(i), B.get(i)));
        }
        toys.sort(Comparator.comparing(a -> a.expire));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int time = 0;
        for (int i = 0; i < A.size(); i++) {
            if (time < toys.get(i).expire) {
                minHeap.add(toys.get(i).count);
                time++;
            } else {
                if (!minHeap.isEmpty() && toys.get(i).count > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.add(toys.get(i).count);
                }
            }
        }
        int result = 0;
        while (!minHeap.isEmpty()) {
            result += minHeap.poll();
            result = result % 1000000007;
        }
        return result;
    }
}

