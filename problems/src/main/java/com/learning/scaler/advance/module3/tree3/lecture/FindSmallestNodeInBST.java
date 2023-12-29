package com.learning.scaler.advance.module3.tree3.lecture;

import com.learning.scaler.advance.module3.TreeNode;

public class FindSmallestNodeInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(15);
        TreeNode node12 = new TreeNode(12);
        TreeNode node10 = new TreeNode(10);
        TreeNode node14 = new TreeNode(14);
        TreeNode node8 = new TreeNode(8);

        TreeNode node20 = new TreeNode(20);
        TreeNode node16 = new TreeNode(16);
        TreeNode node27 = new TreeNode(27);

        node10.setLeft(node8);
        node12.setLeft(node10);
        node12.setRight(node14);
        root.setLeft(node12);
        root.setRight(node20);
        node20.setLeft(node16);
        node20.setRight(node27);

        System.out.println(solve(root));
    }

    public static int solve(TreeNode A) {
        while (A.getLeft() != null){
            A = A.getLeft();
        }
        return A.getVal();
    }
}
