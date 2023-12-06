package com.learning.scaler.advance.module3.linkedlist1.additional;

import com.learning.scaler.advance.module3.ListNode;

/*
Problem Description
Given a linked list A, remove the B-th node from the end of the list and return its head. For example, Given linked list: 1->2->3->4->5, and B = 2. After removing the second node from the end, the linked list becomes 1->2->3->5. NOTE: If B is greater than the size of the list, remove the first node of the list. NOTE: Try doing it using constant additional space.


Problem Constraints
1 <= |A| <= 106


Input Format
The first argument of input contains a pointer to the head of the linked list. The second argument of input contains the integer B.


Output Format
Return the head of the linked list after deleting the B-th element from the end.


Example Input
Input 1:
A = 1->2->3->4->5
B = 2
Input 2:
A = 1
B = 1


Example Output
Output 1:
1->2->3->5
Output 2:



Example Explanation
Explanation 1:
In the first example, 4 is the second last element.
Explanation 2:
In the second example, 1 is the first and the last element.
* */
public class RemoveBthNodeFromLast {

    public static void main(String[] args) {

        ListNode fifth = new ListNode(5);
        ListNode fourth = new ListNode(4);
        ListNode third = new ListNode(3);
        ListNode second = new ListNode(2);

        ListNode head = new ListNode(1);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        printList(head);
        head = removeNthFromEnd(head,1);
        printList(head);

    }

    public static ListNode removeNthFromEnd(ListNode A, int B) {
        if (A == null) return A;
        int size = 1;
        ListNode next = A.next;
        while (next != null) {
            size++;
            next = next.next;
        }
        if (B >= size) return A.next;
        int position = size - B;
        next = A;
        while (position > 0) {
            assert next != null;
            next = next.next;
            position--;
        }
        assert next != null;
        ListNode nodeToRemove = next.next;
        next.next = nodeToRemove != null ? nodeToRemove.next : null;
        return A;
    }

    public static void printList(ListNode A) {
        ListNode temp = A;
        while (temp != null) {
            System.out.print(" " + temp);
            temp = temp.next;
        }
        System.out.println();
    }
}
