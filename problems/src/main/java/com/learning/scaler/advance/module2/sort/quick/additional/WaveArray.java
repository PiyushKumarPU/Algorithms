package com.learning.scaler.advance.module2.sort.quick.additional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Problem Description
    Given an array of integers A, sort the array into a wave-like array and return it.
    In other words, arrange the elements into a sequence such that
    a1 >= a2 <= a3 >= a4 <= a5.....
    NOTE: If multiple answers are possible, return the lexicographically smallest one.

Problem Constraints
    1 <= len(A) <= 10^6
    0 <= A[i] <= 10^6

Input Format
    The first argument is an integer array A.

Output Format
    Return an array arranged in the sequence as described.

Example Input
    Input 1:
    A = [1, 2, 3, 4]
    Input 2:
    A = [1, 2]

Example Output
    Output 1:
    [2, 1, 4, 3]
    Output 2:
    [2, 1]

Example Explanation
    Explanation 1:
    One possible answer : [2, 1, 4, 3]
    Another possible answer : [4, 1, 3, 2]
    First answer is lexicographically smallest. So, return [2, 1, 4, 3].
    Explanation 2:
    Only possible answer is [2, 1].
* */
public class WaveArray {

    public static void main(String[] args) {
        System.out.println(wave(new ArrayList<>(List.of(1, 2, 3, 4))));
        System.out.println(wave(new ArrayList<>(List.of(1, 2))));
    }

    public static ArrayList<Integer> waveSelf(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>(A.size());
        A.sort(Comparator.naturalOrder());
        for (int index = 0; index < A.size(); ) {
            if (index + 1 < A.size())
                result.add(A.get(index + 1));
            result.add(A.get(index));
            index += 2;
        }
        return result;
    }

    /*Scaler solution*/
    public static ArrayList<Integer> wave(ArrayList<Integer> A) {
        // sort the array
        Collections.sort(A);
        int n = A.size();
        // swap adjacent elements in pairs
        for (int i = 2; i <= n; i += 2) {
            exchange(A, i - 2, i - 1);
        }
        return A;
    }

    private static void exchange(ArrayList<Integer> A, int i, int j) {
        int temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, temp);
    }
}
