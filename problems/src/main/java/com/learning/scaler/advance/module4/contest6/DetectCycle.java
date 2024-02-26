package com.learning.scaler.advance.module4.contest6;

import com.learning.scaler.advance.module3.ListNode;

import java.util.HashSet;

/*
    Given a linked list, check if the linked list has a loop (cycle) or not.
* */
public class DetectCycle {

    public ListNode detectCycle(ListNode a) {
        HashSet<ListNode> set = new HashSet<>();
        while (a != null) {
            if (set.contains(a)) return a;
            set.add(a);
            a = a.next;
        }
        return null;
    }
}
