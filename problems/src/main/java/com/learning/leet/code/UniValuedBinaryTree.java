package com.learning.leet.code;

import com.learning.scaler.advance.module3.TreeNode;

public class UniValuedBinaryTree {

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        return isUnivalTree(root, root.val);
    }

    private boolean isUnivalTree(TreeNode treeNode, int val) {
        if (treeNode == null) return true;
        return (treeNode.val == val) && isUnivalTree(treeNode.left, val)
                && isUnivalTree(treeNode.right, val);
    }

}
