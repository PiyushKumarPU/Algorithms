package com.learning.leet.code;

import com.learning.scaler.advance.module3.ListNode;
import com.learning.scaler.advance.module3.ListNodeConstructor;

import java.util.List;

public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        ListNode head = ListNodeConstructor.construct(List.of(1, 2));
        head = removeNthFromEnd(head, 2);
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
            for (int i = 0; i < jumpCount; i++)
                temp = temp.next;
            temp.next = temp.next.next;
        }
        return head;
    }
}
