package com.learning.scaler.intermediate.intro.arrays.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Problem Description
    Given an integer array A of size N and an integer B, you have to return the same array after rotating it
    B times towards the right.

Problem Constraints
    1 <= N <= 10^5
    1 <= A[i] <=10^9
    1 <= B <= 10^9

Input Format
    The first argument given is the integer array A.
    The second argument given is the integer B.

Output Format
    Return the array A after rotating it B times to the right

Example Input
    Input 1:
        A = [1, 2, 3, 4]
        B = 2
    Input 2:
        A = [2, 5, 6]
        B = 1

Example Output
    Output 1:
        [3, 4, 1, 2]
    Output 2:
        [6, 2, 5]

Example Explanation
    Explanation 1:
        Rotate towards the right 2 times - [1, 2, 3, 4] => [4, 1, 2, 3] => [3, 4, 1, 2]
    Explanation 2:
        Rotate towards the right 1 time - [2, 5, 6] => [6, 2, 5]
* */
public class ArrayRotation {

    public static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        if (A.isEmpty() || B <= 0 || B == A.size()) return A;
        int size = A.size();
        B = B % size;
        while (B > 0) {
            int temp = A.get(size - 1);
            A.remove(size - 1);
            A.add(0, temp);
            B--;
        }
        return A;
    }

}
