package com.learning.scaler.intermediate.sliding.window.additional;

import java.util.List;

/*
Problem Description
    Given an array of integers A and an integer B, find and return the minimum number of swaps required
    to bring all the numbers less than or equal to B together.
    Note: It is possible to swap any two elements, not necessarily consecutive.

Problem Constraints
    1 <= length of the array <= 100000
    -10^9 <= A[i], B <= 10^9

Input Format
    The first argument given is the integer array A.
    The second argument given is the integer B.

Output Format
    Return the minimum number of swaps.

Example Input
    Input 1:
         A = [1, 12, 10, 3, 14, 10, 5]
         B = 8
    Input 2:
         A = [5, 17, 100, 11]
         B = 20

Example Output
    Output 1:
         2
    Output 2:
         1

Example Explanation
    Explanation 1:
         A = [1, 12, 10, 3, 14, 10, 5]
         After swapping  12 and 3, A => [1, 3, 10, 12, 14, 10, 5].
         After swapping  the first occurrence of 10 and 5, A => [1, 3, 5, 12, 14, 10, 10].
         Now, all elements less than or equal to 8 are together.
    Explanation 2:
         A = [5, 17, 100, 11]
         After swapping 100 and 11, A => [5, 17, 11, 100].
         Now, all elements less than or equal to 20 are together.
* */
public class MinimumSwaps {

    public static void main(String[] args) {
        List<Integer> A =
                List.of(52, 7, 93, 47, 68, 26, 51, 44, 5, 41, 88, 19, 78, 38, 17, 13, 24, 74, 92, 5, 84, 27, 48, 49, 37, 59, 3, 56, 79, 26, 55, 60, 16, 83, 63, 40, 55, 9, 96, 29, 7, 22, 27, 74, 78, 38, 11, 65, 29, 52, 36, 21, 94, 46, 52, 47, 87, 33, 87, 70);
        System.out.println(solve(A, 19));
    }

    public static int solve(List<Integer> A, int B) {
        int windowSize = 0, currentCount = Integer.MAX_VALUE, tempCount = 0, size = A.size();
        // find no of element less or equal to B
        for (int ele : A) if (ele <= B) windowSize++;
        // calculate swap count for current window Size
        for (int i = 0; i < windowSize; i++) if (A.get(i) > B) tempCount++;
        currentCount = tempCount;

        for (int i = 1; i <= (size - windowSize); i++) {
            int current = A.get(i + windowSize - 1), prev = A.get(i - 1);
            if (current > B) tempCount++;
            if (prev > B) tempCount--;

            currentCount = Math.min(currentCount, tempCount);
        }
        return currentCount;
    }
}
