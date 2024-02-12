package com.learning.scaler.intermediate.prefix.sum.additional;

import java.util.ArrayList;
import java.util.List;

/*
Problem Description
    You are given an array A of integers of size N.
    Your task is to find the equilibrium index of the given array
    The equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.
    If there are no elements that are at lower indexes or at higher indexes, then the corresponding sum of elements is considered as 0.

Note:
    Array indexing starts from 0.
    If there is no equilibrium index then return -1.
    If there are more than one equilibrium indexes then return the minimum index.

Problem Constraints
    1 <= N <= 10^5
    -105 <= A[i] <= 10^5

Input Format
    First arugment is an array A .

Output Format
    Return the equilibrium index of the given array. If no such index is found then return -1.

Example Input
    Input 1:
        A = [-7, 1, 5, 2, -4, 3, 0]
    Input 2:
        A = [1, 2, 3]

Example Output
    Output 1:
        3
    Output 2:
        -1
* */
public class EquilibriumIndexOfAnArray {

    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<>(List.of(1, 2, 3, 7, 1, 2, 3))));
    }

    public static int solve(ArrayList<Integer> A) {
        ArrayList<Long> prefixSum = new ArrayList<>(A.size());
        prefixSum.add(Long.valueOf(A.get(0)));
        for (int i = 1; i < A.size(); i++) {
            prefixSum.add(prefixSum.get(i - 1) + A.get(i));
        }
        for (int i = 0; i < A.size(); i++) {
            Long rightSum = (i == A.size() - 1) ? 0 : prefixSum.get(A.size() - 1) - prefixSum.get(i);
            Long leftSum = (i == 0) ? 0 :
                    prefixSum.get(i - 1);
            if (rightSum.equals(leftSum)) return i;
        }
        return -1;


    }
}
