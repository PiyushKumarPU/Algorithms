package com.learning.leet.code;

import com.learning.scaler.advance.module3.ListNode;
import com.learning.scaler.advance.module3.ListNodeConstructor;

import java.util.List;

public class RotateList {

    public static void main(String[] args) {
        ListNode head = ListNodeConstructor.construct(List.of(1, 2));
        head = new RotateList().rotateRight(head, 5);
        head.printAll();
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        int n = 0;
        for (; cur != null; cur = cur.next) {
            n++;
        }
        k %= n;
        if (k == 0) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (k-- > 0) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode ans = slow.next;
        slow.next = null;
        fast.next = head;
        return ans;
    }
}
