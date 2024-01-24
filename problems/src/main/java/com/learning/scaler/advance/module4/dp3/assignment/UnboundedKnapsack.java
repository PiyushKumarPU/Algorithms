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
        UnboundedKnapsack knapsack = new UnboundedKnapsack();
        /*System.out.println(knapsack.solve(10, new ArrayList<>(List.of(5)), new ArrayList<>(
                List.of(10)
        )));*/

        System.out.println(knapsack.solve(10, new ArrayList<>(List.of(6, 7)), new ArrayList<>(
                List.of(5, 5)
        )));

    }

    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int[] weightRange = new int[A + 1];
        weightRange[0] = 0;
        for (int i = 1; i <= A; i++) {
            int maxValue = 0;
            for (int j = 0; j < B.size(); j++) {
                if (C.get(j) <= i) {
                    int index = i - B.get(j);
                    maxValue = Math.max(maxValue, B.get(j) + (index > 0 ? weightRange[index] : 0));
                }
            }
            weightRange[i] = maxValue;
        }
        return weightRange[A];
    }

    public ArrayList<Integer> solve(int A) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= 3; i++) {
            result.add(i);
            queue.add(i);
        }
        if (A <= 3) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < A; i++) {
                temp.add(result.get(i));
            }
            return new ArrayList<>(temp);
        }
        while (!queue.isEmpty()) {
            int t = queue.poll();
            String str = Integer.toString(t);
            result.add(Integer.parseInt(str + "1"));
            if (result.size() == A)
                break;
            queue.add(Integer.parseInt(str + "1"));
            result.add(Integer.parseInt(str + "2"));
            if (result.size() == A)
                break;
            queue.add(Integer.parseInt(str + "2"));
            result.add(Integer.parseInt(str + "3"));
            if (result.size() == A)
                break;
            queue.add(Integer.parseInt(str + "3"));
        }
        result.sort(Comparator.naturalOrder());
        return new ArrayList<>(result);
    }

}
