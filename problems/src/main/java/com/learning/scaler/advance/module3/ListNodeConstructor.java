package com.learning.scaler.advance.module3;

import java.util.List;

public class ListNodeConstructor {

    public static ListNode construct(List<Integer> integers) {
        if (integers.isEmpty()) return null;
        ListNode root = new ListNode(integers.get(0));
        ListNode temp = root;
        for (int i = 1; i < integers.size(); i++) {
            ListNode current = new ListNode(integers.get(i));
            temp.next = current;
            temp = current;
        }
        return root;
    }

    public static ListNode cloneListNode(ListNode A) {
        if (A == null) return null;
        ListNode head = new ListNode(A.val);
        ListNode copyHead = head;
        ListNode temp = A.next;
        while (temp != null) {
            head.next = new ListNode(temp.val);
            head = head.next;
            temp = temp.next;
        }
        return copyHead;
    }
}
