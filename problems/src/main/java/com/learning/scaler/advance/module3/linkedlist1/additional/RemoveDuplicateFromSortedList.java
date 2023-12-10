package com.learning.scaler.advance.module3.linkedlist1.additional;

import com.learning.scaler.advance.module3.ListNode;

/*
Problem Description
    Given a sorted linked list, delete all duplicates such that each element appears only once.

Problem Constraints
    0 <= length of linked list <= 10^6

Input Format
    First argument is the head pointer of the linked list.

Output Format
    Return the head pointer of the linked list after removing all duplicates.

Example Input
    Input 1:
        1->1->2
    Input 2:
        1->1->2->3->3

Example Output
    Output 1:
        1->2
    Output 2:
        1->2->3

Example Explanation
    Explanation 1:
        Each element appear only once in 1->2.
* */
public class RemoveDuplicateFromSortedList {

    public static void main(String[] args) {

        ListNode f1 = new ListNode(1);
        ListNode f2 = new ListNode(1);
        ListNode f3 = new ListNode(1);
        ListNode f4 = new ListNode(1);
        ListNode f5 = new ListNode(2);
        ListNode f6 = new ListNode(2);

        f1.next = f2;
        f2.next = f3;
        f3.next = f4;
        f4.next = f5;
        f5.next = f6;
        printAll(f1);
        printAll(deleteDuplicates(f1));

    }

    public static ListNode deleteDuplicates(ListNode A) {
        if (A != null && A.next != null) {
            ListNode to_free;
            if (A.val == A.next.val) {
                to_free = A.next;
                A.next = A.next.next;
                deleteDuplicates(A);
            }
            else {
                deleteDuplicates(A.next);
            }
            return A;
        }
        return A;
    }


    private static void printAll(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
