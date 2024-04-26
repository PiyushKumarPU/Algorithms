package com.learning.scaler.advance.module3.tree5.lecture;

import com.learning.scaler.advance.module3.TreeNode;

public class LongestPathAcrossRoot {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(2);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(2);

        root.left = node2;
        node2.left = node3;

        root.right = node4;
        node4.right = node5;
        node5.left = node6;
        node5.right = node7;
        node7.right = node8;

        System.out.println(longestPathAcrossRoot(root));

    }


    public static int longestPathAcrossRoot(TreeNode treeNode) {
        if (treeNode == null) return 0;
        return findHeight(treeNode.left) + findHeight(treeNode.right) + 2;
    }

    private static int findHeight(TreeNode treeNode) {
        if (treeNode == null) return -1;
        return Math.max(findHeight(treeNode.left), findHeight(treeNode.right)) + 1;
    }
}
