package com.learning.scaler.advance.module3.linkedlist3.lecture;

import com.learning.scaler.advance.module3.ListNode;

import java.util.HashMap;
import java.util.HashSet;

public class FindCycleInLinkedList {

    public boolean hasCycleApproach1(ListNode list) {
        if (list == null || list.next == null) return false;
        HashMap<ListNode, Boolean> visitedNodes = new HashMap<>();
        while (list != null) {
            if (!visitedNodes.getOrDefault(list, false)) {
                visitedNodes.put(list, true);
                list = list.next;
            } else return true;
        }
        return false;
    }

    public boolean hasCycleApproach2(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) return true;
        }

        return false;
    }
}
