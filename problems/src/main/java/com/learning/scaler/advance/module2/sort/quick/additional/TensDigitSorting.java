package com.learning.scaler.advance.module2.sort.quick.additional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
Problem Description
    Given an array A of N integers. Sort the array in increasing order of the value at the tens place
    digit of every number.

    If a number has no tens digit, we can assume value to be 0.
    If 2 numbers have same tens digit, in that case number with max value will come first
    Solution should be based on comparator.

Problem Constraints
    1 <= N <= 10^5
    1 <= A[i] <= 10^9

Input Format
    First argument A is an array of integers.

Output Format
    Return the array after sorting

Example Input
    Input 1:
    A = [15, 11, 7, 19]
    Input 2:
    A = [2, 24, 22, 19]

Example Output
    Output 1:
    [7, 19, 15, 11]
    Output 2:
    [2, 19, 24, 22]

Example Explanation
    For Input 1:
    The sorted order is [7, 19, 15, 11]. The tens digit of 7 is 0,
    and that of 19, 15 and 11 is 1.
    For Input 2:
    The sorted order is [2, 19, 24, 22]. The tens digit of 2 is 0,
    that of 19 is 1 and that of 22 and 24 is 2.
* */
public class TensDigitSorting {

    public static void main(String[] args) {

    }


    public static ArrayList<Integer> self(ArrayList<Integer> A) {
        A.sort((o1, o2) -> {
            Integer first = o1, second = o2, firstDigit = 0, secondDigit = 0;
            if(first > 9){
                for(int i = 0; i < 2; i++){
                    firstDigit = first % 10;
                    first /= 10;
                }
            }
            if(second > 9){
                for(int i = 0; i < 2; i++){
                    secondDigit = second % 10;
                    second /= 10;
                }
            }
            return firstDigit.equals(secondDigit) ? o2.compareTo(o1) : firstDigit.compareTo(secondDigit);
        });
        return A;
    }

    /*
    * Scaler solution
    * */
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        A.sort((val1, val2) -> {
            int tens_digit1 = (val1 / 10) % 10, tens_digit2 = (val2 / 10) % 10;
            if (tens_digit1 == tens_digit2) {
                return val2 - val1;
            }
            return tens_digit1 - tens_digit2;
        });
        return A;
    }
}
