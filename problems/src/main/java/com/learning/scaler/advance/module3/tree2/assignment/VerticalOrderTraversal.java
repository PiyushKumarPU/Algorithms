package com.learning.scaler.advance.module3.tree2.assignment;

import com.learning.scaler.advance.module3.LevelOrderTreeConstruction;
import com.learning.scaler.advance.module3.TreeNode;

import java.util.*;

/*
Problem Description
    Given a binary tree, return a 2-D array with vertical order traversal of it. Go through the example and image for more details.
    NOTE: If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.

    Problem desc Images : ../../../images/vertical_order_images.jpeg
    

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
        TreeNode root = LevelOrderTreeConstruction.constructTree(List.of(8262, -1, 411, -1, -1));
        System.out.println(new VerticalOrderTraversal().verticalOrderTraversal(root));
    }

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        TreeMap<Long, Vector<Integer>> mp = new TreeMap<>();
        preOrderTraversal(A, 0, 1, mp);

        // print map
        int prekey = Integer.MAX_VALUE;
        for (Map.Entry<Long, Vector<Integer>> entry :
                mp.entrySet()) {
            if (prekey != Integer.MAX_VALUE
                    && (entry.getKey() >> 30) != prekey) {
            }
            prekey = (int) (entry.getKey() >> 30);
            result.add(new ArrayList<>(entry.getValue()));
        }
        return result;
    }

    void preOrderTraversal(TreeNode root, long hd, long vd,
                           TreeMap<Long, Vector<Integer>> m) {
        if (root == null || root.val == -1)
            return;
        long val = hd << 30 | vd;

        if (m.get(val) != null)
            m.get(val).add(root.val);
        else {
            Vector<Integer> v = new Vector<>();
            v.add(root.val);
            m.put(val, v);
        }
        preOrderTraversal(root.left, hd - 1, vd + 1, m);
        preOrderTraversal(root.right, hd + 1, vd + 1, m);
    }

    static void verticalOrder(TreeNode root) {

    }


}
