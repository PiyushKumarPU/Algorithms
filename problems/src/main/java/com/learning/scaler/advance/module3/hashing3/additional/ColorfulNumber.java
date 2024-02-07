package com.learning.scaler.advance.module3.hashing3.additional;

import java.util.*;

/*
Problem Description
    Given a number A, find if it is COLORFUL number or not.
    If number A is a COLORFUL number return 1 else, return 0.
    What is a COLORFUL Number:
    A number can be broken into different consecutive sequence of digits.
    The number 3245 can be broken into sequences like 3, 2, 4, 5, 32, 24, 45, 324, 245 and 3245.
    This number is a COLORFUL number, since the product of every consecutive sequence of digits is different

Problem Constraints
    1 <= A <= 2 * 10^9

Input Format
    The first and only argument is an integer A.

Output Format
    Return 1 if integer A is COLORFUL else return 0.

Example Input
    Input 1:
        A = 23
    Input 2:
        A = 236

Example Output
    Output 1:
        1
    Output 2:
        0

Example Explanation
    Explanation 1:
         Possible Sub-sequences: [2, 3, 23] where
         2 -> 2
         3 -> 3
         23 -> 6  (product of digits)
         This number is a COLORFUL number since product of every digit of a sub-sequence are different.
    Explanation 2:
         Possible Sub-sequences: [2, 3, 6, 23, 36, 236] where
         2 -> 2
         3 -> 3
         6 -> 6
         23 -> 6  (product of digits)
         36 -> 18  (product of digits)
         236 -> 36  (product of digits)
         This number is not a COLORFUL number since the product sequence 23  and sequence 6 is same.
* */
public class ColorfulNumber {

    public static void main(String[] args) {
        int A = 123;
        ArrayList<Integer> digits = new ArrayList<>();
        int temp = A;
        while (temp > 0) {
            int digit = temp % 10;
            digits.add(0, digit);
            temp /= 10;
        }
        System.out.println(digits);
    }

    public static int colorful(int A) {
        HashSet<Long> productSet = new HashSet<>();
        ArrayList<Integer> digits = new ArrayList<>();
        int temp = A;
        while (temp > 0) {
            int digit = temp % 10;
            if (digits.contains(digit)) return 0;
            digits.add(0, digit);
            productSet.add((long) digit);
            temp /= 10;
        }
        if (digits.contains(0)) return 0;
        int size = digits.size();
        for (int index = 0; index < size; index++) {
            int start = 0, end = start + index + 1;
            while (end < size) {
                long currentProd = 1;
                for (int ele = start; ele <= end; ele++)
                    currentProd *= digits.get(ele);
                if (productSet.contains(currentProd)) return 0;
                productSet.add(currentProd);
                start++;
                end++;
            }
        }
        return 1;
    }

    public int colorfulScaler(int A) {
        HashSet<Integer> hashSet = new HashSet<>();
        ArrayList<Integer> numbers = new ArrayList<>();
        while (A != 0) {
            int num = A % 10;
            numbers.add(num);
            A /= 10;
        }
        Collections.reverse(numbers);
        int n = numbers.size();
        for (int i = 0; i < n; i++) {
            int prod = 1;
            for (int j = i; j < n; j++) {
                // prod stores the product of every digit in the range [i..j]
                prod *= numbers.get(j);
                // check if the product is unique
                if (hashSet.contains(prod))
                    return 0;
                hashSet.add(prod);
            }
        }
        return 1;
    }
}
