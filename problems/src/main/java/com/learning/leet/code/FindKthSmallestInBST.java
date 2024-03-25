package com.learning.leet.code;

import com.learning.scaler.advance.module3.TreeNode;

public class FindKthSmallestInBST {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(4);

        root.left = root1;
        root1.right = root2;
        root.right = root3;

        System.out.println(kthSmallest(root, 1));

    }

    static int count, result = -1;

    public static int kthSmallest(TreeNode root, int k) {
        count = k;
        inOrderTraversal(root);
        return result;
    }

    private static void inOrderTraversal(TreeNode root) {
        if (root == null || result > -1) return;
        inOrderTraversal(root.left);
        count--;
        if (count == 0 && result < 0) result = root.val;
        inOrderTraversal(root.right);
    }
}
