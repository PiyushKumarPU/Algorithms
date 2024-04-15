package com.learning.scaler.advance.module3.tree4.lecture;

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

    public int kthSmallestApproach1(TreeNode A, int B) {
        // do in order traversal and return B -1 element
        ArrayList<Integer> inOrder = new ArrayList<>();
        inOrder(A, inOrder);
        return (B > inOrder.size()) ? -1 : inOrder.get(B - 1);
    }

    int ans = -1;

    public int kthSmallestApproach2(TreeNode A, int B) {
        // maintain count variable while doing inOrder Traversal
        ans = -1;
        inOrderWithCount(A, 0, B);
        return ans;
    }

    private void inOrderWithCount(TreeNode A, int currentCount, int requiredCount) {
        if (A == null || requiredCount == currentCount) return;
        if (A.left != null) inOrderWithCount(A.left, currentCount, requiredCount);
        currentCount++;
        if (currentCount == requiredCount) {
            ans = A.val;
            return;
        }
        if (A.right != null) inOrderWithCount(A.right, currentCount, requiredCount);
    }

    private void inOrder(TreeNode A, ArrayList<Integer> list) {
        if (A == null) return;
        if (A.left != null) inOrder(A.left, list);
        list.add(A.val);
        if (A.right != null) inOrder(A.right, list);
    }
}
