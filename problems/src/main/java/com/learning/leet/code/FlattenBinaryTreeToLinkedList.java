package com.learning.leet.code;

import com.learning.scaler.advance.module3.PrintTreeNode;
import com.learning.scaler.advance.module3.TreeNode;

import java.util.ArrayList;

public class FlattenBinaryTreeToLinkedList {

    ArrayList<Integer> result;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        root.left = node2;
        root.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.right = node6;
        node5.left = null;

        new FlattenBinaryTreeToLinkedList().flatten(root);
    }

    public void flatten(TreeNode root) {
        if (root == null) return;
        result = new ArrayList<>();
        preOrderWorker(root);
        root = new TreeNode(result.get(0));
        TreeNode temp = root;
        for (int i = 1; i < result.size(); i++) {
            temp.right = new TreeNode(result.get(i));
            temp.left = null;
            temp = temp.right;
        }

        PrintTreeNode.printLevelOrder(root);
    }

    public void flattenNoSpace(TreeNode root) {
        if (root == null) return;

        TreeNode current = root;
        while (current != null) {
            if (current.left != null) {
                // Find the rightmost node of the left subtree
                TreeNode rightmost = current.left;
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }

                // Connect the right subtree of the current node to the rightmost node of the left subtree
                rightmost.right = current.right;

                // Move the left subtree to the right and set the left child to null
                current.right = current.left;
                current.left = null;
            }
            // Move on to the right subtree
            current = current.right;
        }
    }

    void preOrderWorker(TreeNode treeNode) {
        if (treeNode == null) return;
        result.add(treeNode.val);
        preOrderWorker(treeNode.left);
        preOrderWorker(treeNode.right);
    }

}
