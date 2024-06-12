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
        if (head == null) return null;

        Map<Node, Node> nodeMap = new HashMap<>();
        Node current = head;

        // First pass: create all nodes and populate the map
        while (current != null) {
            nodeMap.put(current, new Node(current.val));
            current = current.next;
        }

        current = head;

        // Second pass: assign next and random pointers
        while (current != null) {
            nodeMap.get(current).next = nodeMap.get(current.next);
            nodeMap.get(current).random = nodeMap.get(current.random);
            current = current.next;
        }

        return nodeMap.get(head);
    }

    static class Node {
        int val;
        Node next, random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
