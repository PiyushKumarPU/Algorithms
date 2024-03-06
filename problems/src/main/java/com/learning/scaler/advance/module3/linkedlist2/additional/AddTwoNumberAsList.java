package com.learning.scaler.advance.module3.linkedlist2.additional;

import com.learning.scaler.advance.module3.ListNode;

import java.math.BigInteger;
import java.util.Objects;

/*
Problem Description
    You are given two linked lists, A and B, representing two non-negative numbers.
    The digits are stored in reverse order, and each of their nodes contains a single digit.
    Add the two numbers and return it as a linked list.

Problem Constraints
    1 <= |A|, |B| <= 10^5

Input Format
    The first argument of input contains a pointer to the head of linked list A.
    The second argument of input contains a pointer to the head of linked list B.

Output Format
    Return a pointer to the head of the required linked list.

Example Input
    Input 1:
        A = [2, 4, 3]
        B = [5, 6, 4]
    Input 2:
        A = [9, 9]
        B = [1]

Example Output
    Output 1:
        [7, 0, 8]
    Output 2:
        [0, 0, 1]

Example Explanation
    Explanation 1:
        A = 342 and B = 465. A + B = 807.
    Explanation 2:
        A = 99 and B = 1. A + B = 100.
* */
public class AddTwoNumberAsList {

    public static ListNode addTwoNumbersSelf(ListNode A, ListNode B) {
        if (A == null && B == null) return null;
        else if (A == null) return B;
        if (B == null) return A;
        int carry = 0;
        ListNode result = new ListNode(0);
        ListNode temp = result;
        while (A != null || B != null || carry > 0) {
            int sum = (A != null ? A.val : 0) + (B != null ? B.val : 0) + carry;
            if (sum > 9) {
                sum = sum % 10;
                carry = 1;
            } else carry = 0;
            temp.next = new ListNode(sum);
            temp = temp.next;
            A = A != null ? A.next : A;
            B = B != null ? B.next : B;
        }
        return result.next;
    }
}
