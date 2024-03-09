package com.learning.scaler.advance.module3.tree3.assignment;

import com.learning.scaler.advance.module3.TreeNode;
import com.sun.source.tree.Tree;

import java.util.List;

/*
Problem Description
    Given an array where elements are sorted in ascending order, convert it to a height Balanced
    Binary Search Tree (BBST).

    Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of
    the two subtrees of every node never differ by more than 1.

Problem Constraints
    1 <= length of array <= 100000

Input Format
    First argument is an integer array A.

Output Format
    Return a root node of the Binary Search Tree.

Example Input
    Input 1:
        A : [1, 2, 3]
    Input 2:
        A : [1, 2, 3, 5, 10]

Example Output
    Output 1:

          2
        /   \
       1     3
    Output 2:

          3
        /   \
       2     5
      /       \
     1         10


Example Explanation
    Explanation 1:
        You need to return the root node of the Binary Tree.
* */
public class SortedArrayToBalancedBST {

    public static void main(String[] args) {
        TreeNode root = sortedArrayToBST(List.of(1, 2, 3, 4, 5));
        System.out.println(root);
    }


    public static TreeNode sortedArrayToBST(final List<Integer> A) {
        return constructTree(A, 0, A.size() - 1);
    }

    private static TreeNode constructTree(final List<Integer> A, int start, int end) {
        if (start > end) return null;
        if (start == end) return new TreeNode(A.get(start));
        int mid = (end + start) / 2;
        TreeNode root = new TreeNode(A.get(mid));
        if (mid - 1 >= start)
            root.left = constructTree(A, start, mid - 1);
        if (mid + 1 <= end)
            root.right = constructTree(A, mid + 1, end);
        return root;
    }



    private TreeNode constructBST(final int[] A, int start, int end) {
        if (start > end) return null;
        if (start == end) return new TreeNode(A[start]);
        int mid = (end + start) / 2;
        TreeNode root = new TreeNode(A[mid]);
        if (mid - 1 >= start)
            root.left = constructBST(A, start, mid - 1);
        if (mid + 1 <= end)
            root.right = constructBST(A, mid + 1, end);
        return root;
    }
}
