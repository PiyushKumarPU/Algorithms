package com.learning.scaler.intermediate.hashing.assignment;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/*

Problem Description
    Given an array A of N integers, return the number of unique elements in the array.

Problem Constraints
    1 <= N <= 10^5
    1 <= A[i] <= 10^9

Input Format
    First argument A is an array of integers.

Output Format
    Return an integer.

Example Input
    Input 1:
        A = [3, 4, 3, 6, 6]
    Input 2:
        A = [3, 3, 3, 9, 0, 1, 0]

Example Output
    Output 1:
        3
    Output 2:
        4
* */
public class CountDistinctElement {
    public static void main(String[] args) {
        System.out.println(solveNoLib(List.of(6, 3, 3, 6, 7, 8, 7, 3, 7)));
        System.out.println(solve(List.of(3, 3, 3, 9, 0, 1, 0)));
    }

    public static int solve(List<Integer> A) {
        // converting list to map and returning map key size
        return A.stream()
                .collect(Collectors.groupingBy(Function.identity())).keySet().size();
    }

    public static int solveNoLib(List<Integer> A) {
        return new HashSet<>(A).size();
    }
}
