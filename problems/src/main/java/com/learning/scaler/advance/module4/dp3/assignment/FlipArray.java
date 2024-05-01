package com.learning.scaler.advance.module4.dp3.assignment;

import java.util.Arrays;
import java.util.List;

/*
Problem Description
    Given an array A of positive elements, you have to flip the sign of some of its elements such that the
    resultant sum of the elements of array should be minimum non-negative(as close to zero as possible).
    Return the minimum number of elements whose sign needs to be flipped such that the resultant sum is
    minimum non-negative.

Problem Constraints
    1 <= length of(A) <= 100
    Sum of all the elements will not exceed 10,000.

Input Format
    First and only argument is an integer array A.

Output Format
    Return an integer denoting the minimum number of elements whose sign needs to be flipped.

Example Input
    Input 1:
        A = [15, 10, 6]
    Input 2:
        A = [14, 10, 4]

Example Output
    Output 1:
        1
    Output 2:
        1

Example Explanation
    Explanation 1:
        Here, we will flip the sign of 15 and the resultant sum will be 1.
    Explanation 2:
        Here, we will flip the sign of 14 and the resultant sum will be 0.
     Note that flipping the sign of 10 and 4 also gives the resultant sum 0, but flipping their sign are not minimum.
* */
public class FlipArray {

    public static void main(String[] args) {
        List<Integer> input = List.of(4, 4, 3, 1);
        System.out.println(solve(input));

    }

    public int solve(final int[] A) {

        return 0;
    }

    public static int solve(final List<Integer> A) {
        Integer totalSum = A.stream().reduce(0, Integer::sum);
        int targetSum = totalSum / 2;
        Pair[][] possibleCount = new Pair[A.size() + 1][targetSum + 1];
        Arrays.fill(possibleCount[0], new Pair(0, false));
        for (int i = 1; i <= A.size(); i++) {
            int value = A.get(i - 1);
            for (int currentTargetSum = 0; currentTargetSum <= targetSum; currentTargetSum++) {
                Pair pair;
                if (value > currentTargetSum) pair = new Pair(0, false);
                else if (value == currentTargetSum) {
                    pair = new Pair(1, true);
                } else {
                    Pair exclude = possibleCount[i - 1][currentTargetSum];
                    Pair include = possibleCount[i - 1][currentTargetSum - value];
                    if (exclude.isPossible && include.isPossible) {
                        pair = new Pair(Math.min(exclude.count, include.count + 1), true);
                    } else if (exclude.isPossible) {
                        pair = new Pair(exclude.count, true);
                    } else if (include.isPossible) {
                        pair = new Pair(include.count + 1, true);
                    } else pair = new Pair(0, false);
                }
                possibleCount[i][currentTargetSum] = pair;
            }
        }
        for (int i = targetSum; i >= 0; i--) {
            for (int j = A.size(); j >= 0; j--) {
                if (possibleCount[j][i].isPossible) return possibleCount[j][i].count;
            }
        }
        return 0;
    }
}

class Pair {
    public int count;
    public boolean isPossible;

    public Pair(int count, Boolean isPossible) {
        this.count = count;
        this.isPossible = isPossible;
    }
}