package com.learning.scaler.advance.module4.dp2.additional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Problem Description
    Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
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

    int[][] pathMatrix;

    public static void main(String[] args) {
        MinSumPathInTriangle triangle = new MinSumPathInTriangle();
        int result = triangle.minimumTotal(new ArrayList<>(List.of(
                new ArrayList<>(List.of(9)),
                new ArrayList<>(List.of(3, 8)),
                new ArrayList<>(List.of(0, 2, 4)),
                new ArrayList<>(List.of(8, 3, 9, 0)),
                new ArrayList<>(List.of(5, 2, 2, 7, 3)),
                new ArrayList<>(List.of(7, 9, 0, 2, 3, 9)),
                new ArrayList<>(List.of(9, 7, 0, 3, 9, 8, 6)),
                new ArrayList<>(List.of(5, 7, 6, 2, 7, 0, 3, 9))
        )));
        System.out.println(result);
    }

    public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
        int n = a.size();
        pathMatrix = new int[n][0];
        for (int i = 0; i < n; i++) {
            pathMatrix[i] = new int[a.get(i).size()];
        }



        return pathMatrix[0][0];
    }

    public int minimumTotalRecursion(ArrayList<ArrayList<Integer>> a, int start, int end) {
        int n = a.size(), m = a.get(start).size();
        if (start == n - 1 && end == m - 1) return a.get(start).get(end);

        int down = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        if (start < n - 1 && pathMatrix[start + 1][end] == -1) {
            pathMatrix[start + 1][end] = minimumTotalRecursion(a, start + 1, end);
            down = pathMatrix[start + 1][end];
        }
        if (start < n - 1 && end < a.get(start + 1).size() - 1 && pathMatrix[start + 1][end + 1] == -1) {
            pathMatrix[start + 1][end + 1] = minimumTotalRecursion(a, start + 1, end + 1);
            right = pathMatrix[start + 1][end + 1];
        }
        return a.get(start).get(end) + Math.min(right, down);
    }
}
