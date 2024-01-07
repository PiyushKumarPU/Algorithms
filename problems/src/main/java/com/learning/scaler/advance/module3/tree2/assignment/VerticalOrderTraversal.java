package com.learning.scaler.advance.module3.tree2.assignment;

import com.learning.scaler.advance.module3.BTreePrinter;
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
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);

        root.left = node2;
        root.right = node3;

        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;

        BTreePrinter.printNode(root);

        System.out.println(new VerticalOrderTraversal().verticalOrderTraversal(root));
    }

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Map<Integer, Queue<Integer>> integerListMap = new HashMap<>();
        populate(A, integerListMap, 0);
        for (Integer key : integerListMap.keySet().stream().sorted().collect(java.util.stream.Collectors.toList())) {
            ArrayList<Integer> local = new ArrayList<>();
           Queue<Integer> integers =  integerListMap.get(key);
           while (!integers.isEmpty()){
               local.add(integers.poll());
           }
           result.add(local);
        }
        return result;
    }

    private void populate(TreeNode A, Map<Integer, Queue<Integer>> input, int start) {
        if (A == null || A.val == -1) return;
        Queue<Integer> currentVal = input.getOrDefault(start, new LinkedList<>());
        currentVal.add(A.val);
        input.put(start, currentVal);
        if (A.left != null && A.left.val != -1)
            populate(A.left, input, start - 1);
        if (A.right != null && A.right.val != -1)
            populate(A.right, input, start + 1);
    }
}
