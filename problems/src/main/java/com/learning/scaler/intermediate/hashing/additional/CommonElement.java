package com.learning.scaler.intermediate.hashing.additional;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
Problem Description
Given two integer arrays, A and B of size N and M, respectively. Your task is to find all the common elements in both the array.

NOTE:

Each element in the result should appear as many times as it appears in both arrays.
The result can be in any order.


Problem Constraints
    1 <= N, M <= 10^5
    1 <= A[i] <= 10^9



Input Format
First argument is an integer array A of size N.

Second argument is an integer array B of size M.



Output Format
Return an integer array denoting the common elements.



Example Input
Input 1:

 A = [1, 2, 2, 1]
 B = [2, 3, 1, 2]
Input 2:

 A = [2, 1, 4, 10]
 B = [3, 6, 2, 10, 10]


Example Output
Output 1:

 [1, 2, 2]
Output 2:

 [2, 10]


Example Explanation
Explanation 1:

 Elements (1, 2, 2) appears in both the array. Note 2 appears twice in both the array.
Explantion 2:

 Elements (2, 10) appears in both the array.
*
* */
public class CommonElement {

    public static void main(String[] args) {
        System.out.println(solve(List.of(1, 2, 2, 1), List.of(2, 3, 1, 2)));
        System.out.println(solve(List.of(2, 1, 4, 10), List.of(3, 6, 2, 10, 10)));
    }

    public static List<Integer> solveOld(List<Integer> A, List<Integer> B) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Long> aMap = A.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Integer, Long> bMap = B.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (Integer element : (A.size() > B.size() ? B : A)) {
            Long aCount = aMap.getOrDefault(element, 0L);
            Long bCount = bMap.getOrDefault(element, 0L);
            if (aCount > 0 && bCount > 0 && !result.contains(element)) {
                for (int i = 0; i < Math.min(aCount, bCount); i++) {
                    result.add(element);
                }
            }
        }
        return result;
    }

    public static List<Integer> solve(List<Integer> A, List<Integer> B) {
        List<Integer> result = new ArrayList<>();


        return result;

    }
}
