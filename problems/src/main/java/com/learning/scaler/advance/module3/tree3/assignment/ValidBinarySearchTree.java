package com.learning.scaler.advance.module3.tree3.assignment;

import com.learning.scaler.advance.module3.PrintTreeNode;
import com.learning.scaler.advance.module3.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
Problem Description
    You are given a binary tree represented by root A. You need to check if it is a Binary Search Tree or not.
Assume a BST is defined as follows:
    1) The left subtree of a node contains only nodes with keys less than the node's key.
    2) The right subtree of a node contains only nodes with keys greater than the node's key.
    3) Both the left and right subtrees must also be binary search trees.

Problem Constraints
    1 <= Number of nodes in binary tree <= 10^5
    0 <= node values <= 2^32-1

Input Format
    First and only argument is head of the binary tree A.

Output Format
    Return 0 if false and 1 if true.

Example Input
    Input 1:

           1
          /  \
         2    3
    Input 2:

          2
         / \
        1   3

Example Output
    Output 1:
        0
    Output 2:
        1

Example Explanation
    Explanation 1:
        2 is not less than 1 but is in left subtree of 1.
    Explanation 2:
        Satisfies all conditions.
* */
public class ValidBinarySearchTree {

    private int isValidBst = 1;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode root9 = new TreeNode(9);
        TreeNode root4 = new TreeNode(14);
        TreeNode root8 = new TreeNode(12);
        TreeNode root3 = new TreeNode(13);
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

        System.out.println(new ValidBinarySearchTree().isValidBST(root));
    }

    public int isValidBST(TreeNode A) {
        isValidBSTWorker(A);
        return isValidBst;
    }

    private void isValidBSTWorker(TreeNode A) {
        if (A == null || A.val == -1 || isValidBst == 0) return;
        boolean isLeafNode = A.left.val == -1 && A.right.val == -1;
        boolean isValidBSTNode = A.left.val < A.val && (A.right == null || A.right.val > A.val);
        if (!isLeafNode && !isValidBSTNode) {
            isValidBst = 0;
        }
    }
}
