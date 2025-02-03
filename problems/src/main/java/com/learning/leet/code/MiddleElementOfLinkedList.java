package com.learning.leet.code;

import com.learning.scaler.advance.module3.ListNode;

public class MiddleElementOfLinkedList {


    // BF find length and find middle of it

    // using fast and slow pointer
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
