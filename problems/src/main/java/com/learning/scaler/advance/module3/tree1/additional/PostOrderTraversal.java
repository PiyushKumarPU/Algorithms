package com.learning.scaler.advance.module3.tree1.additional;

import com.learning.scaler.advance.module3.TreeNode;

import java.util.ArrayList;

/*
Problem Description
    Given a binary tree, return the Postorder traversal of its nodes values.

Problem Constraints
    1 <= number of nodes <= 10^5

Input Format
    First and only argument is root node of the binary tree, A.

Output Format
    Return an integer array denoting the Postorder traversal of the given binary tree.

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
        [3, 2, 1]
    Output 2:
        [6, 3, 2, 1]

Example Explanation
    Explanation 1:
        The Preoder Traversal of the given tree is [3, 2, 1].
    Explanation 2:
        The Preoder Traversal of the given tree is [6, 3, 2, 1].
* */
public class PostOrderTraversal {
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

        System.out.println(new PostOrderTraversal().postOrderTraversal(root));
    }


    public ArrayList<Integer> postOrderTraversal(TreeNode A) {
        postOrderTraversalWorker(A);
        return result;
    }

    public void postOrderTraversalWorker(TreeNode treeNode) {
        if (treeNode == null) return;
        postOrderTraversalWorker(treeNode.getLeft());
        postOrderTraversalWorker(treeNode.getRight());
        result.add(treeNode.getVal());
    }
}
