package com.learning.scaler.advance.module4.dp3.assignment;

import java.util.*;
import java.util.stream.Collectors;

/*
Problem Description
    Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.
    Also given an integer C which represents knapsack capacity.
    Find out the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.
    NOTE:
        You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).

Problem Constraints
    1 <= N <= 10^3
    1 <= C <= 10^3
    1 <= A[i], B[i] <= 10^3

Input Format
    First argument is an integer array A of size N denoting the values on N items.
    Second argument is an integer array B of size N denoting the weights on N items.
    Third argument is an integer C denoting the knapsack capacity.

Output Format
    Return a single integer denoting the maximum value subset of A such that sum of the weights of this subset is
    smaller than or equal to C.

Example Input
    Input 1:
         A = [60, 100, 120]
         B = [10, 20, 30]
         C = 50
    Input 2:
         A = [10, 20, 30, 40]
         B = [12, 13, 15, 19]
         C = 10
Example Output
    Output 1:
        220
    Output 2:
        0

Example Explanation
    Explanation 1:
        Taking items with weight 20 and 30 will give us the maximum value i.e 100 + 120 = 220
    Explanation 2:
        Knapsack capacity is 10 but each item has weight greater than 10 so no items can be considered in the
        knapsack therefore answer is 0.
* */
public class ZeroOne01Knapsack {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(60, 100, 120));
        ArrayList<Integer> B = new ArrayList<>(List.of(10, 20, 30));
        int C = 50;
        //System.out.println(solve(A, B, C));
        A = new ArrayList<>(List.of(647, 363, 887, 876, 434, 870, 143, 845, 417, 882, 999, 323, 652, 22, 700, 558, 477, 893, 390, 76, 713, 601, 511, 4, 870, 862, 689, 402, 790));
        B = new ArrayList<>(List.of(256, 424, 3, 86, 183, 286, 89, 427, 118, 258, 333, 433, 170, 155, 222, 190, 477, 330, 369, 193, 426, 56, 435, 50, 442, 13, 146, 61, 219));
        C = 754;
        System.out.println(solve(A, B, C));

    }

    /*public static int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        int size = A.size(), minWeight = B.stream().min(Comparator.naturalOrder()).orElse(0);
        int[][] indexWeightPair = new int[size + 1][C + 1];
        for (int[] row : indexWeightPair) Arrays.fill(row, -1);
        for (int i = 1; i < size; i++) {
            int weight = B.get(i - 1);
            for (int j = minWeight; j <= C; j++) {
                int val = -1;
                if (weight <= j) {
                    int excludeVal = indexWeightPair[i - 1][j];
                    int includeVal = indexWeightPair[i - 1][j - weight] + A.get(i - 1);
                    val = Math.max(includeVal, excludeVal);
                }
                indexWeightPair[i][j] = val;
            }
        }
        return Math.max(indexWeightPair[size][C], 0);
    }*/


    public static int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        ArrayList<Integer> AUpdated = new ArrayList<>();
        ArrayList<Integer> BUpdated = new ArrayList<>();
        for (int i = 0; i < B.size(); i++) {
            if (B.get(i) <= C) {
                AUpdated.add(A.get(i));
                BUpdated.add(B.get(i));
            }
        }
        A = AUpdated;
        B = BUpdated;
        if (A.isEmpty()) return 0;
        return solveIterative(A, B, C);
    }

    public static int solveRec(ArrayList<Integer> values, ArrayList<Integer> weights, int C, int endIndex, int[][] indexWeightPair) {
        if (endIndex < 0 || C <= 0) return 0;
        if (indexWeightPair[endIndex][C] != -1) return indexWeightPair[endIndex][C];
        if (weights.get(endIndex) > C) indexWeightPair[endIndex][C] = 0;
        else {
            int exclude = solveRec(values, weights, C, endIndex - 1, indexWeightPair);
            int include = values.get(endIndex) + solveRec(values, weights, (C - weights.get(endIndex)), endIndex - 1, indexWeightPair);
            indexWeightPair[endIndex][C] = Math.max(exclude, include);
        }
        return Math.max(indexWeightPair[endIndex][C], 0);
    }

    public static int solveIterative(ArrayList<Integer> values, ArrayList<Integer> weights, int C) {
        int[][] indexWeightPair = new int[values.size() + 1][C + 1];
        Arrays.fill(indexWeightPair[0], 0);
        int maxValue = 0;
        for (int i = 1; i <= values.size(); i++) {
            int value = values.get(i - 1);
            int weight = weights.get(i - 1);
            for (int j = 0; j <= C; j++) {
                int currentval = 0;
                if (weight <= j) {
                    int excludeVal = indexWeightPair[i - 1][j];
                    int includeVal = value + indexWeightPair[i - 1][j - weight];
                    currentval = Math.max(excludeVal, includeVal);

                }
                indexWeightPair[i][j] = currentval;
                maxValue = Math.max(indexWeightPair[i][j], maxValue);
            }
        }
        Optional<Integer> max = Arrays.stream(indexWeightPair).map(ints -> Arrays.stream(ints).max().orElse(0)).toList().stream().max(Comparator.naturalOrder());
        return maxValue;
    }
}
