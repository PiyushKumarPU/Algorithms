package com.learning.mock_preparation.day7_linkedlist;

import com.learning.scaler.advance.module3.ListNode;

public class RemoveLoopFromLinkedList {

    // https://www.scaler.com/academy/mentee-dashboard/class/155287/assignment/problems/4226
    public ListNode solve(ListNode A) {
        if (A == null || A.next == null) return A;
        ListNode slow = A, fast = A;
        while (fast != null && fast.next != null) {
            assert slow != null;
            if (slow.next == fast.next.next) {
                slow.next.next = null;
            } else {
                slow = slow.next;
                fast = fast.next.next;
            }
        }
        return A;
    }
}
