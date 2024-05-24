package com.learning.leet.code;

import com.learning.scaler.advance.module3.LevelOrderTreeConstruction;
import com.learning.scaler.advance.module3.PrintTreeNode;
import com.learning.scaler.advance.module3.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTreeToLinkedList {

    ArrayList<Integer> result;

    public static void main(String[] args) {
        TreeNode node = LevelOrderTreeConstruction.constructTree(List.of(1, 2, 5, 3, 4, 6));
        new FlattenBinaryTreeToLinkedList().flatten(node);
        System.out.println(PrintTreeNode.traversePreOrder(node));
    }

    public void flatten(TreeNode root) {
        if (root == null) return;
        result = new ArrayList<>();
        preOrderWorker(root);
        root = new TreeNode(result.get(0));
        TreeNode temp = root;
        for (int i = 1; i < result.size(); i++) {
            temp.right = new TreeNode(result.get(i));
            temp.left = null;
            temp = temp.right;
        }
    }

    void preOrderWorker(TreeNode treeNode) {
        if (treeNode == null) return;
        result.add(treeNode.val);
        preOrderWorker(treeNode.left);
        preOrderWorker(treeNode.right);

    }

}
