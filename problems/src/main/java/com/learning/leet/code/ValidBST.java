package com.learning.leet.code;

import com.learning.scaler.advance.module3.TreeNode;

public class ValidBST {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(-2147483648);
        node.left = new TreeNode(-2147483648);
        System.out.println(isValidBST(node));
    }

    public static boolean isValidBST(TreeNode root) {
        return root == null || isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValidBST(TreeNode A, Long start, Long end) {
        if (A == null) return true;
        boolean isValidRoot = (start < A.val && A.val < end);
        if (isValidRoot) {
            boolean isValidLeft = A.left == null || isValidBST(A.left, start, (long) A.val - 1);
            if (isValidLeft) {
                boolean isValidRight = A.right == null || isValidBST(A.right, (long) A.val + 1, end);
                return isValidRight;
            }
        }
        return false;
    }
}
