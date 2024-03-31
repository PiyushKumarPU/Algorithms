package com.learning.scaler.advance.module3.stack1.lecture;

import com.learning.scaler.advance.module3.ListNode;

public class StackUsingLinkedList {


    // stack operations
    // push
    // peek
    // pop
    // isEmpty
    // size

    private ListNode head;
    int size = 0;

    public void push(Integer val) {
        ListNode current = new ListNode(val);
        if (head != null) {
            current.next = head;
        }
        head = current;
        size++;
    }

    public Integer peek() {
        if (size > 0)
            return head.val;
        return null;
    }

    public Integer pop() {
        if (size > 0) {
            int currentVal = head.val;
            size--;
            head = head.next;
            return currentVal;
        }
        return null;
    }

    public boolean isEmpty() {
        return size <= 0;
    }

    public int size() {
        return size;
    }


}
