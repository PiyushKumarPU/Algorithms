package com.learning.mock_preparation.day3_sorting;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
Problem Description
    Given two sorted integer arrays A and B, merge B and A as one sorted array and return it as an output.
    Note: A linear time complexity is expected and you should avoid use of any library function.

Problem Constraints
    -2×10^9 <= A[i], B[i] <= 2×10^9
    1 <= |A|, |B| <= 5×10^4

Input Format
    First Argument is a 1-D array representing A.
    Second Argument is also a 1-D array representing B.

Output Format
    Return a 1-D vector which you got after merging A and B.

Example Input
    Input 1:
        A = [4, 7, 9]
        B = [2, 11, 19]
    Input 2:
        A = [1]
        B = [2]

Example Output
    Output 1:
        [2, 4, 7, 9, 11, 19]
    Output 2:
        [1, 2]

Example Explanation
    Explanation 1:
        Merging A and B produces the output as described above.
    Explanation 2:
         Merging A and B produces the output as described above.
* */
public class MergeTwoSortedArrays {

    public static void main(String[] args) {
        List<Integer> A = List.of(4, 7, 9);
        List<Integer> B = List.of(2, 11, 19);

        System.out.println(solve(A, B));

    }

    // https://www.scaler.com/academy/mentee-dashboard/class/126653/assignment/problems/164?navref=cl_tt_lst_nm
    public static ArrayList<Integer> solve(final List<Integer> A, final List<Integer> B) {
        if (A.isEmpty() && B.isEmpty()) return new ArrayList<>();
        else if (A.isEmpty()) return new ArrayList<>(B);
        else if (B.isEmpty()) return new ArrayList<>(A);
        ArrayList<Integer> result = new ArrayList<>();
        int firstIndex = 0, secondIndex = 0;
        while (firstIndex < A.size() && secondIndex < B.size()) {
            Integer first = A.get(firstIndex), second = B.get(secondIndex);
            if (first > second) {
                result.add(second);
                secondIndex++;
            } else {
                result.add(first);
                firstIndex++;
            }
        }

        if (firstIndex < A.size()) {
            while (firstIndex < A.size()) {
                result.add(A.get(firstIndex));
                firstIndex++;
            }
        }
        if (secondIndex < B.size()) {
            while (secondIndex < B.size()) {
                result.add(B.get(secondIndex));
                secondIndex++;
            }
        }
        return result;
    }

    public ArrayList<Integer> solvePrev(final List<Integer> A, final List<Integer> B) {
        Map<Integer, Integer> mp = new TreeMap<Integer, Integer>();
        for (Integer i : A) {
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }
        for (Integer i : B) {
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer key : mp.keySet()) {
            Integer freq = mp.getOrDefault(key, 0);
            for (int i = 0; i < freq; i++) {
                result.add(key);
            }
        }
        return result;
    }
}
