package com.learning.mock_preparation.day9_tree;

import com.learning.scaler.advance.module3.BTreePrinter;
import com.learning.scaler.advance.module3.LevelOrderTreeConstruction;
import com.learning.scaler.advance.module3.TreeNode;
import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Problem Description
    Given a binary tree, return the zigzag level order traversal of its nodes values.
    (ie, from left to right, then right to left for the next level and alternate between).

Problem Constraints
1 <= number of nodes <= 10^5

Input Format
    First and only argument is root node of the binary tree, A.

Output Format
    Return a 2D integer array denoting the zigzag level order traversal of the given binary tree.

Example Input
    Input 1:
        3
       / \
      9  20
        /  \
       15   7
    Input 2:
       1
      / \
     6   2
        /
       3


Example Output
    Output 1:
         [
           [3],
           [20, 9],
           [15, 7]
         ]
    Output 2:
         [
           [1]
           [2, 6]
           [3]
         ]

Example Explanation
    Explanation 1:
         Return the 2D array. Each row denotes the zigzag traversal of each level.
* */
public class ZigZagLevelOrderTraversalBT {

    public static void main(String[] args) {
        TreeNode treeNode = LevelOrderTreeConstruction.constructTree(List.of(129, 97, 98, 93, 106, 27, 61, -1, 173, 40, 78, 22, 152, 99, 114, 47, 69, -1, -1, 110, 144, 14, 56, 165, 174, 49, 1, 57, 126, 123, 100, 30, -1, -1, -1, 161, 13, 139, 2, 85, 128, 119, 177));
        BTreePrinter.printNode(treeNode);
        System.out.println(new ZigZagLevelOrderTraversalBT().zigzagLevelOrder(treeNode));
    }


    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        if (A == null) return null;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Queue<TreeNode> treeNodes = new ArrayDeque<>();
        treeNodes.offer(A);
        int index = 0;
        while (!treeNodes.isEmpty()) {
            int size = treeNodes.size();
            ArrayList<Integer> row = new ArrayList<>(size);
            ArrayList<TreeNode> tempSpace = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode current = treeNodes.poll();
                if (current != null) {
                    row.add(current.val);
                    if (current.left != null) tempSpace.add(current.left);
                    if (current.right != null) tempSpace.add(current.right);
                    /*if (index % 2 == 0) {
                        if (current.right != null) tempSpace.add(current.right);
                        if (current.left != null) tempSpace.add(current.left);
                    } else {
                        if (current.left != null) tempSpace.add(current.left);
                        if (current.right != null) tempSpace.add(current.right);
                    }*/
                }
            }
            result.add(row);
            if (index % 2 == 0) {
                for (int i = tempSpace.size() - 1; i >= 0; i--) treeNodes.offer(tempSpace.get(i));
            } else {
                for (TreeNode temp : tempSpace) treeNodes.offer(temp);
            }
            index++;
        }
        return result;
    }
}
