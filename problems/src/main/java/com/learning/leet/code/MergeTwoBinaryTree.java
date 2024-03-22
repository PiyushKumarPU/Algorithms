package com.learning.leet.code;

import com.learning.scaler.advance.module3.TreeNode;
import com.sun.source.tree.Tree;

public class MergeTwoBinaryTree {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;
        else if (root1 == null) return root2;
        else if (root2 == null) return root1;

        int rootVal = root1.val + root2.val;
        TreeNode newRoot = new TreeNode(rootVal);
        newRoot.left = mergeTree(root1.left, root2.left);
        newRoot.right = mergeTree(root1.right, root2.right);
        return newRoot;
    }

    private TreeNode mergeTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;
        else if (root1 == null) return root2;
        else if (root2 == null) return root1;

        TreeNode newRoot = new TreeNode(root1.val + root2.val);
        newRoot.left = mergeTree(root1.left, root2.left);
        newRoot.right = mergeTree(root1.right, root2.right);
        return newRoot;
    }
}
