package com.learning.scaler.advance.module3.tree1.additional;

import com.learning.scaler.advance.module3.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
Problem Description
    Given preorder and inorder traversal of a tree, construct the binary tree.
    NOTE: You may assume that duplicates do not exist in the tree.

Problem Constraints
    1 <= number of nodes <= 10^5

Input Format
    First argument is an integer array A denoting the preorder traversal of the tree.
    Second argument is an integer array B denoting the inorder traversal of the tree.

Output Format
    Return the root node of the binary tree.

Example Input
    Input 1:
        A = [1, 2, 3]
        B = [2, 1, 3]
    Input 2:
        A = [1, 6, 2, 3]
        B = [6, 1, 3, 2]

Example Output
    Output 1:

           1
          / \
         2   3
    Output 2:

           1
          / \
         6   2
            /
           3


Example Explanation
    Explanation 1:
        Create the binary tree and return the root node of the tree.
* */
public class BinaryTreeFromInorderAndPreOrder {

    // in order 1, 6, 2, 3
    // pre order 6, 1, 3, 2

    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {

        // construct map from in order
        Map<Integer, Integer> valueIndexMap = new HashMap<>(A.size());
        for (int i = 0; i < A.size(); i++) {
            valueIndexMap.put(A.get(i), i);
        }

        int root = B.get(0);
        int leftTreeStart = 0, leftTreeEnd = 0, rightTreeStart = 0, rightTreeEnd = 0;


        return null;
    }

    public TreeNode buildTree(ArrayList<Integer> inOrder, ArrayList<Integer> preOrder,
                              Map<Integer, Integer> valueIndexMap, int inStart, int inEnd, int preStart, int preEnd) {

        int root = preOrder.get(preStart);
        int inOrderRootIndex = valueIndexMap.get(root);
        TreeNode rootNode = new TreeNode(root);
        // construct lefttree
        rootNode.left = buildTree(inOrder, preOrder, valueIndexMap,
                inStart, inOrderRootIndex - 1, preStart + 1, preEnd);

        buildTree(inOrder, preOrder, valueIndexMap, inOrderRootIndex + 1, inEnd, 0, 0);
        return rootNode;

    }

}
