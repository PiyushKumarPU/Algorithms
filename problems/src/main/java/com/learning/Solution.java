package com.learning;

import com.learning.scaler.advance.module3.PrintTreeNode;
import com.learning.scaler.advance.module3.TreeNode;

public class Solution {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(6);
        TreeNode root9 = new TreeNode(9);
        TreeNode root4 = new TreeNode(4);
        TreeNode root8 = new TreeNode(8);
        TreeNode root3 = new TreeNode(3);
        TreeNode root_1 = new TreeNode(-1);

        root.setLeft(root9);
        root.setRight(root4);
        root4.setLeft(root8);
        root8.setRight(root3);

        // NULL node
        root9.setLeft(root_1);
        root9.setRight(root_1);
        root4.setRight(root_1);
        root8.setLeft(root_1);
        root3.setLeft(root_1);
        root3.setRight(root_1);

        System.out.println(PrintTreeNode.traversePreOrder(root));
    }
}
 