package com.learning.scaler.advance.module3.tree1.assignment;

import com.learning.scaler.advance.module3.TreeNode;

import java.util.ArrayList;

/*
Problem Description
    Given a binary tree, return the inorder traversal of its nodes' values.

Problem Constraints
    1 <= number of nodes <= 10^5

Input Format
    First and only argument is root node of the binary tree, A.

Output Format
    Return an integer array denoting the inorder traversal of the given binary tree.

Example Input
    Input 1:

       1
        \
         2
        /
       3
    Input 2:

       1
      / \
     6   2
        /
       3

Example Output
    Output 1:
        [1, 3, 2]
    Output 2:
        [6, 1, 3, 2]


Example Explanation
    Explanation 1:
        The Inorder Traversal of the given tree is [1, 3, 2].
    Explanation 2:
        The Inorder Traversal of the given tree is [6, 1, 3, 2].
* */
public class InOrderTraversal {
    static ArrayList<Integer> result = new ArrayList<>();

    public static ArrayList<Integer> inorderTraversal(TreeNode A) {
        inorderTraversalWorker(A);
        return result;
    }

    public static void inorderTraversalWorker(TreeNode treeNode) {
        if (treeNode == null) return;
        inorderTraversalWorker(treeNode.getLeft());
        result.add(treeNode.getVal());
        inorderTraversalWorker(treeNode.getRight());

    }
}
