package com.learning.scaler.advance.module3.tree3.assignment;

import com.learning.scaler.advance.module3.PrintTreeNode;
import com.learning.scaler.advance.module3.TreeNode;

/*
Problem Description
    Given a Binary Search Tree(BST) A. If there is a node with value B present in the tree delete it and return the tree.
    Note - If there are multiple options, always replace a node by its in-order predecessor

Problem Constraints
    2 <= No. of nodes in BST <= 10^5
    1 <= value of nodes <= 10^9
    Each node has a unique value

Input Format
    The first argument is the root node of a Binary Search Tree A.
    The second argument is the value B.

Output Format
    Delete the given node if found and return the root of the BST.

Example
    Input 1:

                15
              /    \
            12      20
            / \    /  \
           10  14  16  27
          /
         8

         B = 10

    Input 2:

                8
               / \
              6  21
             / \
            1   7

         B = 6

Example
    Output 1:

                15
              /    \
            12      20
            / \    /  \
           8  14  16  27

    Output 2:
                8
               / \
              1  21
               \
                7

Example
    Explanation 1:
        Node with value 10 is deleted
    Explanation 2:
        Node with value 6 is deleted
* */
public class DeleteNodeInBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left = new TreeNode(1);

        DeleteNodeInBST bst = new DeleteNodeInBST();
        System.out.println(PrintTreeNode.traversePreOrder(bst.solve(root, 2)));
    }

    public TreeNode solve(TreeNode A, int B) {
        if (A == null) return A;
        TreeNode parent = null, temp = A;
        while (temp != null && temp.val != B) {
            parent = temp;
            temp = temp.val > B ? temp.left : temp.right;
        }
        if (temp != null) {
            int childCount = (temp.left != null ? 1 : 0) + (temp.right != null ? 1 : 0);
            if (childCount == 0) { // leaf node
                if (parent == null) return null;
                else {
                    if (parent.left != null && parent.left.val == temp.val) parent.left = null;
                    else if (parent.right != null && parent.right.val == temp.val) parent.right = null;
                }
            } else if (childCount == 1) { // node with child
                if (parent == null) return temp.left != null ? temp.left : temp.right;
                else {
                    TreeNode newNode = temp.left != null ? temp.left : temp.right;
                    if (parent.left != null && parent.left.val == temp.val) parent.left = newNode;
                    else if (parent.right != null && parent.right.val == temp.val) parent.right = newNode;
                }
            } else {
                TreeNode replacementNode = replaceWithLeftMaxNode(temp.left);
                replacementNode.right = temp.right;
                if (parent == null) return replacementNode;
                else {
                    if (parent.left != null && parent.left.val == temp.val) parent.left = replacementNode;
                    else if (parent.right != null && parent.right.val == temp.val) parent.right = replacementNode;
                }
            }
        }
        return A;
    }

    public TreeNode solveScaler(TreeNode A, int B) {
        if(A != null)
            if(B < A.val)
                A.left = solveScaler(A.left, B);
            else if(B > A.val)
                A.right = solveScaler(A.right, B);
            else{
                if(A.left == null && A.right == null)
                    return null;
                if (A.left == null || A.right == null)
                    return A.left != null ? A.left : A.right;

                TreeNode temp = A.left;
                while(temp.right != null)
                    temp = temp.right;
                A.val = temp.val;
                A.left = solveScaler(A.left, temp.val);
            }
        return A;
    }

    private TreeNode replaceWithLeftMaxNode(TreeNode A) {
        if (A.right == null) return A;
        TreeNode parent = null, temp = A;
        while (temp.right != null) {
            parent = temp;
            temp = temp.right;
        }
        parent.right = temp.left;
        temp.left = A;
        return temp;
    }
}
