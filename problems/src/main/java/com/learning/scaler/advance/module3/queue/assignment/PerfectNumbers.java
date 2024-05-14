package com.learning.scaler.advance.module3.queue.assignment;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Problem Description
    Given an integer A, you have to find the Ath Perfect Number.
    A Perfect Number has the following properties:
    It comprises only 1 and 2.
    The number of digits in a Perfect number is even.
    It is a palindrome number.
    For example, 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.

Problem Constraints
    1 <= A <= 100000

Input Format
    The only argument given is an integer A.

Output Format
    Return a string that denotes the Ath Perfect Number.

Example
    Input 1:
         A = 2
    Input 2:
         A = 3

Example
    Output 1:
         22
    Output 2:
         1111

Example
    Explanation 1:
        First four perfect numbers are:
        1. 11
        2. 22
        3. 1111
        4. 1221
         Returns the 2nd Perfect number.
Explanation 2:
    First four perfect numbers are:
    1. 11
    2. 22
    3. 1111
    4. 1221
     Returns the 3rd Perfect number.
* */
public class PerfectNumbers {
    private static List<Integer> result = new ArrayList<>();
    private static int count;

    private static void generatePerfectNumbers(long current) {
        if (count <= 0) return;
        if (isEvenDigitPalindrome(current)) {
            result.add((int) current);
            count--;
        }
        generatePerfectNumbers(current * 10 + 1);
        generatePerfectNumbers(current * 10 + 2);
    }

    private static boolean isEvenDigitPalindrome(long number) {
        String numStr = String.valueOf(number);
        return numStr.length() % 2 == 0 && numStr.equals(new StringBuilder(numStr).reverse().toString());
    }

    private static List<Integer> firstAPerfectNumbers(int A) {
        result.clear();
        count = A;
        generatePerfectNumbers(1);
        return result;
    }

    public static void main(String[] args) {
        int A = 81;
        List<Integer> perfectNumbers = firstAPerfectNumbers(A);
        System.out.println("First " + A + " perfect numbers with even digits that are palindromes:");
        for (int num : perfectNumbers) {
            System.out.println(num);
        }
    }
}
