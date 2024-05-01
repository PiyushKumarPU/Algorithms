package com.learning.scaler.advance.module3.tree1.additional;

import com.learning.scaler.advance.module3.TreeNode;

import java.util.ArrayList;

/*
Problem Description
    Given a binary tree, return the Postorder traversal of its nodes values.

Problem Constraints
    1 <= number of nodes <= 10^5

Input Format
    First and only argument is root node of the binary tree, A.

Output Format
    Return an integer array denoting the Postorder traversal of the given binary tree.

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
        [3, 2, 1]
    Output 2:
        [6, 3, 2, 1]

Example Explanation
    Explanation 1:
        The Preoder Traversal of the given tree is [3, 2, 1].
    Explanation 2:
        The Preoder Traversal of the given tree is [6, 3, 2, 1].
* */
public class PostOrderTraversal {
    ArrayList<Integer> result = new ArrayList<>();

    public ArrayList<Integer> postOrderTraversal(TreeNode A) {
        postOrderTraversalWorker(A);
        return result;
    }

    public void postOrderTraversalWorker(TreeNode treeNode) {
        if (treeNode == null) return;
        postOrderTraversalWorker(treeNode.getLeft());
        postOrderTraversalWorker(treeNode.getRight());
        result.add(treeNode.getVal());
    }
}
