package com.learning.scaler.advance.module3.tree2.assignment;


import com.learning.scaler.advance.module3.TreeNode;

/*
Problem Description
    Given a root of binary tree A, determine if it is height-balanced.
    A height-balanced binary tree is defined as a binary tree in which the depth of the two
    subtrees of every node never differ by more than 1.

Problem Constraints
    1 <= size of tree <= 100000

Input Format
    First and only argument is the root of the tree A.

Output Format
    Return 0 / 1 ( 0 for false, 1 for true ) for this problem.

Example Input
    Input 1:

        1
       / \
      2   3
    Input 2:

           1
          /
         2
        /
       3

Example Output
    Output 1:
        1
    Output 2:
        0

Example Explanation
    Explanation 1:
        It is a complete binary tree.
    Explanation 2:
        Because for the root node, left subtree has depth 2 and right subtree has depth 0.
        Difference = 2 > 1.
* */
public class BalancedBinaryTree {

    public static void main(String[] args) {

    }

    public int isBalanced(TreeNode A) {
        return isBalancedTree(A).isBalanced ? 1 : 0;
    }

    private BalancePair isBalancedTree(TreeNode A) {
        if (A == null) return new BalancePair(true, 0);

        BalancePair leftNode = isBalancedTree(A.left);
        BalancePair rightNode = isBalancedTree(A.right);
        int heightDiff = Math.abs(leftNode.height - rightNode.height);
        return new BalancePair(leftNode.isBalanced && rightNode.isBalanced && heightDiff <= 1,
                Math.max(leftNode.height, rightNode.height) + 1);
    }
}

class BalancePair {
    boolean isBalanced;
    int height;

    public BalancePair(boolean isBalanced, int height) {
        this.isBalanced = isBalanced;
        this.height = height;
    }
}