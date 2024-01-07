package com.learning.scaler.advance.module3.tree2.lecture;

import com.learning.Solution;
import com.learning.scaler.advance.module3.LevelOrderTreeConstruction;
import com.learning.scaler.advance.module3.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void main(String[] args) {
        LevelOrderTraversal solution = new LevelOrderTraversal();
        System.out.println(solution.levelOrderTraversal(LevelOrderTreeConstruction.constructTree(
                List.of(16, 7, 3, 5, 9, 8, 6, 15))));
    }

    public List<Integer> levelOrderTraversal(TreeNode A) {
        Queue<TreeNode> treeNodes = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        treeNodes.offer(A);
        while (!treeNodes.isEmpty()) {
            TreeNode current = treeNodes.poll();
            result.add(current.val);
            if (current.left != null)
                treeNodes.offer(current.left);
            if (current.right != null)
                treeNodes.offer(current.right);
        }
        return result;
    }
}
