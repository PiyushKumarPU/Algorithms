package com.learning.scaler.advance.module3.tree1.lecture;

import com.learning.scaler.advance.module3.TreeNode;

import java.util.HashMap;
import java.util.Map;

/*
Problem Description
    Given two integer arrays preorder and inorder where preorder is the preorder traversal of a
    binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

Problem Constraint:
    1 <= preorder.length <= 3000
    inorder.length == preorder.length
    -3000 <= preorder[i], inorder[i] <= 3000
    preorder and inorder consist of unique values.
    Each value of inorder also appears in preorder.
    preorder is guaranteed to be the preorder traversal of the tree.
    inorder is guaranteed to be the inorder traversal of the tree.

Input:
    Example 1:
        Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
        Output: [3,9,20,null,null,15,7]
    Example 2:
        Input: preorder = [-1], inorder = [-1]
        Output: [-1]

 * */
public class BinaryTreeFromInorderAndPreOrder {

    public TreeNode buildTreeFromInorderAndPreOrder(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) return null;
        Map<Integer, Integer> valIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            valIndexMap.put(inorder[i], i);
        }
        return buildTreeFromInorderAndPreOrder(preorder, valIndexMap, 0,
                0, preorder.length - 1);
    }

    private TreeNode buildTreeFromInorderAndPreOrder(int[] preorder, Map<Integer, Integer> valIndexMap, int preStart,
                                                     int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        int rootVal = preorder[preStart];
        int rootIndex = valIndexMap.get(rootVal);
        int count = rootIndex - inStart;
        TreeNode root = new TreeNode(rootVal);
        // construct left tree
        root.left = buildTreeFromInorderAndPreOrder(preorder, valIndexMap, preStart + 1,
                inStart, inStart + count - 1);

        //construct right tree
        root.right = buildTreeFromInorderAndPreOrder(preorder, valIndexMap, preStart + count + 1,
                rootIndex + 1, inEnd);

        return root;
    }


    private int i = 0, j = 0;

    // Need to understand this
    private TreeNode build(int[] preorder, int[] inorder, int min_v) {

        if (i >= preorder.length) {
            return null;
        }
        if (inorder[j] == min_v) {
            ++j;
            return null;
        }
        TreeNode tree = new TreeNode(preorder[i++]);
        tree.left = build(preorder, inorder, tree.val);
        tree.right = build(preorder, inorder, min_v);

        return tree;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, Integer.MIN_VALUE);
    }


}
