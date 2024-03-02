package com.learning.scaler.advance.module3.linkedlist2.assignment;

import com.learning.scaler.advance.module3.ListNode;
import com.learning.scaler.advance.module3.ListNodeConstructor;

import java.util.HashSet;
import java.util.List;

/*
Problem Description
    You are given a linked list that contains a loop.
    You need to find the node, which creates a loop and break it by making the node point to NULL.

Problem Constraints
    1 <= number of nodes <= 1000

Input Format
    The first of the input contains a LinkedList, where the first number is the number of nodes N, and the next N nodes are the node value of the linked list.
    The second line of the input contains an integer which denotes the position of node where cycle starts.

Output Format
    return the head of the updated linked list.

Example Input
    Input 1:
        1 -> 2
        ^    |
        | - -
    Input 2:
        3 -> 2 -> 4 -> 5 -> 6
                  ^         |
                  |         |
                  - - - - - -

Example Output
    Output 1:
        1 -> 2 -> NULL
    Output 2:
        3 -> 2 -> 4 -> 5 -> 6 -> NULL

Example Explanation
    Explanation 1:
        Chain of 1->2 is broken.
    Explanation 2:
        Chain of 4->6 is broken.
* */
public class RemoveLoopFromLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node3;

        solveHelp(head).printAll();

    }

    public ListNode solve(ListNode A) {
        if (A == null || A.next == null) return A;
        HashSet<ListNode> visitedSet = new HashSet<>();
        ListNode temp = A;
        while (temp != null) {
            visitedSet.add(temp);
            if (temp.next != null && visitedSet.contains(temp.next)) {
                temp.next = null;
                return A;
            }
            temp = temp.next;
        }
        return A;
    }

    public static ListNode solveHelp(ListNode A) {
        if (A == null || A.next == null) return A;

        ListNode slow = A;
        ListNode fast = A;

        // Detect loop
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        // If there's no loop, return
        if (slow != fast) {
            return A;
        }

        // Move one pointer to the head
        slow = A;

        // Move both pointers one step at a time until they meet again
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }

        // Break the loop
        fast.next = null;
        return A;
    }
}
