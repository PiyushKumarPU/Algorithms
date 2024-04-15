package com.learning.scaler.advance.module3.tree3.additional;

import com.learning.scaler.advance.module3.LevelOrderTreeConstruction;
import com.learning.scaler.advance.module3.PrintTreeNode;
import com.learning.scaler.advance.module3.TreeNode;

import java.util.List;

/*
Problem Description
    Given a binary search tree of integers. You are given a range B and C.
    Return the count of the number of nodes that lie in the given range.

Problem Constraints
    1 <= Number of nodes in a binary tree <= 100000
    0 <= B < = C <= 10^9

Input Format
    First argument is a root node of the binary tree, A.
    Second argument is an integer B.
    Third argument is an integer C.

Output Format
     Returns the count of the number of nodes that lies in the given range.

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
        Nodes which are in range [12, 20] are: [12, 14, 15, 20, 16]
    Explanation 2:
        Nodes which are in range [2, 20] are: [8, 6, 7]
* */
public class BSTNodesInARange {

    public static void main(String[] args) {

        TreeNode root = LevelOrderTreeConstruction.constructTree(List.of(
                1, 2, 3, 4, 5, -1, -1, -1, -1, -1, 6, -1, -1));

        System.out.println(PrintTreeNode.traversePreOrder(root));
    }

    public int solve(TreeNode A, int B, int C) {
        if (A == null) return 0;

        int count = (A.val >= B && A.val <= C) ? 1 : 0;
        int leftCount = A.left != null ? solve(A.left, B, C) : 0;
        int rightCount = A.right != null ? solve(A.right, B, C) : 0;
        return count + leftCount + rightCount;
    }

    public int solveComplex(TreeNode A, int B, int C) {
        if (A == null) return 0;
        int count = (A.val >= B && A.val <= C) ? 1 : 0;
        int leftCount = A.left != null ? solve(A.left, B, C) : 0;
        int rightCount = A.right != null ? solve(A.right, B, C) : 0;
        return count + leftCount + rightCount;
    }

    static int ans = 0;

    public int solveScaler(TreeNode A, int B, int C) {
        ans = 0;
        traverse(A, B, C);
        return ans;
    }

    public static void traverse(TreeNode a, int B, int C) {
        if (a == null)
            return;
        if (a.val >= B && a.val <= C)
            ans++;
        traverse(a.left, B, C);
        traverse(a.right, B, C);
    }
}
