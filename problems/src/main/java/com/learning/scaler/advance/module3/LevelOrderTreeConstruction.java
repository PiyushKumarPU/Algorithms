package com.learning.scaler.advance.module3;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTreeConstruction {

    public static TreeNode constructTree(List<Integer> A) {
        if (A == null || A.isEmpty() || A.get(0) == -1) {
            return null;
        }

        TreeNode root = new TreeNode(A.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        for (int i = 1; i < A.size(); i += 2) {
            TreeNode current = queue.poll();

            if (A.get(i) != null && A.get(i) > -1) {
                current.left = new TreeNode(A.get(i));
                queue.offer(current.left);
            }

            if (i + 1 < A.size() && A.get(i + 1) != null && A.get(i + 1) > -1) {
                current.right = new TreeNode(A.get(i + 1));
                queue.offer(current.right);
            }
        }
        return root;
    }
}
