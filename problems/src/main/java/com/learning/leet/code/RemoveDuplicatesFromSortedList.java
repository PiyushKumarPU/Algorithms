package com.learning.leet.code;

import com.learning.scaler.advance.module3.ListNode;

public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head, temp = head.next;
        while (temp != null) {
            if (temp.val != current.val) {
                current.next = new ListNode(temp.val);
                current = current.next;
            }
            temp = temp.next;
        }
        return head;
    }
}
