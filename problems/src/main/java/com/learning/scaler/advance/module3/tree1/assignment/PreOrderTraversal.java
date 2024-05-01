package com.learning.scaler.advance.module3.tree1.assignment;

import com.learning.scaler.advance.module3.TreeNode;

import java.util.ArrayList;

/*
Problem Description
    Given a binary tree, return the preorder traversal of its nodes values.

Problem Constraints
    1 <= number of nodes <= 10^5

Input Format
    First and only argument is root node of the binary tree, A.

Output Format
    Return an integer array denoting the preorder traversal of the given binary tree.

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
        [1, 2, 3]
    Output 2:
        [1, 6, 2, 3]

Example Explanation
    Explanation 1:
        The Preoder Traversal of the given tree is [1, 2, 3].
    Explanation 2:
        The Preoder Traversal of the given tree is [1, 6, 2, 3].
* */
public class PreOrderTraversal {
    ArrayList<Integer> result = new ArrayList<>();

    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        preOrderWorker(A);
        return result;
    }

    void preOrderWorker(TreeNode treeNode) {
        if (treeNode == null) return;
        result.add(treeNode.getVal());
        preOrderWorker(treeNode.getLeft());
        preOrderWorker(treeNode.getRight());

    }
}
