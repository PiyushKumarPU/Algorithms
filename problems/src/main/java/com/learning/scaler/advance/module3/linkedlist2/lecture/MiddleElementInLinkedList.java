package com.learning.scaler.advance.module3.linkedlist2.lecture;

import com.learning.scaler.advance.module3.ListNode;

public class MiddleElementInLinkedList {

    public int solve(ListNode A) {
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
