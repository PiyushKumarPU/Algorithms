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

    public static ListNode reverseList(ListNode A) {
        return reverseList(A, true);
    }

    public static ListNode reverseList(ListNode B, boolean isCloneRequired) {
        ListNode A = isCloneRequired ? cloneListNode(B) : B;
        if (A == null || A.next == null) return A;
        ListNode current = A;
        ListNode next, prev = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static ListNode reverseList(ListNode A, int count) {
        if (A == null)
            return null;
        ListNode node = A, prev = null, temp;
        while (node != null && count > 0) {
            temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
            count--;
        }
        A.next = node;
        return prev;
    }
}
