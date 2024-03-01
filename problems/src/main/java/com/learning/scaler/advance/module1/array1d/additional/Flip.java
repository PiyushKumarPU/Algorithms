package com.learning.scaler.advance.module1.array1d.additional;

import java.util.ArrayList;

/*
Problem Description
    You are given a binary string A(i.e., with characters 0 and 1) consisting of characters A1, A2, ..., AN.
    In a single operation, you can choose two indices, L and R, such that 1 ≤ L ≤ R ≤ N and flip the characters AL, AL+1, ..., AR.
    By flipping, we mean changing character 0 to 1 and vice-versa.
    Your aim is to perform ATMOST one operation such that in the final string number of 1s is maximized.
    If you don't want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R.
    If there are multiple solutions, return the lexicographically smallest pair of L and R.
    NOTE: Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.

Problem Constraints
    1 <= size of string <= 100000

Input Format
    First and only argument is a string A.

Output Format
    Return an array of integers denoting the answer.

Example Input
    Input 1:
        A = "010"
    Input 2:
        A = "111"

Example Output
    Output 1:
        [1, 1]
    Output 2:
        []

Example Explanation
    Explanation 1:
        A = "010"

        Pair of [L, R] | Final string
        _______________|_____________
        [1 1]          | "110"
        [1 2]          | "100"
        [1 3]          | "101"
        [2 2]          | "000"
        [2 3]          | "001"

        We see that two pairs [1, 1] and [1, 3] give same number of 1s in final string. So, we return [1, 1].

    Explanation 2:
        No operation can give us more than three 1s in final string. So, we return empty array [].
* */
public class Flip {

    public int[] flip(String A) {
        int l = 0, r = 0, currentSum = 0, maxSum = 0;
        int[] result = new int[2];
        for (int i = 0; i < A.length(); i++) {
            int val = A.charAt(i) - '0';
            currentSum += val > 0 ? -1 : 1;
            if (currentSum > maxSum) {
                maxSum = currentSum;
                result[0] = l + 1;
                result[1] = r + 1;
            }
            if (currentSum < 0) {
                currentSum = 0;
                l = i + 1;
                r = i + 1;
            } else {
                r++;
            }
        }
        if (maxSum == 0) return new int[]{};
        else return result;
    }

    public ArrayList<Integer> flipScaler(String A) {
        int cur = 0;
        int maxx = 0, l = 0, r = 0;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ans.add(-1);
        ans.add(-1);
        //basic kadane's algorithm implementation
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '1')
                cur--;
            else
                cur++;
            if (cur > maxx) {
                ans.set(0, l + 1);
                ans.set(1, r + 1);
                maxx = cur;
            }
            if (cur < 0) {
                cur = 0;
                l = i + 1;
                r = i + 1;
            } else
                r++;
        }
        if (maxx == 0) {
            return new ArrayList<Integer>();
        } else return ans;
    }
}
