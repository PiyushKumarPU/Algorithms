package com.learning.mock_preparation.day9_tree;

import com.learning.scaler.advance.module3.PrintTreeNode;
import com.learning.scaler.advance.module3.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    // https://www.scaler.com/academy/mentee-dashboard/class/155302/homework/problems/219/submissions

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(1, 6, 2, 3));
        ArrayList<Integer> B = new ArrayList<>(List.of(6, 1, 3, 2));
        System.out.println(PrintTreeNode.traversePreOrder(buildTree(A, B)));
    }

    public static TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        Map<Integer, Integer> inOrderValIndexMap = new HashMap<>(B.size());
        int index = 0;
        for (int ele : B) {
            inOrderValIndexMap.put(ele, index++);
        }
        return constructTree(A, inOrderValIndexMap, 0, B.size() - 1, 0);
    }

    private static TreeNode constructTree(ArrayList<Integer> preOrder, Map<Integer, Integer> inOrderValIndexMap
            , int inStart, int inEnd, int preStart) {
        if (inStart > inEnd) return null;
        TreeNode root = new TreeNode(preOrder.get(preStart));
        int inOrderRootIndex = inOrderValIndexMap.get(root.val);
        int count = inOrderRootIndex - inStart;
        // construct left
        root.left = constructTree(preOrder, inOrderValIndexMap,
                inStart, inOrderRootIndex - 1, preStart + 1);

        root.right = constructTree(preOrder, inOrderValIndexMap,
                inOrderRootIndex + 1, inEnd, preStart + count + 1);
        return root;
    }

    public static TreeNode buildTree(int[] A, int[] B) {
        Map<Integer, Integer> inOrderValIndexMap = new HashMap<>(B.length);
        int index = 0;
        for (int ele : B) {
            inOrderValIndexMap.put(ele, index++);
        }
        return constructTree(A, inOrderValIndexMap, 0, B.length - 1, 0);
    }

    private static TreeNode constructTree(int[] preOrder, Map<Integer, Integer> inOrderValIndexMap
            , int inStart, int inEnd, int preStart) {
        if (inStart > inEnd) return null;
        TreeNode root = new TreeNode(preOrder[preStart]);
        int inOrderRootIndex = inOrderValIndexMap.get(root.val);
        int count = inOrderRootIndex - inStart;
        // construct left
        root.left = constructTree(preOrder, inOrderValIndexMap,
                inStart, inOrderRootIndex - 1, preStart + 1);

        root.right = constructTree(preOrder, inOrderValIndexMap,
                inOrderRootIndex + 1, inEnd, preStart + count + 1);
        return root;
    }
}
