package com.learning.scaler.advance.module1.recursion3.assignment;


import java.util.ArrayList;
import java.util.List;

/*
Problem Description
    Given a set of distinct integers A, return all possible subsets.
    NOTE:
        Elements in a subset must be in non-descending order.
        The solution set must not contain duplicate subsets.
        Also, the subsets should be sorted in ascending ( lexicographic ) order.
        The initial list is not necessarily sorted.

Problem Constraints
1 <= |A| <= 16
INTMIN <= A[i] <= INTMAX

Input Format
    First and only argument of input contains a single integer array A.

Output Format
    Return a vector of vectors denoting the answer.

Example Input
    Input 1:
        A = [1]
    Input 2:
        A = [1, 2, 3]

Example Output
    Output 1:
        [
            []
            [1]
        ]
    Output 2:
        [
         []
         [1]
         [1, 2]
         [1, 2, 3]
         [1, 3]
         [2]
         [2, 3]
         [3]
        ]

Example Explanation
    Explanation 1:
         You can see that these are all possible subsets.
    Explanation 2:
        You can see that these are all possible subsets.
*
* */
public class Subset {

    public static void main(String[] args) {
        Subset subset = new Subset();
        System.out.println(subset.subsets(new ArrayList<>(List.of(1, 2, 3))));
    }

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        int currentIndex = 0;
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j <= i; j++) {
                ArrayList<Integer> row = new ArrayList<>();
                for (int k = j; k <= i; k++) {
                    row.add(A.get(k));
                }
                result.add(row);
            }
        }
        return result;
    }
}
