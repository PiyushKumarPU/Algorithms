package com.learning.scaler.advance.module3.tree5.lecture;

import com.learning.scaler.advance.module3.TreeNode;
import com.learning.scaler.advance.module3.stack2.assignment.MaxAndMin;
import com.sun.source.tree.Tree;

/*

 Diameter of Tree
* */
public class LongestPathAcrossAnyTwoNode {

    int diameter = Integer.MIN_VALUE;
    public int diameter(TreeNode treeNode) {
        if (treeNode == null) return 0;
        return diameter;

    }

    private int findHeight(TreeNode treeNode) {
        if (treeNode == null) return -1;
        int leftHeight = (treeNode.left != null) ? findHeight(treeNode.left) : -1;
        int rightHeight = (treeNode.right != null) ? findHeight(treeNode.right) : -1;
        int currentNodeHeight = Math.max(leftHeight, rightHeight) + 1;
        diameter = Math.max((leftHeight + rightHeight + 2), diameter);
        return currentNodeHeight;
    }
}
