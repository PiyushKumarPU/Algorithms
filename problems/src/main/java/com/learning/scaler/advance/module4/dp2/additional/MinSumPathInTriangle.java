package com.learning.scaler.advance.module4.dp2.additional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Problem Description
    Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent
    numbers on the row below.
    Adjacent numbers for jth column of ith row is jth and (j+1)th column of (i + 1)th row

Problem Constraints
    |A| <= 1000
    A[i] <= 1000

Input Format
    First and only argument is the vector of vector A defining the given triangle

Output Format
    Return the minimum sum

Example Input
Input 1:

    A = [
             [2],
            [3, 4],
           [6, 5, 7],
          [4, 1, 8, 3]
        ]
Input 2:
     A = [ [1] ]

Example Output
    Output 1:
         11
    Output 2:
         1

Example Explanation
    Explanation 1:
        The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
    Explanation 2:
         Only 2 can be collected.
* */
public class MinSumPathInTriangle {

    public static void main(String[] args) {
        MinSumPathInTriangle triangle = new MinSumPathInTriangle();
        int result = triangle.minimumTotal(new ArrayList<>(List.of(
                new ArrayList<>(List.of(2)),
                new ArrayList<>(List.of(6, 6)),
                new ArrayList<>(List.of(7, 8, 4)))
        ));
        System.out.println(result);
    }

    int[][] minSumMatrix;

    public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
        minSumMatrix = new int[a.size()][a.get(a.size() - 1).size()];
        for (int[] arr : minSumMatrix) Arrays.fill(arr, -1);
        return minimumTotal(a, 0, 0);
    }

    private int minimumTotal(ArrayList<ArrayList<Integer>> a, int start, int end) {
        if (start < 0 || start >= a.size() || end >= a.size() || end >= a.get(start).size()) return Integer.MAX_VALUE;
        else if (minSumMatrix[start][end] == -1) {
            int bottom =  minimumTotal(a, start + 1, end);
            int bottomRight = minimumTotal(a, start + 1, end + 1);
            minSumMatrix[start][end] = a.get(start).get(end) +
                    Math.min(bottom, bottomRight);
        }

        return minSumMatrix[start][end];
    }


    /*public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
        int n = a.size();
        int[][] pathMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(pathMatrix[i], -1);
        }
        return minimumTotalRecursion(a, pathMatrix, 0, 0);
    }

    public int minimumTotalRecursion(ArrayList<ArrayList<Integer>> a, int[][] pathMatrix, int start, int end) {
        if (pathMatrix[start][end] != -1) return pathMatrix[0][0];
        int down = 0, downNext = 0;
        if (start + 1 < a.size()) {
            if (pathMatrix[start + 1][end] == -1)
                pathMatrix[start + 1][end] = minimumTotalRecursion(a, pathMatrix, start + 1, end);
            down = pathMatrix[start + 1][end];
        }

        if (start + 1 < a.size() && end + 1 < a.get(start + 1).size()) {
            if (pathMatrix[start + 1][end + 1] == -1)
                pathMatrix[start + 1][end + 1] = minimumTotalRecursion(a, pathMatrix, start + 1, end + 1);
            downNext = pathMatrix[start + 1][end + 1];
        }
        pathMatrix[start][end] = a.get(start).get(end) + Math.min(downNext, down);
        return pathMatrix[start][end];
    }
*/
}
