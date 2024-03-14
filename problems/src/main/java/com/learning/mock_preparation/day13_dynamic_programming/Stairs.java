package com.learning.mock_preparation.day13_dynamic_programming;

import java.util.Arrays;

/*
Problem Description
    You are climbing a staircase, and it takes A steps to reach the top.
    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
    Return the number of distinct ways modulo 1000000007


Problem Constraints
    1 <= A <= 10^5

Input Format
    The first and the only argument contains an integer A, the number of steps.

Output Format
    Return an integer, representing the number of ways to reach the top.

Example Input
    Input 1:
        A = 2
    Input 2:
        A = 3
Example Output
    Output 1:
        2
    Output 2:
        3

Example Explanation
    Explanation 1:
        Distinct ways to reach top: [1, 1], [2].
    Explanation 2:
        Distinct ways to reach top: [1 1 1], [1 2], [2 1].
* */
public class Stairs {

    int[] climbWayCount;

    public static void main(String[] args) {
        Stairs stairs = new Stairs();
        System.out.println(stairs.climbStairsRecursive(4));
    }

    public int climbStairsRecursive(int A) {
        return A;
    }


    public int climbStairsIterative(int A) {
        return A;
    }
}
