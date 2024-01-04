package com.learning.scaler.advance.module3.tree5.additional;

import com.learning.scaler.advance.module3.PrintTreeNode;
import com.learning.scaler.advance.module3.TreeNode;

/*
Problem Description
    Given a binary tree. Check whether the given tree is a Sum-binary Tree or not.
    Sum-binary Tree is a Binary Tree where the value of a every node is equal to sum of the nodes present in its left subtree and right subtree.
    An empty tree is Sum-binary Tree and sum of an empty tree can be considered as 0. A leaf node is also considered as SumTree.

    Return 1 if it sum-binary tree else return 0.

Problem Constraints
    1 <= length of the array <= 100000
    0 <= node values <= 50

Input Format
    The only argument given is the root node of tree A.

Output Format
    Return 1 if it is sum-binary tree else return 0.

Example Input
    Input 1:
               26
             /    \
            10     3
           /  \     \
          4   6      3
    Input 2:
               26
             /    \
            10     3
           /  \     \
          4   6      4


Example Output
    Output 1:
        1
    Output 2:
        0


Example Explanation
    Explanation 1:
         All leaf nodes are considered as SumTree.
         Value of Node 10 = 4 + 6.
         Value of Node 3 = 0 + 3
         Value of Node 26 = (10 + 4 + 6) + 6
    Explanation 2:
        Sum of left subtree and right subtree is 27 which is not equal to the value of root node which is 26.

* */
public class SumBinaryTree {

    private static int isValidTree = 1;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(26);
        TreeNode node10 = new TreeNode(10);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node33 = new TreeNode(3);

        root.setLeft(node10);
        root.setRight(node3);
        node3.setRight(node33);
        node10.setLeft(node4);
        node10.setRight(node6);


        System.out.println(PrintTreeNode.traversePreOrder(root));
        sum(root);
        System.out.println(isValidTree);

    }

    public static int sum(TreeNode node) {
        if (node == null || isValidTree == 0) return 0;
        int lsSum = sum(node.getLeft());
        int rsSUm = sum(node.getRight());
        boolean isLeafNode = node.getLeft() == null && node.getRight() == null;
        if (!isLeafNode && node.getVal() != (lsSum + rsSUm)) {
            isValidTree = 0;
        }
        return node.getVal() + lsSum + rsSUm;
    }

    /*
    Scaler solution
    * */
    public static int isLeaf(TreeNode node) {
        if (node == null)
            return 0;
        if (node.getLeft() == null && node.getRight() == null)
            return 1;
        return 0;
    }
    public static int isSumTree(TreeNode node) {
        int ls, rs;
        if (node == null || isLeaf(node) == 1)
            return 1;

        if (isSumTree(node.getLeft()) == 1 && isSumTree(node.getRight()) == 1) {
            if (node.getLeft() == null)
                ls = 0;
            else if (isLeaf(node.getLeft()) == 1)
                ls = node.getLeft().getVal();
            else
                ls = 2 * (node.getLeft().getVal());
            if (node.getRight() == null)
                rs = 0;
            else if (isLeaf(node.getRight()) == 1)
                rs = node.getRight().getVal();
            else
                rs = 2 * (node.getRight().getVal());
            if (node.getVal() == ls + rs)
                return 1;
            else
                return 0;
        }
        return 0;
    }

    public static int checksumtree(TreeNode root) {
        if (isSumTree(root) == 1)
            return 1;
        return 0;
    }

}
