package com.learning.scaler.advance.module3.tree1.assignment;

import com.learning.scaler.advance.module3.PrintTreeNode;
import com.learning.scaler.advance.module3.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Problem Description
    Given the inorder and postorder traversal of a tree, construct the binary tree.
    NOTE: You may assume that duplicates do not exist in the tree.

Problem Constraints
    1 <= number of nodes <= 10^5

Input Format
    First argument is an integer array A denoting the inorder traversal of the tree.
    Second argument is an integer array B denoting the postorder traversal of the tree.

Output Format
    Return the root node of the binary tree.

Example Input
    Input 1:
        A = [2, 1, 3]
        B = [2, 3, 1]
    Input 2:
        A = [6, 1, 3, 2]
        B = [6, 3, 2, 1]

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
public class BinaryTreeFromInorderAndPostOrder {

    public static void main(String[] args) {
        PrintTreeNode.traversePreOrder(buildTree(new int[]{6, 1, 3, 2}, new int[]{6, 3, 2, 1}));
    }

    public static void buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        TreeNode root = constructTree(A, B);
        PrintTreeNode.traversePreOrder(root);
    }

    private static TreeNode constructTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        if (A.isEmpty() || B.isEmpty()) return new TreeNode(0);
        int poSize = B.size();
        TreeNode root = new TreeNode(B.get(poSize - 1));

        int rootIndex = A.indexOf(root.getVal());

        // left subtree
        ArrayList<Integer> inOrderLST = new ArrayList<>(A.subList(0, rootIndex));
        ArrayList<Integer> postOrderLST = new ArrayList<>(A.subList(0, rootIndex));

        // right subtree
        ArrayList<Integer> inOrderRST = new ArrayList<>(B.subList(rootIndex + 1, B.size()));
        ArrayList<Integer> postOrderRST = new ArrayList<>(A.subList(rootIndex, rootIndex + inOrderRST.size() - 1));

        root.setLeft(constructTree(inOrderLST, postOrderLST));
        root.setRight(constructTree(inOrderRST, postOrderRST));
        return root;
    }


    private static TreeNode buildTree(int[] A, int[] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0) return null;
        Map<Integer, Integer> valIndexMap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            valIndexMap.put(A[i], i);
        }
        return buildTree(A, B, valIndexMap, 0, A.length - 1, 0, A.length - 1);
    }

    private static TreeNode buildTree(int[] A, int[] B, Map<Integer, Integer> valIndexMap, int inStart, int inEnd, int postStart, int postEnd) {
        if(inStart > inEnd) return null;
        int rootNode = B[postEnd];
        int rootIndex = valIndexMap.get(rootNode);
        int count = rootIndex - inStart;
        TreeNode root = new TreeNode(rootNode);
        // build left tree
        root.left = buildTree(A, B, valIndexMap, inStart, inStart + count - 1, postStart, postStart + count - 1);
        // build right tree
        root.right = buildTree(A, B, valIndexMap, rootIndex + 1, inEnd, postStart + count, postEnd - 1);
        return root;
    }

}
