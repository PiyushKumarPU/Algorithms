package com.learning.scaler.advance.module3.queue.additional;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
Problem Description
    Given an integer, A. Find and Return first positive A integers in ascending order containing only digits 1, 2, and 3.
    NOTE: All the A integers will fit in 32-bit integers.

Problem Constraints
    1 <= A <= 29500

Input Format
    The only argument given is integer A.

Output Format
    Return an integer array denoting the first positive A integers in ascending order containing only digits 1, 2 and 3.

Example
    Input 1:
         A = 3
    Input 2:
         A = 7

Example
    Output 1:
         [1, 2, 3]
    Output 2:
         [1, 2, 3, 11, 12, 13, 21]

Example
    Explanation 1:
         Output denotes the first 3 integers that contains only digits 1, 2 and 3.
    Explanation 2:
         Output denotes the first 7 integers that contains only digits 1, 2 and 3.
* */
public class NIntegersContainingOnly123 {

    public static void main(String[] args) {
        System.out.println(solve(7));
    }

    public static ArrayList<Integer> solve(int A) {
        int count = 0;
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        while (count < A && !queue.isEmpty()) {
            Integer current = queue.poll();
            result.add(current);
            Integer first = current * 10 + 1;
            Integer second = current * 10 + 2;
            Integer third = current * 10 + 3;
            queue.add(first);
            queue.add(second);
            queue.add(third);
            count += 1;
        }
        return result;
    }
}
