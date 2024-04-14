package com.learning.mock_preparation.day2_bitmanipulation;


/*
Problem Description
    Given an array of integers, every element appears thrice except for one, which occurs once.
    Find that element that does not appear thrice.
    NOTE: Your algorithm should have a linear runtime complexity.
    Could you implement it without using extra memory?

Problem Constraints
    2 <= A <= 5*10^6
    0 <= A <= INTMAX

Input Format
    First and only argument of input contains an integer array A.

Output Format
    Returns a single integer.

Example
    Input 1:
         A = [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
    Input 2:
         A = [0, 0, 0, 1]

Example
    Output 1:
         4
    Output 2:
         1

Example
Explanation 1:
     4 occurs exactly once in Input 1.
     1 occurs exactly once in Input 2.
* */
public class SingleNumberII {
    // https://www.scaler.com/academy/mentee-dashboard/class/126661/assignment/problems?navref=cl_tb_br
    public int singleNumber(final int[] A) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int setBitCount = 0, posBit = 1 << i;
            for (int ele : A) {
                if ((ele & posBit) > 0) setBitCount++;
            }
            if (setBitCount % 3 > 0) {
                result += (int) Math.pow(2, i);
            }
        }
        return result;
    }
}