package com.learning.scaler.advance.module3.linkedlist3.lecture;

import com.learning.scaler.advance.module3.ListNode;

import java.util.HashMap;

public class FindStaringPointOfLoopLinkedList {

    public ListNode hasCycleApproach1(ListNode head) {
        if (head == null) return head;
        HashMap<ListNode, Boolean> visitedNodes = new HashMap<>();
        while (head != null) {
            if (!visitedNodes.getOrDefault(head, false)) {
                visitedNodes.put(head, true);
                head = head.next;
            } else return head;
        }
        return null;
    }

    public ListNode hasCycleApproach2(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
