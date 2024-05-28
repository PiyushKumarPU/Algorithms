package com.learning.scaler.advance.module3.linkedlist1.assignment;

import com.learning.scaler.advance.module3.ListNode;

public class PalindromeList {

    public int lPalin(ListNode A) {
        if (A == null || A.next == null) return 1;
        ListNode reverse = reverse(A);
        while (A != null) {
            if (A.val != reverse.val) return 0;
            A = A.next;
            reverse = reverse.next;
        }
        return 1;
    }

    private ListNode reverse(ListNode A) {
        ListNode current = null;
        ListNode temp = A;
        while (temp != null) {
            ListNode newNode = new ListNode(temp.val);
            if (current == null) current = newNode;
            else {
                newNode.next = current;
                current = newNode;
            }
        }
        return current;
    }
}
