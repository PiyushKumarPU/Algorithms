package com.learning.scaler.advance.module3.tree2.assignment;


import com.learning.scaler.advance.module3.TreeNode;

import java.util.*;

/*
Problem Description
    Given a binary tree of integers denoted by root A. Return an array of integers representing the right view of the Binary tree.
    Right view of a Binary Tree is a set of nodes visible when the tree is visited from Right side.

Problem Constraints
    1 <= Number of nodes in binary tree <= 100000
    0 <= node values <= 10^9

Input Format
    First and only argument is head of the binary tree A.

Output Format
    Return an array, representing the right view of the binary tree.

Example Input
    Input 1:

                1
              /   \
             2    3
            / \  / \
           4   5 6  7
          /
         8
    Input 2:

            1
           /  \
          2    3
           \
            4
             \
              5


Example Output
    Output 1:
         [1, 3, 7, 8]
    Output 2:
         [1, 3, 4, 5]

Example Explanation
    Explanation 1:
        Right view is described.
    Explanation 2:
        Right view is described.
* */
public class RightViewOfBinaryTree {

    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        if (A == null) return result;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(A);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> row = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current != null) {
                    if (i == size - 1) {
                        result.add(current.val);
                    }
                    if (current.left != null)
                        queue.add(current.left);
                    if (current.right != null)
                        queue.add(current.right);
                }
            }
        }
        return result;
    }

    int currLevel = 0;

    public List<Integer> rightSideView(TreeNode root) {
        LinkedList<Integer> answer = new LinkedList<>();
        helper(root, 0, answer);
        return answer;

    }

    public void helper(TreeNode node, int level, LinkedList<Integer> answer) {
        if (node == null)
            return;
        if (level == answer.size()) {
            answer.add(node.val);
        }
        helper(node.right, level + 1, answer);
        helper(node.left, level + 1, answer);
    }

    public ArrayList<Integer> leftView(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        if (A == null) return result;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(A);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> row = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current != null) {
                    if (i == 0) {
                        result.add(current.val);
                    }
                    if (current.left != null)
                        queue.add(current.left);
                    if (current.right != null)
                        queue.add(current.right);
                }
            }
        }
        return result;
    }
}

