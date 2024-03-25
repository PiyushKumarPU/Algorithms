package com.learning.scaler.advance.module3.tree4.additional;


import com.learning.scaler.advance.module3.TreeNode;

/*
Problem Description
    Given a binary search tree.
    Return the distance between two nodes with given two keys B and C. It may be assumed that both keys exist in BST.
    NOTE: Distance between two nodes is number of edges between them.

Problem Constraints
    1 <= Number of nodes in binary tree <= 1000000
    0 <= node values <= 10^9

Input Format
    First argument is a root node of the binary tree, A.
    Second argument is an integer B.
    Third argument is an integer C.

Output Format
    Return an integer denoting the distance between two nodes with given two keys B and C

Example
    Input 1:
             5
           /   \
          2     8
         / \   / \
        1   4 6   11
     B = 2
     C = 11
    Input 2:
             6
           /   \
          2     9
         / \   / \
        1   4 7   10
     B = 2
     C = 6

Example
    Output 1:
         3
    Output 2:
         1

Example
    Explanation 1:
         Path between 2 and 11 is: 2 -> 5 -> 8 -> 11. Distance will be 3.
    Explanation 2:
         Path between 2 and 6 is: 2 -> 6. Distance will be 1
* */
public class DistanceBetweenNodesOfBST {

    public int solve(TreeNode A, int B, int C) {
        if (A == null) return 0;
        if (B <= A.val && C <= A.val) {
            // find C value first and then start traversing to find B and count no of nodes
            TreeNode CNode = findNode(A, C);
            int count = 0;
            while (CNode != null && CNode.val != B) {
                count++;
                CNode = (CNode.val > C) ? CNode.left : CNode.right;
            }
            return count;
        } else if (B > A.val && C > A.val) {
            // find B value first and then start traversing to find C and count no of nodes
            TreeNode BNode = findNode(A, B);
            int count = 0;
            while (BNode != null && BNode.val != C) {
                count++;
                BNode = (BNode.val > B) ? BNode.left : BNode.right;
            }
            return count;
        } else {
            // find B in left tree and C in right subtree
        }

        return 0;
    }

    public TreeNode findNode(TreeNode A, int val) {
        if (A == null) return null;
        TreeNode temp = A;
        while (temp != null && temp.val != val) {
            temp = temp.val > val ? temp.left : temp.right;
        }
        return temp;
    }

    public int countEdge(TreeNode A, int val, int count) {
        return 0;
    }
}
