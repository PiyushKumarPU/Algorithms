package com.learning.scaler.advance.module3.tree4.assignment;

import com.learning.scaler.advance.module3.TreeNode;

import java.util.ArrayList;
import java.util.List;

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

    List<Integer> inOrder;

    public int[] recoverTree(TreeNode A) {
        inOrder = new ArrayList<>();
        int[] result = new int[2];
        doInOrder(A);
        for (int i = 0; i < (inOrder.size() - 1); i++) {
            if (inOrder.get(i) < inOrder.get(i + 1)) {
                result[0] = inOrder.get(i);
                result[1] = inOrder.get(i + 1);
                return result;
            }
        }
        return result;
    }

    private void doInOrder(TreeNode A) {
        if (A == null) return;
        doInOrder(A.left);
        inOrder.add(A.val);
        doInOrder(A.right);
    }


}
