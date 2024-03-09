package com.learning.scaler.advance.module3.tree2.additional;

import com.learning.scaler.advance.module3.PrintTreeNode;
import com.learning.scaler.advance.module3.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/*
Problem Description
    Given the root node of a Binary Tree denoted by A. You have to Serialize the given Binary Tree in the described format.
    Serialize means encode it into a integer array denoting the Level Order Traversal of the given Binary Tree.
    NOTE:
        In the array, the NULL/None child is denoted by -1.
        For more clarification check the Example Input.

Problem Constraints
    1 <= number of nodes <= 10^5

Input Format
    Only argument is A denoting the root node of a Binary Tree.

Output Format
    Return an integer array denoting the Level Order Traversal of the given Binary Tree.

Example
    Input 1:
               1
             /   \
            2     3
           / \
          4   5
    Input 2:
                1
              /   \
             2     3
            / \     \
           4   5     6

Example
    Output 1:
         [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1]
    Output 2:
         [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1]

Example
    Explanation 1:
         The Level Order Traversal of the given tree will be [1, 2, 3, 4, 5 , -1, -1, -1, -1, -1, -1].
         Since 3, 4 and 5 each has both NULL child we had represented that using -1.
    Explanation 2:
         The Level Order Traversal of the given tree will be [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1].
         Since 3 has left child as NULL while 4 and 5 each has both NULL child.
* */
public class SerializeBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        root.setLeft(node9);
        root.setRight(node20);
        node20.setLeft(node15);
        node20.setRight(node7);

        System.out.println(PrintTreeNode.traversePreOrder(root));
        System.out.println(solve(root));

    }


    public static ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> treeNodes = new ArrayDeque<>();
        TreeNode treeNode = new TreeNode(-1);
        treeNodes.add(A);
        while (!treeNodes.isEmpty()) {
            TreeNode current = treeNodes.poll();
            result.add(current.val);
            if (current.val > -1) {
                treeNodes.add(current.left == null ? treeNode : current.left);
                treeNodes.add(current.right == null ? treeNode : current.right);
            }
        }
        return result;
    }
}
