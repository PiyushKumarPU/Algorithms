package com.learning.scaler.advance.module3.tree2.lecture;

import com.learning.scaler.advance.module3.TreeNode;

public class HeightOfBinaryTree {

    public int findHeight(TreeNode node) {
        if (node == null) return 0;
        return Math.max(findHeight(node.left), findHeight(node.right));
    }
}
