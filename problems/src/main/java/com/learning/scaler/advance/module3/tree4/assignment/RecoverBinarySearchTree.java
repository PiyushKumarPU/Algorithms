package com.learning.scaler.advance.module3.tree4.assignment;

import com.learning.scaler.advance.module3.TreeNode;

/*
Problem Description
    Two elements of a Binary Search Tree (BST), represented by root A are swapped by mistake.
    Tell us the 2 values, when swapped, will restore the Binary Search Tree (BST).
    A solution using O(n) space is pretty straightforward. Could you devise a constant space solution?
    Note: The 2 values must be returned in ascending order

Problem Constraints
    1 <= size of tree <= 100000

Input Format
    First and only argument is the head of the tree,A

Output Format
    Return the 2 elements which need to be swapped.

Example
    Input 1:
             1
            / \
           2   3
    Input 2:
             2
            / \
           3   1

Example
    Output 1:
         [2, 1]
    Output 2:
         [3, 1]

Example
    Explanation 1:
        Swapping 1 and 2 will change the BST to be
                 2
                / \
               1   3
        which is a valid BST
    Explanation 2:
        Swapping 1 and 3 will change the BST to be
                 2
                / \
               1   3
        which is a valid BST
* */
public class RecoverBinarySearchTree {

    public int[] recoverTree(TreeNode A) {
        return new int[]{};
    }
}
