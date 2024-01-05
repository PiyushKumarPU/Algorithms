package com.learning.scaler.advance.module3.tree2.additional;

import com.learning.scaler.advance.module3.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Problem Description
You are given an integer array A denoting the Level Order Traversal of the Binary Tree.

You have to Deserialize the given Traversal in the Binary Tree and return the root of the Binary Tree.

NOTE:

In the array, the NULL/None child is denoted by -1.
For more clarification check the Example Input.


Problem Constraints
1 <= number of nodes <= 105

-1 <= A[i] <= 105



Input Format
Only argument is an integer array A denoting the Level Order Traversal of the Binary Tree.



Output Format
Return the root node of the Binary Tree.



Example Input
Input 1:

 A = [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1]
Input 2:

 A = [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1]


Example Output
Output 1:

           1
         /   \
        2     3
       / \
      4   5
Output 2:

            1
          /   \
         2     3
        / \ .   \
       4   5 .   6
* */
public class DeserializeBinaryTree {

    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<>(List.of(3, 9, 20, -1, -1, 15, 7, -1, -1, -1, -1))));
    }

    public static TreeNode solve(ArrayList<Integer> A) {
        if (A == null || A.isEmpty() || A.get(0) == -1) {
            return null;
        }

        TreeNode root = new TreeNode(A.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        for (int i = 1; i < A.size(); i += 2) {
            TreeNode current = queue.poll();

            if (A.get(i) != null && A.get(i) > -1) {
                assert current != null;
                current.left = new TreeNode(A.get(i));
                queue.offer(current.left);
            }

            if (i + 1 < A.size() && A.get(i + 1) != null && A.get(i + 1) > -1) {
                assert current != null;
                current.right = new TreeNode(A.get(i + 1));
                queue.offer(current.right);
            }
        }
        return root;
    }

    public TreeNode solveScaler(ArrayList<Integer> A) {
        TreeNode root = new TreeNode(A.get(0));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty()) {
            TreeNode cur = q.peek();
            q.remove();
            if (cur == null) {
                continue;
            }
            int val_left = A.get(i);
            int val_right = A.get(i + 1);
            i += 2;

            if (val_left == -1) {
                cur.left = null;
            } else {
                cur.left = new TreeNode(val_left);
            }
            if (val_right == -1) {
                cur.right = null;
            } else {
                cur.right = new TreeNode(val_right);
            }
            q.add(cur.left);
            q.add(cur.right);
        }
        return root;
    }

}
