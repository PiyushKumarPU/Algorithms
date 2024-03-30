package com.learning.scaler.advance.module2.sort.quick.assignment;

import java.util.ArrayList;

/*
Problem Description
    You are given an array A of N elements. Sort the given array in increasing order of number of
    distinct factors of each element, i.e., element having the least number of factors should be
    the first to be displayed and the number having the highest number of factors should be the last one.
    If 2 elements have same number of factors, then number with less value should come first.
    Note: You cannot use any extra space

Problem Constraints
    1 <= N <= 10^4
    1 <= A[i] <= 10^4

Input Format
    First argument A is an array of integers.

Output Format
    Return an array of integers.

Example Input
    Input 1:
    A = [6, 8, 9]
    Input 2:
    A = [2, 4, 7]

Example Output
    Output 1:
    [9, 6, 8]
    Output 2:
    [2, 7, 4]

Example Explanation
    For Input 1:
    The number 9 has 3 factors, 6 has 4 factors and 8 has 4 factors.
    For Input 2:
    The number 2 has 2 factors, 7 has 2 factors and 4 has 3 factors.
* */
public class FactorSort {

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        A.sort((o1, o2) -> {
            int compare = factor(o1).compareTo(factor(o2));
            return compare != 0 ? compare : o1.compareTo(o2);
        });
        return A;
    }

    private Integer factor(Integer N) {
        int cnt = 0;
        for (int i = 1; i * i <= N; i++) {
            if (N % i == 0) {
                cnt += (i == N / i) ? 1 : 2;
            }
        }
        return cnt;
    }
}
