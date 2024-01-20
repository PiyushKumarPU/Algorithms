package com.learning;

import com.learning.scaler.advance.module3.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class zigZagTreeTraversal {

    // driver program to test the above function
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(7);
        tree.left.right = new TreeNode(6);
        tree.right.left = new TreeNode(5);
        tree.right.right = new TreeNode(4);

        System.out.println("ZigZag Order traversal of binary tree is");
        System.out.println(new zigZagTreeTraversal().zigzagLevelOrder(tree));
    }

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (A == null) {
            return new ArrayList<>();
        }

        Stack<TreeNode> currentLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();

        currentLevel.push(A);
        boolean leftToRight = true;

        ArrayList<Integer> row = new ArrayList<>();
        // check if stack is empty
        while (!currentLevel.isEmpty()) {
            TreeNode node = currentLevel.pop();
            row.add(node.val);
            if (leftToRight) {
                if (node.left != null) {
                    nextLevel.push(node.left);
                }

                if (node.right != null) {
                    nextLevel.push(node.right);
                }
            } else {
                if (node.right != null) {
                    nextLevel.push(node.right);
                }

                if (node.left != null) {
                    nextLevel.push(node.left);
                }
            }

            if (currentLevel.isEmpty()) {
                leftToRight = !leftToRight;
                Stack<TreeNode> temp = currentLevel;
                result.add(row);
                row = new ArrayList<>();
                currentLevel = nextLevel;
                nextLevel = temp;
            }
        }
        return result;
    }

    void printZigZagTraversal(TreeNode rootNode) {

        // if null then return
        if (rootNode == null) {
            return;
        }

        // declare two stacks
        Stack<TreeNode> currentLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();

        // push the root
        currentLevel.push(rootNode);
        boolean leftToRight = true;

        ArrayList<Integer> row = new ArrayList<>();

        // check if stack is empty
        while (!currentLevel.isEmpty()) {

            // pop out of stack
            TreeNode node = currentLevel.pop();

            // print the data in it
            System.out.print(node.val + " ");

            // store data according to current
            // order.
            if (leftToRight) {
                if (node.left != null) {
                    nextLevel.push(node.left);
                }

                if (node.right != null) {
                    nextLevel.push(node.right);
                }
            } else {
                if (node.right != null) {
                    nextLevel.push(node.right);
                }

                if (node.left != null) {
                    nextLevel.push(node.left);
                }
            }

            if (currentLevel.isEmpty()) {
                System.out.println();
                leftToRight = !leftToRight;
                Stack<TreeNode> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
            }
        }
        System.out.println();
    }
}
