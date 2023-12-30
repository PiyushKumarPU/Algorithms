package com.learning.scaler.advance.module3.tree1.assignment;

import com.learning.scaler.advance.module3.TreeNode;

import java.util.ArrayList;

/*
Problem Description
    Given a binary tree, return the preorder traversal of its nodes values.

Problem Constraints
    1 <= number of nodes <= 10^5

Input Format
    First and only argument is root node of the binary tree, A.

Output Format
    Return an integer array denoting the preorder traversal of the given binary tree.

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
        [1, 2, 3]
    Output 2:
        [1, 6, 2, 3]

Example Explanation
    Explanation 1:
        The Preoder Traversal of the given tree is [1, 2, 3].
    Explanation 2:
        The Preoder Traversal of the given tree is [1, 6, 2, 3].
* */
public class PreOrderTraversal {
    ArrayList<Integer> result = new ArrayList<>();

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

        System.out.println(new PreOrderTraversal().preorderTraversal(root));
    }


    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        preOrderWorker(A);
        return result;
    }

    void preOrderWorker(TreeNode treeNode) {
        if (treeNode == null) return;
        result.add(treeNode.getVal());
        preOrderWorker(treeNode.getLeft());
        preOrderWorker(treeNode.getRight());

    }
}
