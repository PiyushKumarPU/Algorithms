package com.learning.scaler.advance.module3.tree2.additional;

import com.learning.scaler.advance.module3.TreeNode;
import com.learning.scaler.advance.module3.tree2.LevelNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;


/*
Problem Description
    Given a binary tree of integers denoted by root A. Return an array of integers representing the top view of the Binary tree.
    The top view of a Binary Tree is a set of nodes visible when the tree is visited from the top.
    Return the nodes in any order.

Problem Constraints
    1 <= Number of nodes in binary tree <= 100000
    0 <= node values <= 10^9

Input Format
    First and only argument is head of the binary tree A.

Output Format
    Return an array, representing the top view of the binary tree.

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
         [1, 2, 4, 8, 3, 7]
    Output 2:
         [1, 2, 3]

Example Explanation
    Explanation 1:
        Top view is described.
    Explanation 2:
        Top view is described.
* */
public class TopViewOfBinaryTree {

    public int[] solve(TreeNode A) {
        if (A == null) return new int[]{};
        Map<Integer, List<Integer>> levelNodesMap = new TreeMap<>();

        Queue<LevelNode> levelNodes = new ArrayDeque<>();
        levelNodes.add(new LevelNode(0, A));
        while (!levelNodes.isEmpty()) {
            LevelNode current = levelNodes.poll();
            List<Integer> currentNodes = levelNodesMap.getOrDefault(current.level, new ArrayList<>());
            currentNodes.add(current.node.val);
            levelNodesMap.put(current.level, currentNodes);
            if (current.node.left != null)
                levelNodes.add(new LevelNode(current.level - 1, current.node.left));
            if (current.node.right != null)
                levelNodes.add(new LevelNode(current.level + 1, current.node.right));
        }
        int[] result = new int[levelNodesMap.size()];
        int index = 0;
        for (List<Integer> row : levelNodesMap.values()) {
            result[index++] = row.get(0);
        }
        return result;
    }

    public int[] bottomView(TreeNode A) {
        if (A == null) return new int[]{};
        Map<Integer, List<Integer>> levelNodesMap = new TreeMap<>();

        Queue<LevelNode> levelNodes = new ArrayDeque<>();
        levelNodes.add(new LevelNode(0, A));
        while (!levelNodes.isEmpty()) {
            LevelNode current = levelNodes.poll();
            List<Integer> currentNodes = levelNodesMap.getOrDefault(current.level, new ArrayList<>());
            currentNodes.add(current.node.val);
            levelNodesMap.put(current.level, currentNodes);
            if (current.node.left != null)
                levelNodes.add(new LevelNode(current.level - 1, current.node.left));
            if (current.node.right != null)
                levelNodes.add(new LevelNode(current.level + 1, current.node.right));
        }
        int[] result = new int[levelNodesMap.size()];
        int index = 0;
        for (List<Integer> row : levelNodesMap.values()) {
            result[index++] = row.get(row.size() - 1);
        }
        return result;
    }
}

