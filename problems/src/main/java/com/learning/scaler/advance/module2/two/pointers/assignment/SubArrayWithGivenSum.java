package com.learning.scaler.advance.module2.two.pointers.assignment;

import java.util.ArrayList;
import java.util.List;

/*
Problem Description
Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.

If the answer does not exist return an array with a single integer "-1".

First sub-array means the sub-array for which starting index in minimum.



Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 109
1 <= B <= 109



Input Format
The first argument given is the integer array A.

The second argument given is integer B.



Output Format
Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single integer "-1".



Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
 B = 5
Input 2:

 A = [5, 10, 20, 100, 105]
 B = 110


Example Output
Output 1:

 [2, 3]
Output 2:

 [-1]


Example Explanation
Explanation 1:

 [2, 3] sums up to 5.
Explanation 2:

 No subarray sums up to required number.
* */
public class SubArrayWithGivenSum {

    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<>(List.of(1,1000000000)),1000000000));
        //System.out.println(solve(new ArrayList<>(List.of(5, 10, 20, 100, 105)),110));
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        int start = 0, end = 0, sum = A.get(0);
        ArrayList<Integer> result = new ArrayList<>();
        while (end < A.size()) {
            if (sum == B) {
                for(int i = start; i <= end;i++){
                    result.add(A.get(i));
                }
                return  result;
            } else if (sum < B) {
                end++;
                if (end == (A.size())) break;
                sum += A.get(end);
            } else {
                sum -= A.get(start);
                start++;
                if (start > end && start < A.size() - 1) {
                    end++;
                    sum += A.get(end);
                }
            }
        }
        result.add(-1);
        return result;
    }
}
