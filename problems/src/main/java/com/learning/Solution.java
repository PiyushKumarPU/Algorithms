package com.learning;

import com.learning.scaler.advance.module3.ListNode;
import com.learning.scaler.advance.module3.TreeLinkNode;
import com.learning.scaler.advance.module3.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        root.setLeft(node9);
        root.setRight(node20);
        node20.setLeft(node15);
        node20.setRight(node7);

        System.out.println(solve(root));

    }

    public static ArrayList<ArrayList<Integer>> solve(TreeNode A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(A);
        //queue.enqueue(A);
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                list.add(curr.getVal());
                if ((curr.getLeft() != null)) queue.add(curr.getLeft());
                if ((curr.getRight() != null)) queue.add(curr.getRight());
            }
            res.add(list);
        }
        return res;
    }
}
 