package com.learning.scaler.advance.module3;

import java.util.List;

public class ListNodeConstructor {

    public static ListNode construct(List<Integer> integers) {
        ListNode root = new ListNode(integers.get(0));
        ListNode temp = root;
        for (int i = 1; i < integers.size(); i++) {
            ListNode current = new ListNode(integers.get(i));
            temp.next = current;
            temp = current;
        }
        return root;
    }
}
