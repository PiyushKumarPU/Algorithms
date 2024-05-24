package com.learning.leet.code;

import com.learning.scaler.advance.module3.TreeNode;

import java.util.ArrayList;

public class MinimumAbsoluteDifferenceInBST {
    ArrayList<Integer> result;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        result = new ArrayList<>();
        inorderTraversalWorker(root);
        int minDifference = Integer.MAX_VALUE;
        for (int i = 1; i < result.size(); i++)
            minDifference = Math.min(minDifference, result.get(i) - result.get(i - 1));
        return minDifference;
    }

    private void inorderTraversalWorker(TreeNode treeNode) {
        if (treeNode == null) return;
        inorderTraversalWorker(treeNode.getLeft());
        result.add(treeNode.getVal());
        inorderTraversalWorker(treeNode.getRight());
    }

    public int min = Integer.MAX_VALUE;
    TreeNode prev = null;

    public int getMinimumDifferenceOther(TreeNode root) {
        if (root == null)
            return 0;
        inorder(root);
        return min;
    }

    void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        if (prev != null) {
            min = Math.min(min, Math.abs(root.val - prev.val));
        }
        prev = root;
        inorder(root.right);

    }
}
