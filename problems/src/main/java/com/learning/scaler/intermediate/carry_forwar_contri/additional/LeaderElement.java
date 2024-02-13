package com.learning.scaler.intermediate.carry_forwar_contri.additional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Problem Description
    Given an integer array A containing N distinct integers, you have to find all the leaders in array A.
    An element is a leader if it is strictly greater than all the elements to its right side.
NOTE: The rightmost element is always a leader.

Problem Constraints
    1 <= N <= 10^5
    1 <= A[i] <= 10^8

Input Format
    There is a single input argument which a integer array A

Output Format
    Return an integer array denoting all the leader elements of the array.

Example Input
    Input 1:
        A = [16, 17, 4, 3, 5, 2]
    Input 2:
        A = [5, 4]

Example Output
    Output 1:
        [17, 2, 5]
    Output 2:
        [5, 4]

Example Explanation
    Explanation 1:
         Element 17 is strictly greater than all the elements on the right side to it.
         Element 2 is strictly greater than all the elements on the right side to it.
         Element 5 is strictly greater than all the elements on the right side to it.
         So we will return these three elements i.e [17, 2, 5], we can also return [2, 5, 17] or [5, 2, 17] or any other ordering.
    Explanation 2:
         Element 5 is strictly greater than all the elements on the right side to it.
         Element 4 is strictly greater than all the elements on the right side to it.
         So we will return these two elements i.e [5, 4], we can also any other ordering.
* */
public class LeaderElement {

    public static void main(String[] args) {
        ArrayList<Integer> inputs = new ArrayList<>(
                List.of(93, 57, 83, 41, 100, 10, 79, 27, 94, 22, 4, 96, 48, 18, 89, 37, 21, 5, 46, 81, 15, 30, 47, 23, 34, 65, 55, 9, 36, 20, 54, 17, 7, 56, 78, 84, 87, 97, 16, 69, 28, 11, 44, 49, 8, 25, 98, 75, 53, 62, 19, 24, 80, 68, 50, 91, 1, 86, 77, 14, 72, 66, 42, 63, 73, 45, 31, 61, 85, 64, 35, 32, 92, 71, 74, 3, 99, 52, 90, 43, 6, 40, 38, 2, 12, 59, 29, 82, 76, 60, 67, 13, 70, 58, 39, 33, 95, 88, 51, 26)
        );
        System.out.println(solve(inputs));
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        if (A.isEmpty()) return new ArrayList<>();
        int size = A.size();
        int[] preMax = new int[A.size()];
        for (int i = size - 1; i >= 0; i--) {
            preMax[i] = (i <= (size - 2)) ? Math.max(preMax[i + 1], A.get(i)) : A.get(i);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if ((i == size - 1) || A.get(i) >= preMax[i]) result.add(A.get(i));
        }
        return result;
    }

    public static ArrayList<Integer> solveSingleLoop(ArrayList<Integer> A) {
        if (A.isEmpty()) return new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        int size = A.size(), currentMax = A.get(size - 1);
        result.add(A.get(size - 1));

        for (int i = size - 2; i >= 0; i--) {
            if(A.get(i) >= currentMax){
                result.add(A.get(i));
                currentMax = A.get(i);
            }
        }
        return result;
    }


    public static int[] solve(int[] A) {
        List<Integer> integers = new ArrayList<>();
        int arraySize = A.length;
        int[] PFMax = new int[arraySize];
        PFMax[arraySize - 1] = A[arraySize - 1];
        for (int index = arraySize - 2; index >= 0; index--) {
            PFMax[index] = Math.max(PFMax[index + 1], A[index]);
        }
        for (int index = 0; index < arraySize; index++) {
            if (A[index] >= PFMax[index]) integers.add(A[index]);
        }
        int[] result = new int[integers.size()];
        for (int i = 0; i < integers.size(); i++) {
            result[i] = integers.get(i);
        }
        return result;
    }
}
