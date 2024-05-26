package com.learning.leet.code;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersII {

    public static void main(String[] args) {
        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node7 = new Node(7);

        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node7;

        Node result = connect(root);
        System.out.println(result);
    }

    public static Node connect(Node root) {
        if (root == null || root.left == null || root.right == null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.left != null) {
                current.left.next = current.right;
                queue.offer(current.left);
            }
            if (current.right != null) {
                if (current.next != null) {
                    current.right.next = current.next.left;
                }
                queue.offer(current.right);
            }
        }
        return root;

    }

    static class Node {
        int val;
        Node left, right, next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}


