package com.learning.scaler.advance.module3.linkedlist3.lecture;

import com.learning.scaler.advance.module3.DoublyLinkedList;

public class DeletionOperationDoublyLinkedList {

    public static void main(String[] args) {
        DoublyLinkedList head = new DoublyLinkedList(1);
        DoublyLinkedList head3 = new DoublyLinkedList(3);
        DoublyLinkedList head4 = new DoublyLinkedList(4);

        head.next = head3;
        head3.next = head4;

        head3.prev = head;
        head4.prev = head3;

        DoublyLinkedList deleted = deleteNodeByPosition(head, 3);
        System.out.println(deleted);

    }


    public DoublyLinkedList deleteNode(DoublyLinkedList head, int x) {
        if (head == null) return null;
        // find x node;
        if (x == head.val) {
            if (head.next != null) {
                head.next.prev = null;
            }
            return head.next;
        }
        DoublyLinkedList temp = head;
        while (temp != null && temp.val != x) {
            temp = temp.next;
        }
        if (temp == null) return head;
        else {
            // temp is last node
            if (temp.next == null) {
                temp.prev.next = null;
            } else {
                // temp is in the middle
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
            }
        }
        return head;
    }

    public static DoublyLinkedList deleteNodeByPosition(DoublyLinkedList head, int position) {
        if (head == null) return null;
        if (position == 1) {
            if (head.next != null) {
                head.next.prev = null;
            }
            return head.next;
        }
        DoublyLinkedList temp = head;
        int jump = 1;
        while (temp != null && jump < position) {
            temp = temp.next;
            jump++;
        }
        if (temp == null) return head;
        else {
            // temp is last node
            if (temp.next == null) {
                temp.prev.next = null;
            } else {
                // temp is in the middle
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
            }
        }
        return head;
    }

}
