package com.learning.leet.code;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

    public static void main(String[] args) {
        // [[7,null],[13,0],[11,4],[10,2],[1,0]]
        Node root = new Node(7);
        Node node13 = new Node(13);
        Node node11 = new Node(11);
        Node node10 = new Node(10);
        Node node1 = new Node(1);
        Node node4 = new Node(4);
        Node node2 = new Node(2);
        Node node0 = new Node(0);

        root.random = null;
        root.next = node13;
        node13.random = root;
        node13.next = node11;
        node11.random = node4;
        node11.next = node10;
        node10.next = node1;
        node10.random = node2;
        node1.random = node0;

        Node copied = copyRandomList(root);
        while (copied != null) {
            System.out.println("[" + copied + "," + copied.random + "]");
            copied = copied.next;
        }

    }

    public static Node copyRandomList(Node head) {
        Map<Integer, Node> indexNodeMap = new HashMap<>();
        Node dummy = new Node(-1);
        Node current = dummy;
        int index = 0;
        Node temp = head;
        while (temp != null) {
            current.next = new Node(temp.val);
            indexNodeMap.put(index++, current.next);
            current = current.next;
            temp = temp.next;
        }
        // construct random pointer
        temp = head;
        current = dummy.next;
        while (temp != null) {
            if (temp.random != null) {
                current.random = new Node(temp.random.val); // indexNodeMap.get(temp.random.val);
            }
            temp = temp.next;
            current = current.next;
        }
        return dummy.next;
    }

    static class Node {
        int val;
        Node next, random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        @Override
        public String toString() {
            return String.valueOf(this.val);
        }
    }
}
