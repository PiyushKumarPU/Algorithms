package com.learning.leet.code;

import com.learning.scaler.advance.module3.ListNode;
import com.learning.scaler.advance.module3.ListNodeConstructor;

import java.util.List;

public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        ListNode head = ListNodeConstructor.construct(List.of(1, 2, 3, 4, 5));
        head = removeNthFromEndOpt(head, 2);
        assert head != null;
        head.printAll();

        head = ListNodeConstructor.construct(List.of(1));
        head = removeNthFromEndOpt(head, 1);
        assert head != null;
        head.printAll();

        head = ListNodeConstructor.construct(List.of(1, 2));
        head = removeNthFromEndOpt(head, 2);
        assert head != null;
        head.printAll();
    }


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || (head.next == null && n == 1)) return null;
        // find length of the LinkedList
        int nodeCount = 0;
        ListNode temp = head;
        while (temp != null) {
            nodeCount++;
            temp = temp.next;
        }
        int jumpCount = nodeCount - 1 - n;
        temp = head;
        if (jumpCount <= 0) {
            head = head.next;
        } else {
            for (int i = 0; i < jumpCount; i++) {
                assert temp != null;
                temp = temp.next;
            }
            assert temp != null;
            temp.next = temp.next.next;
        }
        return head;
    }

    public static ListNode removeNthFromEndOpt(ListNode head, int n) {
        if (head == null || head.next == null) return null;
        ListNode temp = new ListNode(0), first = head, second = head;
        temp.next = head;
        for (int i = 0; i < n; i++) {
            if (first == null) return null;
            first = first.next;
        }
        if (first == null) {
            return head.next;
        }
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return temp.next;
    }
}
