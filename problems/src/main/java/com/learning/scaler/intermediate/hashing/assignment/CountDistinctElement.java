package com.learning.scaler.intermediate.hashing.assignment;


import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/*

Problem Description
Given an array A of N integers, return the number of unique elements in the array.


Problem Constraints
1 <= N <= 105
1 <= A[i] <= 109


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
        System.out.println(solve(List.of(3, 4, 3, 6, 6)));
        System.out.println(solve(List.of(3, 3, 3, 9, 0, 1, 0)));
    }

    public static int solve(List<Integer> A) {
        // converting list to map and returning map key size
        return A.stream()
                .collect(Collectors.groupingBy(Function.identity())).keySet().size();
    }
}
