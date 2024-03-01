package com.learning.scaler.advance.module1.array1d.additional;


import java.util.ArrayList;
import java.util.List;

/*
Problem Description
    Given a non-negative number represented as an array of digits, add 1 to the number ( increment the number represented by the digits ).

    The digits are stored such that the most significant digit is at the head of the list.

    NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer. For example: for this problem, the following are some good questions to ask :
        Q: Can the input have 0's before the most significant digit. Or, in other words, is 0 1 2 3 a valid input?
        A: For the purpose of this question, YES
        Q: Can the output have 0's before the most significant digit? Or, in other words, is 0 1 2 4 a valid output?
        A: For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.

Problem Constraints
    1 <= size of the array <= 1000000

Input Format
    First argument is an array of digits.

Output Format
    Return the array of digits after adding one.

Example Input
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

        System.out.println(plusOne(new ArrayList<>(List.of(2, 5, 6, 8, 6, 1, 2, 4, 5))));

    }

    public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        if (A.size() == 1 && A.get(0) == 0) {
            result.add(1);
            return result;
        }
        int startIndex = 0;
        for (Integer integer : A) {
            if (integer == 0) {
                startIndex++;
            } else break;
        }

        int lastIndex = A.size() - 1;
        int carry = 0;
        int currentDigit = A.get(lastIndex) + 1 + carry;
        if (currentDigit > 9) {
            result.add(0, 0);
            carry = 1;
        } else {
            result.add(0, currentDigit);
        }
        for (int i = lastIndex - 1; i >= startIndex; i--) {
            if (carry == 0) result.add(0, A.get(i));
            else {
                currentDigit = A.get(i) + carry;
                if (currentDigit > 9) {
                    currentDigit = 0;
                } else {
                    carry = 0;
                }
                result.add(0, currentDigit);
            }

        }
        if (carry == 1) result.add(0, carry);
        return result;

    }


    public ArrayList<Integer> plusOneOld(ArrayList<Integer> A) {
        if (A.size() == 1 && A.get(0) == 0) return new ArrayList<>(List.of(1));
        ArrayList<Integer> result = new ArrayList<>();
        int size = A.size(), carry = 1;
        int index;
        for (index = 0; index < size; index++) {
            int val = A.get(index);
            if (val > 0) {
                break;
            }
        }
        for (int i = size - 1; i >= index; i--) {
            int sum = A.get(i) + carry;
            if (sum > 9) {
                result.add(0, 0);
            } else {
                result.add(0, sum);
                carry = 0;
            }
        }
        if (carry > 0) result.add(0, carry);
        return result;
    }

    public ArrayList<Integer> plusOneScaler(ArrayList<Integer> A) {
        int carry = 1, num, size = A.size();
        // traversing the digits of the number in reverse order
        for (int i = size - 1; i >= 0; i--) {
            num = A.get(i) + carry;
            carry = 0;
            if (num == 10) {
                num = 0;
                carry = 1;
            }
            A.set(i, num);
        }

        ArrayList<Integer> res = new ArrayList<Integer>();
        if (carry == 1)
            res.add(1);
        for (int x : A) {
            if (x == 0 && res.isEmpty())
                continue;
            res.add(x);
        }
        return res;
    }

}
