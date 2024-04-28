package com.learning.scaler.advance.module4.dp3.assignment;

import java.util.*;

/*
Problem Description
    Given a knapsack weight A and a set of items with certain value B[i] and weight C[i], we need to calculate
    maximum amount that could fit in this quantity.
    This is different from classical Knapsack problem, here we are allowed to use unlimited number of
    instances of an item.

Problem Constraints
    1 <= A <= 1000
    1 <= |B| <= 1000
    1 <= B[i] <= 1000
    1 <= C[i] <= 1000

Input Format
    First argument is the Weight of knapsack A
    Second argument is the vector of values B
    Third argument is the vector of weights C

Output Format
    Return the maximum value that fills the knapsack completely

Example Input
    Input 1:
        A = 10
        B = [5]
        C = [10]
    Input 2:
        A = 10
        B = [6, 7]
        C = [5, 5]

Example Output
    Output 1:
        5
    Output 2:
        4

Example Explanation
    Explanation 1:
        Only valid possibility is to take the given item.
    Explanation 2:
        Take the second item twice.
* */
public class UnboundedKnapsack {

    public static void main(String[] args) {
        ArrayList<Integer> B = new ArrayList<>(List.of(14, 13, 7, 5, 5, 7, 13, 16, 17, 1));
        ArrayList<Integer> C = new ArrayList<>(List.of(10, 20, 9, 4, 15, 4, 4, 1, 15, 2));
        int A = 80;
        System.out.println(new UnboundedKnapsack().solve(A, B, C));

    }

    int[] weighValues;
    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        if (A <= 0 || B.isEmpty() || C.isEmpty()) return 0;
        weighValues = new int[A + 1];
        Arrays.fill(weighValues, -1);
        return solveRec(A, B, C);
    }

    private int solveRec(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        if (A < 0) return 0;
        if (weighValues[A] != -1) return weighValues[A];
        int currentMax = Integer.MIN_VALUE;
        for (int i = 0; i < B.size(); i++) {
            int take = (A >= C.get(i)) ? (B.get(i) + solveRec((A - C.get(i)), B, C)) : 0;
            currentMax = Math.max(currentMax, take);
        }
        weighValues[A] = currentMax;
        return weighValues[A];
    }

}
