package com.learning.scaler.advance.module3.tree5.additional;

import com.learning.scaler.advance.module3.LevelOrderTreeConstruction;
import com.learning.scaler.advance.module3.PrintTreeNode;
import com.learning.scaler.advance.module3.TreeNode;

import java.util.List;

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

    private final int isIdentical = 0;

    public static void main(String[] args) {

        TreeNode root1 = LevelOrderTreeConstruction.constructTree(List.of(5, 10, -1, -1, -1));
        TreeNode root2 = LevelOrderTreeConstruction.constructTree(List.of(5, -1, -1));

        System.out.println(PrintTreeNode.traversePreOrder(root1));
        System.out.println(PrintTreeNode.traversePreOrder(root2));

        IdenticalBinaryTree identicalBinaryTree = new IdenticalBinaryTree();
        System.out.println(identicalBinaryTree.isSameTree(root1, root2));
    }

    private int isSameTree(TreeNode A, TreeNode B) {
        if ((A == null && B == null)) return 1;
        if (A == null || B == null) return 0;
        int root = (A.val == B.val) ? 1 : 0;
        return root * isSameTree(A.left, B.left) * isSameTree(A.right, B.right);
    }

    public int sameTree(TreeNode A, TreeNode B) {
        if (A == null && B == null)
            return 1;
        if (A == null || B == null)
            return 0;
        if (A.val != B.val)
            return 0;

        int num = 1;
        num = num & sameTree(A.left, B.left) & sameTree(A.right, B.right);
        return num;
    }


}
