package com.learning.scaler.intermediate.sliding.window.assignment;

import java.util.ArrayList;
import java.util.List;

/*
Problem Description
    Given an array A of length N. Also given are integers B and C.
    Return 1 if there exists a subarray with length B having sum C and 0 otherwise

Problem Constraints
    1 <= N <= 10^5
    1 <= A[i] <= 10^4
    1 <= B <= N
    1 <= C <= 10^9

Input Format
    First argument A is an array of integers.
    The remaining arguments B and C are integers

Output Format
    Return 1 if such a subarray exist and 0 otherwise

Example Input
    Input 1:
        A = [4, 3, 2, 6, 1]
        B = 3
        C = 11
    Input 2:
        A = [4, 2, 2, 5, 1]
        B = 4
        C = 6

Example Output
    Output 1:
        1
    Output 2:
        0

Example Explanation
    Explanation 1:
        The subarray [3, 2, 6] is of length 3 and sum 11.
    Explanation 2:
        There are no such subarray.
* */
public class SubarrayWithGivenSumAndLength {

    public static int solve(int[] A, int B, int C) {
        int ans = 0;
        for (int i = 0; i < B; i++) {
            ans += A[i];
        }
        if (ans == C) return 1;
        int startIndex = 1, endIndex = B;
        while (endIndex < A.length) {
            ans = ans - A[startIndex - 1] + A[endIndex];
            if (ans == C) return 1;
            startIndex++;
            endIndex++;
        }
        return 0;
    }

    public int solveScaler(int[] A, int B, int C) {
        int sum = 0;
        for(int i = 0 ; i < A.length ; i++){
            sum += A[i];
            if(i >= B){
                sum -= A[i - B];
            }
            if(sum == C && i >= B - 1){
                return 1;
            }
        }
        return 0;
    }
}
