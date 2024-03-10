package com.learning.scaler.advance.module3.tree4.assignment;

import com.learning.scaler.advance.module3.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
Problem Description
    Given a binary search tree represented by root A, write a function to find the Bth smallest element in the tree.

Problem Constraints
    1 <= Number of nodes in binary tree <= 100000
    0 <= node values <= 10^9

Input Format
    First and only argument is head of the binary tree A.

Output Format
    Return an integer, representing the Bth element.

Example Input
    Input 1:

                2
              /   \
             1    3
    B = 2
    Input 2:
                3
               /
              2
             /
            1
    B = 1

Example
    Output 1:
         2
    Output 2:
         1

Example
    Explanation 1:
        2nd element is 2.
    Explanation 2:
        1st element is 1.
* */
public class KthSmallestElementInBST {

    public int kthsmallest(TreeNode A, int B) {
        List<Integer> inOrder = new ArrayList<>();
        inOrder(A, inOrder);
        if (B > inOrder.size()) return -1;
        return inOrder.get(B - 1);
    }

    private void inOrder(TreeNode A, List<Integer> inOrder) {
        if (A == null) return;
        inOrder(A.left, inOrder);
        inOrder.add(A.val);
        inOrder(A.right, inOrder);
    }

    int ans = 0, count = 0;

    public int kthsmallestWithConstantSpace(TreeNode A, int B) {
        ans = 0;
        count = 0;
        inOrderWithCount(A, B);
        return ans;
    }

    private void inOrderWithCount(TreeNode A, int B) {
        if (A == null || count == B) return;
        inOrderWithCount(A.left, B);
        count++;
        if (count == B) ans = A.val;
        if (count < B)
            inOrderWithCount(A.right, B);
    }
}
