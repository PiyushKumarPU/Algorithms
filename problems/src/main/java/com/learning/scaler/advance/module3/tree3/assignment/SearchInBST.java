package com.learning.scaler.advance.module3.tree3.assignment;


import com.learning.scaler.advance.module3.TreeNode;
import com.sun.source.tree.Tree;

/*
Problem Description
    Given a Binary Search Tree A. Check whether there exists a node with value B in the BST.

Problem Constraints
    1 <= Number of nodes in binary tree <= 10^5
    0 <= B <= 10^6

Input Format
    First argument is a root node of the binary tree, A.
    Second argument is an integer B.

Output Format
    Return 1 if such a node exist and 0 otherwise

Example Input
    Input 1:
                15
              /    \
            12      20
            / \    /  \
           10  14  16  27
          /
         8
         B = 16
    Input 2:
                8
               / \
              6  21
             / \
            1   7
         B = 9

Example Output
    Output 1:
         1
    Output 2:
         0

Example Explanation
    Explanation 1:
        Node with value 16 is present.
    Explanation 2:
        There is no node with value 9.
* */
public class SearchInBST {

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

        System.out.println(solve(root, 16));
    }

    public static int solve(TreeNode A, int B) {
        if (A.getVal() == B) return 1;
        if (B > A.getVal() && A.getRight() != null) return solve(A.getRight(), B);
        else if (B < A.getVal() && A.getLeft() != null) return solve(A.getLeft(), B);
        return 0;
    }

}
