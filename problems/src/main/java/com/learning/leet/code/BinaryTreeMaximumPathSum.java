package com.learning.leet.code;

import com.learning.scaler.advance.module3.TreeNode;

public class BinaryTreeMaximumPathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node11 = new TreeNode(11);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        TreeNode node8 = new TreeNode(8);
        TreeNode node13 = new TreeNode(13);
        TreeNode node42 = new TreeNode(4);
        TreeNode node1 = new TreeNode(1);

        root.left = node4;
        root.right = node8;

        node4.left = node11;
        node11.left = node7;
        node11.right = node2;

        node8.left = node13;
        node8.right = node42;
        node42.right = node1;
        System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(root));
    }

    int maxPath;

    public int maxPathSum(TreeNode root) {
        maxPath = Integer.MIN_VALUE;
        calculatePathSum(root);
        return maxPath;
    }

    private int calculatePathSum(TreeNode root) {
        if (root == null) return 0;
        int left = root.left == null ? 0 : calculatePathSum(root.left);
        int right = root.right == null ? 0 : calculatePathSum(root.right);
        int currentMax = root.val;
        currentMax = Math.max(currentMax, root.val + left);
        currentMax = Math.max(currentMax, root.val + right);
        currentMax = Math.max(currentMax, root.val + left + right);
        maxPath = Math.max(maxPath, currentMax);
        return Math.max(root.val + left, root.val + right);
    }
}
