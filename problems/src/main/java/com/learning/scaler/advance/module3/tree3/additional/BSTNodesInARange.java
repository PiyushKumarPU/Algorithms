package com.learning.scaler.advance.module3.tree3.additional;

import com.learning.scaler.advance.module3.LevelOrderTreeConstruction;
import com.learning.scaler.advance.module3.PrintTreeNode;
import com.learning.scaler.advance.module3.TreeNode;
import com.sun.source.tree.Tree;

import java.util.List;

/*
Problem Description
    Given a binary search tree of integers. You are given a range B and C.
    Return the count of the number of nodes that lie in the given range.

Problem Constraints
    1 <= Number of nodes in binary tree <= 100000
    0 <= B < = C <= 10^9

Input Format
    First argument is a root node of the binary tree, A.
    Second argument is an integer B.
    Third argument is an integer C.

Output Format
    Return the count of the number of nodes that lies in the given range.

Example Input
    Input 1:

                15
              /    \
            12      20
            / \    /  \
           10  14  16  27
          /
         8

         B = 12
         C = 20
    Input 2:

                8
               / \
              6  21
             / \
            1   7

         B = 2
         C = 20

Example Output
    Output 1:
        5
    Output 2:
        3


Example Explanation
    Explanation 1:
        Nodes which are in range [12, 20] are : [12, 14, 15, 20, 16]
    Explanation 2:
        Nodes which are in range [2, 20] are : [8, 6, 7]
* */
public class BSTNodesInARange {

    public static void main(String[] args) {

        TreeNode root = LevelOrderTreeConstruction.constructTree(List.of(
                1,2,3,4,5,-1,-1,-1,-1,-1,6,-1,-1));

        System.out.println(PrintTreeNode.traversePreOrder(root));
       // System.out.println(new BSTNodesInARange().solve(root, 10, 51));
    }

    public int solve(TreeNode A, int B, int C) {
        if (A == null || A.val == -1) return 0;
        return ((A.val >= B && A.val <= C) ? 1 : 0) +
                (A.left != null ? solve(A.left, B, C) : 0) +
                (A.right != null ? solve(A.right, B, C) : 0);
    }

    public int solve(List<Integer> A, int B, int C) {
        int currentSum = 0;
        for (int i : A) {
            if (i >= B && i <= C) currentSum += 1;
        }
        return currentSum;
    }
}
