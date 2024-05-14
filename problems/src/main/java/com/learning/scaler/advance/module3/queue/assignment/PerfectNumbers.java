package com.learning.scaler.advance.module3.queue.assignment;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Problem Description
    Given an integer A, you have to find the Ath Perfect Number.
    A Perfect Number has the following properties:
    It comprises only 1 and 2.
    The number of digits in a Perfect number is even.
    It is a palindrome number.
    For example, 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.

Problem Constraints
    1 <= A <= 100000

Input Format
    The only argument given is an integer A.

Output Format
    Return a string that denotes the Ath Perfect Number.

Example
    Input 1:
         A = 2
    Input 2:
         A = 3

Example
    Output 1:
         22
    Output 2:
         1111

Example
    Explanation 1:
        First four perfect numbers are:
        1. 11
        2. 22
        3. 1111
        4. 1221
         Returns the 2nd Perfect number.
Explanation 2:
    First four perfect numbers are:
    1. 11
    2. 22
    3. 1111
    4. 1221
     Returns the 3rd Perfect number.
* */
public class PerfectNumbers {

    public static void main(String[] args) {
        System.out.println(new PerfectNumbers().solve(100000));
    }

    public String solve(int A) {
        List<Long> result = new ArrayList<>();
        Queue<Long> queue = new LinkedList<>();
        queue.add(1L);
        queue.add(2L);
        int count = 0;
        while (!queue.isEmpty() && count < A) {
            long current = queue.poll();
            result.add(current);
            queue.add(current * 10 + 1);
            queue.add(current * 10 + 2);
            count++;
        }
        String finalNumber = String.valueOf(result.get(result.size() - 1));
        StringBuilder str = new StringBuilder(finalNumber);
        return finalNumber + str.reverse();
    }
}
