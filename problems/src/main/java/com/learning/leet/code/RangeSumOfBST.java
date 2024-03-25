package com.learning.leet.code;

import com.learning.scaler.advance.module3.TreeNode;

public class RangeSumOfBST {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;
        if (root.val > low && root.val > high) {
            return sumRange(root.left, low, high);
        } else if (root.val < low && root.val < high) {
            return sumRange(root.right, low, high);
        } else {
            // find low in a left
            int currentSum = 0;
            TreeNode left = root.left;
            if (left != null && left.val != low) {
                currentSum += left.val;
                if (left.val > low) left = left.left;
                else left = left.right;
            }
            if (left == null) return 0;
            // find high in right
            TreeNode right = root.right;
            if (right != null && right.val != high) {
                currentSum += right.val;
                if (right.val > high) right = left.left;
                else right = right.right;
            }
            if (right == null) return 0;
            currentSum += right.val;
            return currentSum;
        }
    }

    private int sumRange(TreeNode root, int low, int high) {
        // find low and traverse till high
        while (root != null && root.val != low) {
            if (root.val > low) root = root.left;
            else root = root.right;
        }
        if (root != null) {
            int currentSum = 0;
            while (root != null && root.val != high) {
                currentSum += root.val;
                if (root.val > high) root = root.left;
                else root = root.right;
            }
            if (root == null) return 0;
            currentSum += root.val;
            return currentSum;
        }
        return 0;
    }
}
