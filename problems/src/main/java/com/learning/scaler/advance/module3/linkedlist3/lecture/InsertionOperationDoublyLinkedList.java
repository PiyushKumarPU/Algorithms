package com.learning.scaler.advance.module3.linkedlist3.lecture;

import com.learning.scaler.advance.module3.DoublyLinkedList;

public class InsertionOperationDoublyLinkedList {
    public DoublyLinkedList insertNode(DoublyLinkedList head, int k, int newVal) {
        DoublyLinkedList newNode = new DoublyLinkedList(newVal);
        if (head == null) return newNode;
        else if (k < 0) return head;
        if (k == 0) {
            newNode.next = head;
            head.prev = newNode;
            return newNode;
        } else {
            // jump till k-1 th place
            int jump = 0;
            DoublyLinkedList temp = head;
            while (jump <= k - 1) {
                temp = temp.next;
                jump++;
            }
            newNode.prev = temp;
            newNode.next = temp.next;
            if (temp.next != null) {
                temp.next.prev = newNode;
            }
            temp.next = newNode;
        }
        return head;
    }


}
