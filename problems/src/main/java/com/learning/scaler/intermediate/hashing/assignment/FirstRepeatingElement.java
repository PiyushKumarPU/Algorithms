package com.learning.scaler.intermediate.hashing.assignment;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
Problem Description
Given an integer array A of size N, find the first repeating element in it.

We need to find the element that occurs more than once and whose index of the first occurrence is the smallest.

If there is no repeating element, return -1.



Problem Constraints
1 <= N <= 105

1 <= A[i] <= 109



Input Format
The first and only argument is an integer array A of size N.



Output Format
Return an integer denoting the first repeating element.



Example Input
Input 1:

 A = [10, 5, 3, 4, 3, 5, 6]
Input 2:

 A = [6, 10, 5, 4, 9, 120]


Example Output
Output 1:

 5
Output 2:

 -1


Example Explanation
Explanation 1:

 5 is the first element that repeats
Explanation 2:

 There is no repeating element, output -1
*
* */
public class FirstRepeatingElement {

    public static void main(String[] args) {
        System.out.println(solve(List.of(10, 5, 3, 4, 3, 5, 6)));
        System.out.println(solve(List.of(6, 10, 5, 4, 9, 120)));
    }

    public static int solve(List<Integer> A) {
        // creating frequency map
        Map<Integer, Long> frequencyMap = A.stream()
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));
        // iterating through each element and return element if frequency is more than 1
        for (Integer integer : A) {
            if (frequencyMap.get(integer) > 1) return integer;
        }
        return -1;
    }
}
