package com.learning.leet.code;

import com.learning.scaler.advance.module3.TreeNode;
import com.sun.source.tree.Tree;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode inverted = invertTree(null, root.left, root.right);
        root.left = inverted.left;
        root.right = inverted.right;
        return root;

    }


    private TreeNode invertTree(TreeNode root, TreeNode left, TreeNode right) {

        return null;



    }
}
