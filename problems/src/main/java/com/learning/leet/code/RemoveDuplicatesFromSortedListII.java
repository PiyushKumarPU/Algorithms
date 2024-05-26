package com.learning.leet.code;

import com.learning.scaler.advance.module3.ListNode;
import com.learning.scaler.advance.module3.ListNodeConstructor;

import java.util.List;

public class RemoveDuplicatesFromSortedListII {

    public static void main(String[] args) {
        ListNode root = ListNodeConstructor.construct(List.of(1, 1, 1, 2, 3));
        ListNode removed = deleteDuplicates(root);
        assert removed != null;
        removed.printAll();
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        ListNode temp = head;
        while (temp != null) {
            if (temp.next != null && temp.val == temp.next.val) {
                ListNode remove = temp;
                while (remove != null && remove.val == temp.val) remove = remove.next;
                temp = remove;
            } else {
                current.next = new ListNode(temp.val);
                temp = temp.next;
                current = current.next;
            }
        }
        return dummy.next;

    }
}
