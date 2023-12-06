package com.learning.scaler.advance.module3.linkedlist1.assignment;

import com.learning.scaler.advance.module3.ListNode;

/*
Problem Description
    You are given a singly linked list having head node A. You have to reverse the linked list and return the head node of that reversed list.
    NOTE: You have to do it in-place and in one-pass.

Problem Constraints
    1 <= Length of linked list <= 10^5

    Value of each node is within the range of a 32-bit integer.

Input Format
    First and only argument is a linked-list node A.

Output Format
    Return a linked-list node denoting the head of the reversed linked list.

Example Input
    Input 1:
    A = 1 -> 2 -> 3 -> 4 -> 5 -> NULL
    Input 2:
    A = 3 -> NULL

Example Output
    Output 1:
    5 -> 4 -> 3 -> 2 -> 1 -> NULL
    Output 2:
    3 -> NULL


Example Explanation
    Explanation 1:
      The linked list has 5 nodes. After reversing them, the list becomes : 5 -> 4 -> 3 -> 2 -> 1 -> NULL
    Expalantion 2:
      The linked list consists of only a single node. After reversing it, the list becomes : 3 -> NULL
* */
public class ReverseLinkedList {

    public static void main(String[] args) {
        reverseList(buildInput1()).printAll();
        reverseList(buildInput2()).printAll();
        System.out.println();
        System.out.println();
    }


    public static ListNode reverseList(ListNode A) {
        if (A == null || A.next == null) return A;
        ListNode current = A;
        ListNode next, prev = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    private static ListNode buildInput1() {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        return head;


    }

    private static ListNode buildInput2() {
        return new ListNode(3);
    }
}
