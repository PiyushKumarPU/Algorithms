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

    public static void main(String[] args) {


        ListNode A1 = new ListNode(1);
        ListNode A2 = new ListNode(4);
        ListNode A3 = new ListNode(3);

        ListNode B1 = new ListNode(9);
        ListNode B2 = new ListNode(9);
        ListNode B3 = new ListNode(9);


        /*A1.next = A2;
        A2.next = A3;*/

        B1.next = B2;
        B2.next = B3;
        Objects.requireNonNull(addTwoNumbers(A1, B1)).printAll();
    }

    public static ListNode addTwoNumbersSelf(ListNode A, ListNode B) {
        ListNode temp1 = A, temp2 = B, current = null, next = null, head = null;
        int firstVal = 0, secondVal = 0, carry = 0;
        StringBuilder finalVal = new StringBuilder();
        while (temp1 != null || temp2 != null) {
            if (temp1 != null) {
                firstVal = temp1.val;
                temp1 = temp1.next;
            } else firstVal = 0;
            if (temp2 != null) {
                secondVal = temp2.val;
                temp2 = temp2.next;
            } else secondVal = 0;
            int sum = firstVal + secondVal + carry;
            int currentDigit = sum;
            if (sum > 9) {
                currentDigit = sum % 10;
                carry = sum / 10;
            } else carry = 0;

            if (head == null) {
                head = new ListNode(currentDigit);
                current = head;
            } else {
                next = new ListNode(currentDigit);
                current.next = next;
                current = next;
            }
        }
        if (carry > 0) {
            next = new ListNode(carry);
            current.next = next;
        }
        return head;
    }

    public static ListNode addTwoNumbers(ListNode A, ListNode B) {
        ListNode node;
        ListNode prev = null, first = null;
        int carry = 0, sum;
        while (A != null || B != null || carry != 0) {
            node = new ListNode(0);
            // finds the value of each node
            sum = carry;
            if (first == null)
                first = node;
            if (prev != null)
                prev.next = node;
            if (A != null) {
                sum += A.val;
                A = A.next;
            }
            if (B != null) {
                sum += B.val;
                B = B.next;
            }
            node.val = sum % 10;
            sum /= 10;
            carry = sum;
            prev = node;
        }
        return first;
    }
}
