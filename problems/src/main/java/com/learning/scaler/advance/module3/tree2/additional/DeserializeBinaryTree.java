package com.learning.scaler.advance.module3.tree2.additional;

import com.learning.scaler.advance.module3.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
        if (A == null || A.get(0) < 0) return null;
        TreeNode root = new TreeNode(A.get(0));
        A.remove(A.get(0));
        int nodeCount = 1;
        System.out.println(root.val);
        while (!A.isEmpty()) {
            int index = 2 * nodeCount;
            List<Integer> integers = A;
            if (index < A.size()) {
                integers = A.subList(0, 2 * nodeCount);
                nodeCount = (int) integers.stream().filter(x -> x > -1).count();
                System.out.println(integers);
                A.removeAll(integers);
            }

        }
        return root;

    }

}
