package com.learning.scaler.advance.module3.tree2.assignment;

import com.learning.scaler.advance.module3.LevelOrderTreeConstruction;
import com.learning.scaler.advance.module3.TreeNode;
import com.learning.scaler.advance.module3.tree2.LevelNode;

import java.util.*;
import java.util.stream.Collectors;

/*
Problem Description
    Given a binary tree, return a 2-D array with vertical order traversal of it. Go through the example and image for more details.
    NOTE: If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.

    Problem desc Images : ../../../images/vertical_order_images.jpeg
    

Problem Constraints
    0 <= number of nodes <= 10^5

Input Format
    First and only argument is a pointer to the root node of binary tree, A.

Output Format
    Return a 2D array denoting the vertical order traversal of tree as shown.

Example Input
    Input 1:
              6
            /   \
           3     7
          / \     \
         2   5     9
    Input 2:
              1
            /   \
           3     7
          /       \
         2         9


Example Output
    Output 1:
         [
            [2],
            [3],
            [6, 5],
            [7],
            [9]
         ]
    Output 2:

         [
            [2],
            [3],
            [1],
            [7],
            [9]
         ]


Example Explanation
    Explanation 1:
         First row represent the vertical line 1 and so on.
* */
public class VerticalOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = LevelOrderTreeConstruction.constructTree(List.of(8262, -1, 411, -1, -1));
        System.out.println(new VerticalOrderTraversal().verticalOrderTraversal(root));
    }

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (A == null) return result;
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
        return levelNodesMap.values().stream().map(ArrayList::new).collect(Collectors.toCollection(ArrayList::new));
        /*for (int key : levelNodesMap.keySet()) {
            result.add(new ArrayList<>(levelNodesMap.get(key)));
        }

        return result;*/
    }
}


