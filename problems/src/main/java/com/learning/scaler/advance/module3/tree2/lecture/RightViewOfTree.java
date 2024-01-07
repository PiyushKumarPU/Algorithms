package com.learning.scaler.advance.module3.tree2.lecture;

import com.learning.scaler.advance.module3.LevelOrderTreeConstruction;
import com.learning.scaler.advance.module3.TreeNode;
import com.sun.source.tree.Tree;

import java.util.*;

public class RightViewOfTree {

    public static void main(String[] args) {
        TreeNode treeNode = LevelOrderTreeConstruction.constructTree(List.of(1, 2, 3, 4, 5, 6, 7, 8));
        System.out.println(new RightViewOfTree().solve(treeNode));
        treeNode = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        treeNode.left = node2;
        treeNode.right = node3;
        node2.right = node4;
        node4.right = node5;

        System.out.println(new RightViewOfTree().solve(treeNode));
    }

    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(A);
        while (!treeNodes.isEmpty()) {
            int queueSize = treeNodes.size();
            List<Integer> currentResult = new ArrayList<>();
            for (int index = 0; index < queueSize; index++) {
                TreeNode current = treeNodes.poll();
                if (current != null) {
                    currentResult.add(current.val);
                    if (current.left != null) treeNodes.offer(current.left);
                    if (current.right != null) treeNodes.offer(current.right);
                }
            }
            result.add(currentResult.get(currentResult.size() - 1));
        }
        return result;
    }

}
