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
        ListNode f7 = new ListNode(3);

        f1.next = f2;
        f2.next = f3;
        f3.next = f4;
        f4.next = f5;
        f5.next = f6;
        f6.next = f7;
        f1.printAll();
        deleteDuplicates(f1).printAll();

    }

    public static ListNode deleteDuplicates(ListNode A) {
        if (A != null && A.next != null) {
            ListNode first = A;
            ListNode second = first.next;
            while (second != null) {
                while (second != null && first.val == second.val) {
                    second = second.next;
                }
                if (second != null) {
                    first.next = second;
                    first = second;
                    second = first.next;
                }else first.next = null;
            }
        }
        return A;
    }


}
