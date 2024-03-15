package com.learning.mock_preparation.day7_linkedlist;

import com.learning.scaler.advance.module3.ListNode;

import java.util.HashSet;

public class RemoveLoopFromLinkedList {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode root2 = new ListNode(3);
        ListNode root3 = new ListNode(4);

        root.next = root2;
        root2.next = root3;
        root3.next = root2;

        solve(root).printAll();

    }

    // https://www.scaler.com/academy/mentee-dashboard/class/155287/assignment/problems/4226
    public static ListNode solve(ListNode A) {
        HashSet<ListNode> visitedNodes = new HashSet<>();
        ListNode temp = A;
        while (temp != null) {
            if (visitedNodes.contains(temp)) {
                break;
            } else {
                visitedNodes.add(temp);
                temp = temp.next;
            }
        }

        ListNode next = A;
        while (next != null && next.next != null) {
            if (next.next == temp) {
                next.next = null;
                break;
            }
            next = next.next;
        }
        return next;
    }
}