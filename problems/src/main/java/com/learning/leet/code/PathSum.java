package com.learning.leet.code;

import com.learning.scaler.advance.module3.TreeNode;

public class PathSum {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2);
        root.right = new TreeNode(-3);
        PathSum sum = new PathSum();
        System.out.println(sum.hasPathSum(root, -5));
    }

    boolean hasPathSum = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        isPathSumPresent(root, targetSum);
        return hasPathSum;
    }

    private void isPathSumPresent(TreeNode root, int target) {
        if (root == null || hasPathSum) return;
        boolean isLeafNode = root.left == null && root.right == null;
        if (isLeafNode && target - root.val == 0) hasPathSum = true;
        if (!hasPathSum) {
            if (root.left != null)
                isPathSumPresent(root.left, target - root.val);
            if (root.right != null)
                isPathSumPresent(root.right, target - root.val);
        }
    }
}
