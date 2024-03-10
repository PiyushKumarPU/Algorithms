package com.learning.scaler.advance.module3.tree4.assignment;

import com.learning.scaler.advance.module3.TreeNode;

import java.util.ArrayList;

/*
Problem Description
    Given a binary tree, return the inorder traversal of its nodes' values.
    NOTE: Using recursion and stack are not allowed.

Problem Constraints
    1 <= number of nodes <= 10^5

Input Format
    First and only argument is root node of the binary tree, A.

Output Format
    Return an integer array denoting the inorder traversal of the given binary tree.

Example
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

Example
    Output 1:
         [1, 3, 2]
    Output 2:
         [6, 1, 3, 2]


Example
    Explanation 1:
         The Inorder Traversal of the given tree is [1, 3, 2].
    Explanation 2:
         The Inorder Traversal of the given tree is [6, 1, 3, 2].
* */
public class MorrisInorderTraversal {

    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        TreeNode curr = A;

        while (curr != null) {
            if (curr.left == null) {
                result.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode pre = curr.left;
                while (pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }

                if (pre.right == null) {
                    pre.right = curr;
                    curr = curr.left;
                } else {
                    pre.right = null;
                    result.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return result;
    }
}
