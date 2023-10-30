package com.learning.scaler.intermediate.hashing.assignment;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*

Problem Description
    Given an array A. You have some integers given in the array B.
    For the i-th number, find the frequency of B[i] in the array A and return a list containing all the frequencies.


Problem Constraints
    1 <= |A| <= 10^5
    1 <= |B| <= 10^5
    1 <= A[i] <= 10^5
    1 <= B[i] <= 10^5

Input Format
First argument A is an array of integers.
Second argument B is an array of integers denoting the queries.

Output Format
Return an array of integers containing frequency of the each element in B.

Example Input
Input 1:
    A = [1, 2, 1, 1]
    B = [1, 2]
Input 2:
    A = [2, 5, 9, 2, 8]
    B = [3, 2]


Example Output
    Output 1:
    [3, 1]
    Output 2:
    [0, 2]


Example Explanation
    For Input 1:
        The frequency of 1 in the array A is 3.
        The frequency of 2 in the array A is 1.
    For Input 2:
        The frequency of 3 in the array A is 0.
        The frequency of 2 in the array A is 2.

GFG link
https://www.geeksforgeeks.org/find-frequency-of-the-elements-in-given-ranges/
* */
public class FrequencyOfElementQuery {

    public static void main(String[] args) {
        System.out.println(solve(List.of(1, 2, 1, 1), List.of(1, 2)));
        System.out.println(solve(List.of(2, 5, 9, 2, 8), List.of(3, 2)));
    }

    public static List<Integer> solve(List<Integer> A, List<Integer> B) {
        // Calculating frequencies using stream, please use your preferred way to calculate it
        Map<Integer, Long> frequencyMap = A.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // based on the frequency map calculating frequency of each element here
        return B.stream().map(key -> frequencyMap.getOrDefault(key, 0L).intValue())
                .toList();
    }

}
