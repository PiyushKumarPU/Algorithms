package com.learning.scaler.intermediate.sorting.basics.assignment;


import java.util.ArrayList;

/*
Problem Description
    Given an integer array A, find if an integer p exists in the array such that the number of integers greater than p in the array equals p.

Problem Constraints
    1 <= |A| <= 2*10^5
    -10^8 <= A[i] <= 10^8

Input Format
    First and only argument is an integer array A.

Output Format
    Return 1 if any such integer p is present else, return -1.

Example Input
    Input 1:
         A = [3, 2, 1, 3]
    Input 2:
         A = [1, 1, 3, 3]

Example Output
    Output 1:
         1
    Output 2:
         -1

Example Explanation
    Explanation 1:
         For integer 2, there are 2 greater elements in the array.
    Explanation 2:
         There exist no integer satisfying the required conditions.
* */

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/*
Problem Description
    Given an integer array A, find if an integer p exists in the array such that the number of
    integers greater than p in the array equals p.

Problem Constraints
    1 <= |A| <= 2*10^5
    -10^8 <= A[i] <= 10^8

Input Format
    First and only argument is an integer array A.

Output Format
    Return 1 if any such integer p is present else, return -1.

Example Input
    Input 1:
         A = [3, 2, 1, 3]
    Input 2:
         A = [1, 1, 3, 3]

Example Output
    Output 1:
         1
    Output 2:
         -1

Example Explanation
    Explanation 1:
         For integer 2, there are 2 greater elements in the array.
    Explanation 2:
         There exist no integer satisfying the required conditions.
* */
public class NobleInteger {

    public static void main(String[] args) {

    }

    public int solve(ArrayList<Integer> A) {
        int result = 0;
        List<Integer> sorted = A.stream().sorted(Comparator.reverseOrder())
                .toList();
        int currentCount = 0;
        for (int index = 1; index < sorted.size(); index++) {
            if(Objects.equals(sorted.get(index), sorted.get(index - 1))){
                if(index == currentCount) result++;
            }else{
                if(index == sorted.get(index)) result++;
                currentCount = index;
            }
        }
        return result == 0 ? -1 : result;
    }
}
