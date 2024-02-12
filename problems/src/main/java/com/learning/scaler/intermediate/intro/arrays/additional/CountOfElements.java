package com.learning.scaler.intermediate.intro.arrays.additional;

import java.util.ArrayList;

/*
Problem Description
Given an array A of N integers.
Count the number of elements that have at least 1 elements greater than itself.


Problem Constraints
1 <= N <= 105
1 <= A[i] <= 109


Input Format
First and only argument is an array of integers A.


Output Format
Return the count of elements.


Example Input
Input 1:
A = [3, 1, 2]
Input 2:
A = [5, 5, 3]


Example Output
Output 1:
2
Output 2:
1


Example Explanation
Explanation 1:
The elements that have at least 1 element greater than itself are 1 and 2
Explanation 2:
The elements that have at least 1 element greater than itself is 3
* */
public class CountOfElements {

    public int solve(ArrayList<Integer> A) {
        if (A.isEmpty() || A.size() == 1) return 0;
        int count = 0, max = A.get(0);
        // find maxElement;
        for (int ele : A) {
            max = Math.max(max, ele);
        }
        // calculate movement of each element less than max
        for (int ele : A) {
            count += ele < max ? 1 : 0;
        }
        return count;
    }
}
