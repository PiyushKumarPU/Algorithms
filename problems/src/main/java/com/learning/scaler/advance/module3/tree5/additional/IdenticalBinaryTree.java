package com.learning.scaler.advance.module3.tree5.additional;

import com.learning.scaler.advance.module3.TreeNode;
import com.sun.source.tree.Tree;

/*
Problem Description
    Given two binary trees, check if they are equal or not.
    Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

Problem Constraints
    1 <= number of nodes <= 10^5

Input Format
    The first argument is a root node of the first tree, A.
    The second argument is a root node of the second tree, B.

Output Format
    Return 0 / 1 ( 0 for false, 1 for true ) for this problem.

Example Input
    Input 1:
           1       1
          / \     / \
         2   3   2   3
    Input 2:
           1       1
          / \     / \
         2   3   3   3

Example Output
    Output 1:
        1
    Output 2:
        0

Example Explanation
    Explanation 1:
        Both trees are structurally identical and the nodes have the same value.
    Explanation 2:
        Values of the left child of the root node of the trees are different.
* */
public class IdenticalBinaryTree {

    private int isIdentical = 1;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        TreeNode root9 = new TreeNode(9);
        TreeNode root4 = new TreeNode(4);
        TreeNode root8 = new TreeNode(8);
        TreeNode root3 = new TreeNode(3);

        root.setLeft(root9);
        root.setRight(root4);
        root4.setLeft(root8);
        root8.setRight(root3);

        IdenticalBinaryTree identicalBinaryTree = new IdenticalBinaryTree();
        System.out.println(identicalBinaryTree.isSameTree(root, root));
    }

    public int isSameTree(TreeNode A, TreeNode B) {
        isIdTree(A, B);
        return isIdentical;
    }


    private Boolean isIdTree(TreeNode treeNode1, TreeNode treeNode2) {
        if (treeNode1 == null || treeNode2 == null || isIdentical == 0 ||
                treeNode1.getVal() != treeNode2.getVal()) return false;
        boolean isValidTree =
                ((treeNode1.getLeft() == null && treeNode2.getLeft() == null) ||
                        isIdTree(treeNode1.getLeft(), treeNode2.getLeft())) &&
                        ((treeNode1.getRight() == null && treeNode2.getRight() == null) ||
                                isIdTree(treeNode1.getRight(), treeNode2.getRight()));
        if (!isValidTree) {
            isIdentical = 0;
        }
        return isValidTree;
    }


}
