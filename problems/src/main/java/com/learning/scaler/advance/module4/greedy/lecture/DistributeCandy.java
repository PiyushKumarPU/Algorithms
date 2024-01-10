package com.learning.scaler.advance.module4.greedy.lecture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Problem Description
    N children are standing in a line. Each child is assigned a rating value.

    You are giving candies to these children subjected to the following requirements:
        1. Each child must have at least one candy.
        2. Children with a higher rating get more candies than their neighbors.
    What is the minimum number of candies you must give?


Problem Constraints
    1 <= N <= 10^5
    -109 <= A[i] <= 10^9


Input Format
    The first and only argument is an integer array A representing the rating of children.

Output Format
    Return an integer representing the minimum candies to be given.

Example Input
    Input 1:
        A = [1, 2]
    Input 2:
         A = [1, 5, 2, 1]

Example Output
    Output 1:
        3
    Output 2:
        7

Example Explanation
    Explanation 1:
        The candidate with 1 rating gets 1 candy and candidate with rating 2 cannot get 1 candy as 1 is its neighbor.
        So rating 2 candidate gets 2 candies. In total, 2 + 1 = 3 candies need to be given out.
    Explanation 2:
        Candies given = [1, 3, 2, 1]
* */
public class DistributeCandy {

    public static void main(String[] args) {
        DistributeCandy candy = new DistributeCandy();
        //System.out.println(candy.candy(new ArrayList<>(List.of(1, 2))));
        System.out.println(candy.candy(new ArrayList<>(List.of(1, 5, 2, 1))));
    }

    public int candy(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(A.size(), 1));
        // check from left to right for higher rank
        for (int i = 1; i < A.size(); i++) {
            if (A.get(i) > A.get(i - 1)) result.set(i, result.get(i - 1) + 1);
        }
        // check from right to left if left is greater than right
        for (int i = result.size() - 2; i >= 0; i--) {
            if (A.get(i) > A.get(i + 1))
                result.set(i, (Math.max(result.get(i), result.get(i + 1) + 1)));
        }
        return result.stream().reduce(0, Integer::sum);
    }
}
