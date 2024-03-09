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
        TreeNode root = new TreeNode(3);
        root.right = new TreeNode(4);

        DeleteNodeInBST bst = new DeleteNodeInBST();
        System.out.println(PrintTreeNode.traversePreOrder(bst.solve(root, 3)));
    }

    public TreeNode solve(TreeNode A, int B) {
        // check if tree has only one node and that should be deleted
        if (A == null || (A.left == null && A.right == null && A.val == B)) return null;
        // find node to be deleted and its parent node
        TreeNode parent = null, temp = A;
        while (temp != null && temp.val != B) {
            parent = temp;
            temp = temp.val > B ? temp.right : temp.left;
        }
        // if parent is null then node to be deleted is root node
        if (parent == null) {
            parent = temp;
        }

        if (temp != null) {
            // check if node to be deleted is leaf node
            if (temp.left == null && temp.right == null) {
                // delete node and reset parent node respective child
                if (parent.left != null && parent.left.val == temp.val) parent.left = null;
                if (parent.right != null && parent.right.val == temp.val) parent.right = null;
            } else if (temp.left == null || temp.right == null) {
                // check if node to be deleted has only one child
                TreeNode nextNode = temp.left != null ? temp.left : temp.right;
                if (parent.val == temp.val) {
                    parent = temp.left == null ? temp.right : temp.left;
                } else if (parent.left != null && parent.left.val == temp.val) parent.left = nextNode;
                else if (parent.right != null && parent.right.val == temp.val) parent.right = nextNode;

            } else {
                // check if node to be deleted has both the child
                // find either min of right subtree or max of left subtree
                TreeNode nextNode = new TreeNode(findLeftSubTreeMin(temp.left));
                if (parent.val == temp.val) {
                    nextNode.right = parent.right;
                    nextNode.left = (parent.left.val == nextNode.val) ? null : parent.left;
                    parent = nextNode;
                } else if (parent.left != null && parent.left.val == temp.val) parent.left = nextNode;
                else if (parent.right != null && parent.right.val == temp.val) parent.right = nextNode;
            }
        }

        return parent;
    }

    private int findLeftSubTreeMin(TreeNode A) {
        TreeNode parent = null, temp = A;
        if (A.left != null) {
            while (temp.left != null) {
                parent = temp;
                temp = temp.left;
            }
        }
        // check if temp has right child
        if (parent != null && temp.right != null) {
            parent.left = temp.right;
        }
        return temp.val;
    }
}
