package com.learning.scaler.advance.module2.binary_search.problems.assignment;

import java.lang.annotation.Target;

/*
Problem Description
    You are given three positive integers, A, B, and C.
    Any positive integer is magical if divisible by either B or C.
    Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.
    Note: Ensure to prevent integer overflow while calculating.

Problem Constraints
    1 <= A <= 10^9
    2 <= B, C <= 40000

Input Format
    The first argument given is an integer A.
    The second argument given is an integer B.
    The third argument given is an integer C.

Output Format
    Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.

Example Input
    Input 1:
        A = 1
        B = 2
        C = 3
    Input 2:
        A = 4
        B = 2
        C = 3

Example Output
    Output 1:
        2
    Output 2:
        6

Example Explanation
    Explanation 1:
        1st magical number is 2.
    Explanation 2:
        First four magical numbers are 2, 3, 4, 6 so the 4th magical number is 6.
* */
public class AthMagicalNumber {

    public static void main(String[] args) {
        //System.out.println(solve(11, 2, 3));
        System.out.println(solve(807414236, 3788, 38141));
        //System.out.println(solve(2,10,11));

    }

    public static int solve(int A, int B, int C) {
        long ans = 0, lcm = findLCM(B, C);
        long start = 1, end = (long) A * Math.min(B, C);
        while (start <= end) {
            long mid = start + (end - start) / 2;
            long count = (mid / B) + (mid / C) - (mid / lcm);
            if (count >= A) {
                ans = (mid % 1000000007);
                end = mid - 1;
            } else if (count < mid) {
                start = mid + 1;
            }
        }
        return (int) ans;
    }

    private static int findLCM(int a, int b) {
        int greater = Math.max(a, b);
        int smallest = Math.min(a, b);
        for (int i = greater; ; i += greater) {
            if (i % smallest == 0)
                return i;
        }
    }
}
