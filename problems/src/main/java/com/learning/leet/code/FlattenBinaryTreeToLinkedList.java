package com.learning.leet.code;

import com.learning.scaler.advance.module3.TreeNode;
import com.sun.source.tree.Tree;

public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        TreeNode leftPart = flattenTree(root.left);

        TreeNode rightPart = flattenTree(root.right);
    }

    private TreeNode flattenTree(TreeNode root) {
        if (root == null) return null;

        return null;

    }

}
