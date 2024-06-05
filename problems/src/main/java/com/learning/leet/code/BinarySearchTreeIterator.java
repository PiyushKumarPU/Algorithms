package com.learning.leet.code;

import com.learning.scaler.advance.module3.ListNode;
import com.learning.scaler.advance.module3.TreeNode;

public class BinarySearchTreeIterator {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        TreeNode node15 = new TreeNode(15);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        root.right = node15;
        node15.left = node9;
        node15.right = node20;

        // "BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"
        BSTIterator iterator = new BSTIterator(root);
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
    }

}

class BSTIterator {

    ListNode dummy = new ListNode(-1);
    ListNode head;

    public BSTIterator(TreeNode root) {
        head = dummy;
        performInorderTraversal(root);
        head = dummy.next;
    }

    public int next() {
        int val = head.val;
        head = head.next;
        return val;
    }

    public boolean hasNext() {
        return head != null;
    }

    private void performInorderTraversal(TreeNode root) {
        if (root == null) return;
        if (root.left != null) performInorderTraversal(root.left);
        // add val in linkedList
        head.next = new ListNode(root.val);
        head = head.next;
        if (root.right != null) performInorderTraversal(root.right);
    }
}

