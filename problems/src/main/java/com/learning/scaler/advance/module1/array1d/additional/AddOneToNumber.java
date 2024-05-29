package com.learning.scaler.advance.module1.array1d.additional;


import com.learning.scaler.advance.module3.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/*
Problem Description
    Given a non-negative number represented as an array of digits, add 1 to the number(increment the number represented by the digits).

    The digits are stored such that the most significant digit is at the head of the list.

    NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer.
    For example, for this problem, the following are some good questions to ask :
        Q: Can the input have 0's before the most significant digit. Or, in other words, is 0 1 2 3 a valid input?
        A: For the purpose of this question, YES
        Q: Can the output have 0's before the most significant digit? Or, in other words, is 0 1 2 4 a valid output?
        A: For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.

Problem Constraints
    1 <= size of the array <= 1000000

Input Format
    First argument is an array of digits.

Output Format
    Returns the array of digits after adding one.

Example
    Input 1:
        [1, 2, 3]

Example Output
    Output 1:
        [1, 2, 4]

Example Explanation
Explanation 1:
    Given vector is [1, 2, 3].
        The returned vector should be [1, 2, 4] as 123 + 1 = 124.
* */
public class AddOneToNumber {

    public static void main(String[] args) {
        System.out.println(plusOne(new ArrayList<>(List.of(2, 5, 6, 8, 6, 1, 2, 4, 6))));

    }

    public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        if (A == null) return result;
        int length = A.size();
        if (length == 1 && A.get(0) < 9) {
            result.add(A.get(0) + 1);
            return result;
        }
        int start = 0, carry = 1;
        while (start < length && A.get(start) == 0) start++;
        for (int i = length - 1; i >= start; i--) {
            int sum = carry + A.get(i);
            carry = sum / 10;
            sum = sum % 10;
            result.add(sum);
        }
        if (carry > 0) result.add(carry);
        Collections.reverse(result);
        return result;
    }

}
