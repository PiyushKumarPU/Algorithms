package com.learning.leet.code;

import com.learning.scaler.advance.module3.LevelOrderTreeConstruction;
import com.learning.scaler.advance.module3.PrintTreeNode;
import com.learning.scaler.advance.module3.TreeNode;

import java.util.ArrayList;
import java.util.List;

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

    void preOrderWorker(TreeNode treeNode) {
        if (treeNode == null) return;
        result.add(treeNode.val);
        preOrderWorker(treeNode.left);
        preOrderWorker(treeNode.right);
    }

}
