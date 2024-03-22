package com.learning.leet.code;

import com.learning.scaler.advance.module3.TreeNode;

public class BinaryTreePruning {

    public TreeNode pruneTree(TreeNode root) {
        if (root == null || root.val == 0) return null;
        deleteUnEligibleTreeNode(root);
        return root;
    }

    private void deleteUnEligibleTreeNode(TreeNode root) {
        if (!isEligibleToKeep(root.left)) root.left = null;
        else deleteUnEligibleTreeNode(root.left);
        if (isEligibleToKeep(root.right)) root.right = null;
        else deleteUnEligibleTreeNode(root.right);
    }

    private boolean isEligibleToKeep(TreeNode node) {
        if (node == null) return true;
        return (node.val == 1) && isEligibleToKeep(node.left) && isEligibleToKeep(node.right);
    }
}
