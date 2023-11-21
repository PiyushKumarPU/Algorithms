package com.learning.scaler.advance.module2.binary_search.bs_answers.assignment;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
Problem Description
Farmer John has built a new long barn with N stalls. Given an array of integers A of size N where each element of the array represents the location of the stall and an integer B which represents the number of cows.

His cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, John wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?



Problem Constraints
2 <= N <= 100000
0 <= A[i] <= 109
2 <= B <= N



Input Format
The first argument given is the integer array A.
The second argument given is the integer B.



Output Format
Return the largest minimum distance possible among the cows.



Example Input
Input 1:

A = [1, 2, 3, 4, 5]
B = 3
Input 2:

A = [1, 2]
B = 2


Example Output
Output 1:

 2
Output 2:

 1


Example Explanation
Explanation 1:

 John can assign the stalls at location 1, 3 and 5 to the 3 cows respectively. So the minimum distance will be 2.
Explanation 2:

 The minimum distance will be 1.
* */
public class AggressiveCows {

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        System.out.println(placeCows(input, 3));
        // System.out.println(solve(List.of(1, 2), 2));
    }

    public static int placeCows(ArrayList<Integer> A, int B) {
        A.sort(Comparator.naturalOrder());
        int start = Integer.MAX_VALUE, end = A.get(A.size() - 1) - A.get(0), ans = 0;
        for (int i = 1; i < A.size(); i++) start = Math.min(start, (A.get(i) - A.get(i - 1)));
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isValidDistance(mid, A, B)) {
                ans = mid;
                start = mid + 1;
            } else end = mid - 1;
        }
        return ans;
    }

    private static boolean isValidDistance(int mid, ArrayList<Integer> distance, int cowCount) {
        int currentCount = 1, position = distance.get(0);
        for (int i = 1; i < distance.size(); i++) {
            if(distance.get(i) - position >= mid){
                currentCount++;
                position = distance.get(i);
                if(cowCount == currentCount) return true;
            }
        }
        return false;
    }
}
