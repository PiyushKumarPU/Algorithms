package com.learning.scaler.advance.module3.linkedlist2.assignment;

import com.learning.scaler.advance.module3.ListNode;

/*
Problem Description
    Given a linked list of integers, find and return the middle element of the linked list.
    NOTE: If there are N nodes in the linked list and N is even then return the (N/2 + 1)th element.



Problem Constraints
    1 <= length of the linked list <= 100000
    1 <= Node value <= 10^9

Input Format
    The only argument given head pointer of linked list.

Output Format
    Return the middle element of the linked list.

Example Input
    Input 1:
        1 -> 2 -> 3 -> 4 -> 5
    Input 2:
        1 -> 5 -> 6 -> 2 -> 3 -> 4

Example Output
    Output 1:
        3
    Output 2:
        2


Example Explanation
    Explanation 1:
        The middle element is 3.
Explanation 2:
        The middle element in even length linked list of length N is ((N/2) + 1)th element which is 2.
* */
public class MiddleElementOfLinkedList {

    public int solve(ListNode A) {
        int size = 0, start = 1;
        ListNode temp = A;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        temp = A;
        while (start <= (size / 2)) {
            start++;
            temp = temp.next;
        }
        return temp.val;
    }

    public int solveScaler(ListNode A) {
        if (A.next == null)
            return A.val;
        // slow and fast pointer
        ListNode slow = A, fast = A;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.val;
    }
}
