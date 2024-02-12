package com.learning.scaler.advance.module4.dp1.additional;

import java.util.ArrayList;
import java.util.List;

/*
Problem Description
    You are given an array A of N integers and three integers B, C, and D.
    You have to find the maximum value of A[i]*B + A[j]*C + A[k]*D, where 1 <= i <= j <= k <= N.

Problem Constraints
    1 <= N <= 10^5
    -10000 <= A[i], B, C, D <= 10000

Input Format
    First argument is an array A
    Second argument is an integer B
    Third argument is an integer C
    Fourth argument is an integer D

Output Format
    Return an Integer S, i.e maximum value of (A[i] * B + A[j] * C + A[k] * D), where 1 <= i <= j <= k <= N.

Example Input
    Input 1:
         A = [1, 5, -3, 4, -2]
         B = 2
         C = 1
         D = -1
    Input 2:
         A = [3, 2, 1]
         B = 1
         C = -10
         D = 3

Example Output
    Output 1:
        18
    Output 2:
        -4

Example Explanation
    Explanation 1:
         If you choose i = 2, j = 2, and k = 3 then we will get
         A[2]*B + A[2]*C + A[3]*D = 5*2 + 5*1 + (-3)*(-1) = 10 + 5 + 3 = 18
    Explanation 2:
         If you choose i = 1, j = 3, and k = 3 then we will get
         A[1]*B + A[3]*C + A[3]*D = (3*1) + (-10*1) + (3*1) = 3 - 10 + 3 = -4
*
* */
public class MaximumSumValue {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(1, 5, -3, 4, -2));
        int B = 2, C = 1, D = -1;
        System.out.println(solve(A, B, C, D));
    }

    public static int solve(ArrayList<Integer> A, int B, int C, int D) {
        if (A.isEmpty()) return 0;
        int size = A.size();
        int[] maxI = new int[size];
        int[] maxJ = new int[size];
        int[] preMaxJ = new int[size];
        int[] maxK = new int[size];
        int[] preMaxK = new int[size];

        maxI[0] = A.get(0) * B;
        maxJ[0] = A.get(0) * C;
        maxK[0] = A.get(0) * D;

        for (int i = 1; i < size; i++) {
            int current = A.get(i);
            maxI[i] = Math.max(current * B, maxI[i - 1]);
            maxJ[i] = Math.max(current * C, maxJ[i - 1]);
            maxK[i] = Math.max(current * D, maxK[i - 1]);
        }

        preMaxJ[0] = maxJ[0] + maxI[0];
        preMaxK[0] = maxK[0] + preMaxJ[0];


        // calculate preMaxJ including premaxI
        for (int i = 1; i < size; i++) {
            preMaxJ[i] = maxJ[i] + maxI[i];
        }

        // calculate preMaxK including premaxJ
        for (int i = 1; i < size; i++) {
            preMaxK[i] = maxK[i] + preMaxJ[i];
        }

        // find max of k
        int result = preMaxK[0];
        for (int i = 1; i < size; i++) result = Math.max(result, preMaxK[i]);
        return result;
    }
}
