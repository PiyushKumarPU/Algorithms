package com.learning.scaler.advance.module3.tree1.lecture;

import com.learning.scaler.advance.module3.TreeNode;

import java.util.ArrayList;

/*
Problem Description
    Given a binary tree, return the inorder traversal of its nodes' values.

Problem Constraints
    1 <= number of nodes <= 10^5

Input Format
    First and only argument is root node of the binary tree, A.

Output Format
    Return an integer array denoting the inorder traversal of the given binary tree.

Example Input
    Input 1:

       1
        \
         2
        /
       3
    Input 2:

       1
      / \
     6   2
        /
       3

Example Output
    Output 1:
        [1, 3, 2]
    Output 2:
        [6, 1, 3, 2]


Example Explanation
    Explanation 1:
        The Inorder Traversal of the given tree is [1, 3, 2].
    Explanation 2:
        The Inorder Traversal of the given tree is [6, 1, 3, 2].
* */
public class InOrderTraversal {
    static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(15);
        TreeNode node12 = new TreeNode(12);
        TreeNode node10 = new TreeNode(10);
        TreeNode node14 = new TreeNode(14);
        TreeNode node8 = new TreeNode(8);

        TreeNode node20 = new TreeNode(20);
        TreeNode node16 = new TreeNode(16);
        TreeNode node27 = new TreeNode(27);

        node10.setLeft(node8);
        node12.setLeft(node10);
        node12.setRight(node14);
        root.setLeft(node12);
        root.setRight(node20);
        node20.setLeft(node16);
        node20.setRight(node27);

        System.out.println(inorderTraversal(root));
    }


    public static ArrayList<Integer> inorderTraversal(TreeNode A) {
        inorderTraversalWorker(A);
        return result;
    }

    public static void inorderTraversalWorker(TreeNode treeNode) {
        if (treeNode == null) return;
        inorderTraversalWorker(treeNode.getLeft());
        result.add(treeNode.getVal());
        inorderTraversalWorker(treeNode.getRight());

    }
}
