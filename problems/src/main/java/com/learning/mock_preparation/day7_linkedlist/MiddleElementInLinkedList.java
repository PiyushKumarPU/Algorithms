package com.learning.mock_preparation.day7_linkedlist;

import com.learning.scaler.advance.module3.ListNode;

public class MiddleElementInLinkedList {


    // https://www.scaler.com/academy/mentee-dashboard/class/155287/assignment/problems/4370

    public int solve(ListNode A) {
        if (A == null || A.next == null) return 0;
        ListNode slow = A, fast = A;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.val;
    }
}
