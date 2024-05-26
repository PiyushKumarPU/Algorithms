package com.learning.leet.code;

import com.learning.scaler.advance.module3.ListNode;

import java.util.List;

public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode middle = splitList(head);
        ListNode left = sortList(head);
        ListNode right = sortList(middle);

        return merge(left, right);

    }

    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while (list1 != null || list2 != null) {
            int first = list1 == null ? Integer.MAX_VALUE : list1.val;
            int second = list2 == null ? Integer.MAX_VALUE : list2.val;
            if (first < second) {
                current.next = new ListNode(first);
                current = current.next;
                list1 = list1.next;
            } else if (second < first) {
                current.next = new ListNode(second);
                current = current.next;
                list2 = list2.next;
            } else if (first != Integer.MAX_VALUE) {
                current.next = new ListNode(first);
                current = current.next;
                list1 = list1.next;
                current.next = new ListNode(second);
                current = current.next;
                list2 = list2.next;
            }
        }
        return dummy.next;
    }

    private ListNode splitList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode middle = slow.next;
        slow.next = null;
        return middle;
    }

    // try to understand this solution
    //
    public ListNode sortList2(ListNode head) {
        return sortList(head, null);

    }

    private ListNode sortList(ListNode start, ListNode end) {
        if (start == null || start.next == null || start == end) return start;
        ListNode left = start, right = start, cur = start.next;
        boolean sorted = true;
        while (cur != null && cur != end) {
            ListNode tmp = cur.next;
            if (cur.val < start.val) {
                cur.next = left;
                left = cur;
                right.next = tmp;
                sorted = false;
            } else {
                if (cur.val < right.val) sorted = false;
                right = cur;
            }
            cur = tmp;
        }
        if (sorted) return left;
        left = sortList(left, start);
        start.next = sortList(start.next, end);
        return left;
    }
}
