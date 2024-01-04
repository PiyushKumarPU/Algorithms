package com.learning.scaler.advance.module3.tree5.additional;

import com.learning.scaler.advance.module3.PrintTreeNode;
import com.learning.scaler.advance.module3.TreeNode;

/*
Problem Description
    Given a binary tree A, invert the binary tree and return it.
    Inverting refers to making the left child the right child and vice versa.

Problem Constraints
    1 <= size of tree <= 100000

Input Format
    First and only argument is the head of the tree A.

Output Format
    Return the head of the inverted tree.

Example Input
    Input 1:

             1
           /   \
          2     3
    Input 2:

             1
           /   \
          2     3
         / \   / \
        4   5 6   7

Example Output
    Output 1:
             1
           /   \
          3     2
    Output 2:
             1
           /   \
          3     2
         / \   / \
        7   6 5   4

Example Explanation
    Explanation 1:
        Tree has been inverted.
    Explanation 2:
        Tree has been inverted.
* */
public class InvertTheBinaryTree {

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

        System.out.println(PrintTreeNode.traversePreOrder(root));
        invertTree(root);
        System.out.println(PrintTreeNode.traversePreOrder(root));
    }

    public static TreeNode invertTree(TreeNode A) {
        invert(A);
        return A;
    }

    private static void invert(TreeNode node) {
        // swap left --> right child and vice versa of each node
        // swap left --> right child and vice versa of each node
        if (node == null) return;
        TreeNode temp = node.getLeft();
        node.setLeft(node.getRight());
        node.setRight(temp);
        invert(node.getLeft());
        invert(node.getRight());
    }
}
