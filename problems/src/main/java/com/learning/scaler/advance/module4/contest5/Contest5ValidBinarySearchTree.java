package com.learning.scaler.advance.module4.contest5;

import com.learning.scaler.advance.module3.TreeNode;
import com.learning.scaler.advance.module3.tree1.lecture.InOrderTraversal;

import java.util.ArrayList;

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
public class Contest5ValidBinarySearchTree {

    public static void main(String[] args) {

    }

    public int isValidBSTUsingInOrder(TreeNode A) {
        if (A == null || (A.left == null && A.right == null)) return 1;
        ArrayList<Integer> inOrder = InOrderTraversal.inorderTraversal(A);
        for (int i = 1; i < inOrder.size(); i++) {
            if (inOrder.get(i - 1) >= inOrder.get(i)) return 0;
        }
        return 1;
    }

    /* using Pre order*/
    public int isValidBST(TreeNode A) {
        return isValidBST(A, Integer.MIN_VALUE, Integer.MAX_VALUE) ? 1 : 0;
    }

    private boolean isValidBST(TreeNode A, int start, int end) {
        if (A == null) return true;
        if (start <= A.val && A.val <= end) {
            return isValidBST(A.left, start, A.val - 1) && isValidBST(A.right, A.val + 1, end);
        }
        return false;
    }

    public int isValidBSTPost(TreeNode A) {
        return isValidBST(A, Integer.MIN_VALUE, Integer.MAX_VALUE) ? 1 : 0;
    }

    private boolean isValidBSTPost(TreeNode A, int start, int end) {
        if (A == null) return true;
        return isValidBST(A.left, start, A.val - 1) && isValidBST(A.right, A.val + 1, end) &&
                (start <= A.val && A.val <= end);
    }
}
