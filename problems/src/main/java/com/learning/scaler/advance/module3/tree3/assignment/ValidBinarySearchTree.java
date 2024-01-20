package com.learning.scaler.advance.module3.tree3.assignment;

import com.learning.scaler.advance.module3.LevelOrderTreeConstruction;
import com.learning.scaler.advance.module3.PrintTreeNode;
import com.learning.scaler.advance.module3.TreeNode;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/*
Problem Description
    You are given a binary tree represented by root A. You need to check if it is a Binary Search Tree or not.
Assume a BST is defined as follows:
    1) The left subtree of a node contains only nodes with keys less than the node's key.
    2) The right subtree of a node contains only nodes with keys greater than the node's key.
    3) Both the left and right subtrees must also be binary search trees.

Problem Constraints
    1 <= Number of nodes in binary tree <= 10^5
    0 <= node values <= 2^32-1

Input Format
    First and only argument is head of the binary tree A.

Output Format
    Return 0 if false and 1 if true.

Example Input
    Input 1:

           1
          /  \
         2    3
    Input 2:

          2
         / \
        1   3

Example Output
    Output 1:
        0
    Output 2:
        1

Example Explanation
    Explanation 1:
        2 is not less than 1 but is in left subtree of 1.
    Explanation 2:
        Satisfies all conditions.
* */
public class ValidBinarySearchTree {

    public static void main(String[] args) {



        List<Integer> inputs = new ArrayList<>();
       // inputs.add(49);
        inputs.add(40);
        inputs.add(35);
        inputs.add(41);
        inputs.add(34);
        inputs.add(37);
        inputs.add(-1);
        inputs.add(46);
        inputs.add(31);
        inputs.add(-1);
        inputs.add(36);
        inputs.add(38);
        inputs.add(45);
        inputs.add(47);
        inputs.add(29);
        inputs.add(32);
        inputs.add(-1);
        inputs.add(-1);
        inputs.add(-1);
        inputs.add(39);
        inputs.add(43);
        inputs.add(-1);
        inputs.add(-1);
        inputs.add(-1);
        inputs.add(28);
        inputs.add(30);
        inputs.add(-1);
        inputs.add(33);
        inputs.add(-1);
        inputs.add(-1);
        inputs.add(42);
        inputs.add(44);
        inputs.add(25);
        inputs.add(-1);
        inputs.add(-1);
        inputs.add(-1);
        inputs.add(-1);
        inputs.add(-1);
        inputs.add(-1);
        inputs.add(-1);
        inputs.add(-1);
        inputs.add(-1);
        inputs.add(24);
        inputs.add(26);
        inputs.add(-1);
        inputs.add(-1);
        inputs.add(-1);
        inputs.add(27);
        inputs.add(-1);
        inputs.add(-1);


        System.out.println(inputs);
        TreeNode root = LevelOrderTreeConstruction.constructTree(inputs);

        System.out.println(PrintTreeNode.traversePreOrder(root));

        System.out.println(new ValidBinarySearchTree().isValidBST(root));
    }

    public int isValidBST(TreeNode A) {
        if (A == null) {
            return 1;
        }

        /* false if the max of the left is > than us */
        if (A.left != null
                && maxValue(A.left) >= A.val) {
            return 0;
        }

        /* false if the min of the right is <= than us */
        if (A.right != null
                && minValue(A.right) <= A.val) {
            return 0;
        }

        /* false if, recursively, the left or right is not a
         * BST*/
        if (isValidBST(A.left) != 1
                || isValidBST(A.right) != 1) {
            return 0;
        }

        /* passing all that, it's a BST */
        return 1;
    }

    static int maxValue(TreeNode A) {
        if (A == null) {
            return Integer.MIN_VALUE;
        }
        int value = A.val;
        int leftMax = maxValue(A.left);
        int rightMax = maxValue(A.right);

        return Math.max(value, Math.max(leftMax, rightMax));
    }

    static int minValue(TreeNode A) {
        if (A == null) {
            return Integer.MAX_VALUE;
        }
        int value = A.val;
        int leftMax = minValue(A.left);
        int rightMax = minValue(A.right);

        return Math.min(value, Math.min(leftMax, rightMax));
    }


}
