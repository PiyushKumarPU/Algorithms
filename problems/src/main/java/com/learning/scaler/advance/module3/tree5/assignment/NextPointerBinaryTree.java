package com.learning.scaler.advance.module3.tree5.assignment;

import com.learning.scaler.advance.module3.LevelOrderTreeConstruction;
import com.learning.scaler.advance.module3.TreeLinkNode;

import java.util.*;

/*
Problem Description
    Given a binary tree,
    Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
    Initially, all next pointers are set to NULL.

    Assume perfect binary tree.


Problem Constraints
    1 <= Number of nodes in binary tree <= 100000
    0 <= node values <= 10^9

Input Format
    First and only argument is head of the binary tree A.

Output Format
    Return the head of the binary tree after the changes are made.

Example Input
    Input 1:

         1
        /  \
       2    3
    Input 2:

            1
           /  \
          2    5
         / \  / \
        3  4  6  7

Example Output
    Output 1:

            1 -> NULL
           /  \
          2 -> 3 -> NULL
    Output 2:

             1 -> NULL
           /  \
          2 -> 5 -> NULL
         / \  / \
        3->4->6->7 -> NULL


Example Explanation
    Explanation 1:
        Next pointers are set as given in the output.
    Explanation 2:
        Next pointers are set as given in the output.
* */
public class NextPointerBinaryTree {

    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>(3000);
        for (int i = 15; i < 10000; i++) {
            integers.add(i);
        }
        TreeLinkNode root = LevelOrderTreeConstruction.constructTreeLink(integers);  // LevelOrderTreeConstruction.constructTreeLink(List.of(1, 2, 3, 4, 5, 6, 7));
        new NextPointerBinaryTree().connectUsingQueue(root);

        System.out.println(root);
    }

    public void connectUsingQueue(TreeLinkNode root) {
        Queue<TreeLinkNode> queue = new ArrayDeque<>();
        if (root.left != null) queue.add(root.left);
        if (root.right != null) queue.add(root.right);
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            TreeLinkNode current = queue.poll();
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
            TreeLinkNode next;
            for (int i = 1; i < queueSize; i++) {
                next = queue.poll();
                if (next != null) {
                    current.next = next;
                    if (next.left != null) queue.add(next.left);
                    if (next.right != null) queue.add(next.right);
                    current = next;
                }
            }
        }
    }

    public void connectUsingRecursion(TreeLinkNode treeNode) {
        if (treeNode == null) return;
        if (treeNode.left == null && treeNode.right == null) return;
        else if (treeNode.left != null) {
            treeNode.left.next = treeNode.right;
            if (treeNode.next != null)
                treeNode.right.next = treeNode.next.left;
        }
        connectUsingRecursion(treeNode.left);
        connectUsingRecursion(treeNode.right);
    }

    public void connectWithConstantSpace(TreeLinkNode treeNode) {
        TreeLinkNode temp = treeNode;
        while (temp.left != null) {
            TreeLinkNode current = temp;
            while (temp != null) {
                temp.left.next = temp.right;
                if (temp.next != null)
                    temp.right.next = temp.next.left;
                temp = temp.next;
            }
            temp = current.left;
        }
    }
}
