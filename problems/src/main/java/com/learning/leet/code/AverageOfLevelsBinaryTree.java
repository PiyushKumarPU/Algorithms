package com.learning.leet.code;

import com.learning.scaler.advance.module3.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            long nodeValSum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                nodeValSum += curr.val;
                if ((curr.left != null)) queue.add(curr.left);
                if ((curr.right != null)) queue.add(curr.right);
            }
            res.add((double) (nodeValSum / size));
        }
        return res;
    }
}
