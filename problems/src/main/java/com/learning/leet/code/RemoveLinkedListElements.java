package com.learning.leet.code;

import com.learning.scaler.advance.module3.ListNode;

public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null || val <= 0) return head;
        ListNode temp = head, prev = null;
        while (temp != null) {
            prev = temp;
            if (temp.val == val) {

            }
        }

        return null;
    }

}
