package com.learning.scaler.advance.module3.tree5.additional;

/*
* Problem Description
    Given a binary tree. Transform it to sum binary tree
    Sum-binary Tree is a Binary Tree where the value of a every node is equal to sum of the nodes present in its left subtree and right subtree.
    An empty tree is Sum-binary Tree and sum of an empty tree can be considered as 0.
    A leaf node is also considered as SumTree, and sum of an empty tree can be considered as 0.

Problem Constraints
    1 <= length of the array <= 100000
    0 <= node values <= 50

Input Format
    The only argument given is the root node of tree A.

Output Format
    Return header of sum binary tree constructed from given tree

Example Input
    Input 1:
               1
             /    \
            2      3
           /  \     \
          4   5      6

Example Output
    Output 1:
               21
             /    \
            11     9
           /  \     \
          4   5      6


Example Explanation
    Explanation 1:
        4 is leaf node so value will be 4 (4 + 0 + 0)
        5 is leaf node so value will be 5 (5 + 0 + 0)
        6 is leaf node so value will be 6 (6 + 0 + 0)
        2 has some child nodes so value would be 11 (2 + 4 + 5)
        3 has some child nodes so value would be 9 (3 + 0 + 6)
        1 has some child nodes so value would be 21 (1 + 11 + 9)
 */

import com.learning.scaler.advance.module3.PrintTreeNode;
import com.learning.scaler.advance.module3.TreeNode;

import java.util.Stack;

public class SubTreeSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setRight(node6);


        //recursiveSumBinaryTree(root);
        System.out.println(PrintTreeNode.traversePreOrder(root));
        iterativeSumBinaryTree(root);
        System.out.println(PrintTreeNode.traversePreOrder(root));

    }


    public static int recursiveSumBinaryTree(TreeNode A) {
        if (A == null) return 0;
        int newVal = A.getVal() + recursiveSumBinaryTree(A.getLeft()) + recursiveSumBinaryTree(A.getRight());
        A.setVal(newVal);
        return newVal;
    }

    public static void iterativeSumBinaryTree(TreeNode A) {
        if (A == null) return;
        int currentSum = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = A;

        while (current != null || !stack.isEmpty()) {
            // iterate till left most node
            while (current != null) {
                stack.push(current);
                current = current.getLeft();
            }
            // pop leftmost node and add that to current sum
            current = stack.pop();
            // add current value in node sum value
            currentSum += current.getVal();

            // check if any right subtree present for the leftmost node
            current = current.getRight();
        }
        A.setVal(currentSum);
    }
}
