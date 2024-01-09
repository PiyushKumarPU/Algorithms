package com.learning.scaler.advance.module3.tree2.assignment;

import com.learning.scaler.advance.module3.BTreePrinter;
import com.learning.scaler.advance.module3.LevelOrderTreeConstruction;
import com.learning.scaler.advance.module3.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/*
Problem Description
    Given a binary tree, return a 2-D array with vertical order traversal of it. Go through the example and image for more details.
    NOTE: If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.

    Problem desc Images : https://github.com/rajpiyush220/GrowTogetherWithDSA/blob/e45274b61ef503177fbe2dcedc56061e4a281553/Notes/images/vertical_order_images.jpeg

Problem Constraints
    0 <= number of nodes <= 10^5

Input Format
    First and only arument is a pointer to the root node of binary tree, A.

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
        TreeNode root = LevelOrderTreeConstruction.constructTree(List.of(3709, 4465, 2668, -1, -1, -1, -1));
        System.out.println(new VerticalOrderTraversal().verticalOrderTraversal(root));
    }

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Map<Integer, ArrayList<Integer>> map = populate(A);
        for (Integer key : map.keySet().stream().sorted().collect(Collectors.toList())) {
            result.add(map.get(key));
        }
        return result;
    }

    private Map<Integer, ArrayList<Integer>> populate(TreeNode A) {
        Map<Integer, ArrayList<Integer>> result = new HashMap<>();
        if (A == null) return result;
        Queue<Map<Integer, TreeNode>> mapQueue = new LinkedList<>();
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        nodeMap.put(0, A);
        mapQueue.offer(nodeMap);
        while (!mapQueue.isEmpty()) {
            Map.Entry<Integer, TreeNode> current = mapQueue.poll().entrySet().stream().findFirst().orElse(null);
            if (current != null) {
                Integer key = current.getKey();
                ArrayList<Integer> currentList = result.getOrDefault(key, new ArrayList<>());
                TreeNode currentNode = current.getValue();
                if (currentNode.val != -1) {
                    if (currentNode.left != null && currentNode.left.val != -1) {
                        nodeMap.clear();
                        nodeMap.put(key - 1, currentNode.left);
                        mapQueue.offer(nodeMap);
                    }
                    nodeMap.clear();
                    nodeMap.put(key, currentNode.left);
                    mapQueue.offer(nodeMap);
                    if (currentNode.right != null && currentNode.right.val != -1) {
                        nodeMap.clear();
                        nodeMap.put(key + 1, currentNode.right);
                        mapQueue.offer(nodeMap);
                    }
                }
            }
        }

        return result;
    }


}
