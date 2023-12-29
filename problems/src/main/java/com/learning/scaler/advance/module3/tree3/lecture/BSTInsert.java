package com.learning.scaler.advance.module3.tree3.lecture;

import com.learning.scaler.advance.module3.PrintTreeNode;
import com.learning.scaler.advance.module3.TreeNode;
import com.sun.source.tree.Tree;

import java.util.TreeMap;

public class BSTInsert {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(15);
        TreeNode node12 = new TreeNode(12);
        TreeNode node10 = new TreeNode(10);
        TreeNode node14 = new TreeNode(14);
        TreeNode node8 = new TreeNode(8);

        TreeNode node20 = new TreeNode(20);
        TreeNode node16 = new TreeNode(16);
        TreeNode node27 = new TreeNode(27);

        node10.setLeft(node8);
        node12.setLeft(node10);
        node12.setRight(node14);
        root.setLeft(node12);
        root.setRight(node20);
        node20.setLeft(node16);
        node20.setRight(node27);

        System.out.println(PrintTreeNode.traversePreOrder(insert(root, 35)));
        System.out.println(PrintTreeNode.traversePreOrder(insert(root, 15)));
        System.out.println(PrintTreeNode.traversePreOrder(insert(root, 1)));
    }

    public static TreeNode insert(TreeNode A, int newVal) {
        TreeNode newNode = new TreeNode(newVal);
        if (A == null) return newNode;
        TreeNode parent = null, temp = A;
        while (temp != null && temp.getVal() != newVal) {
            if (newVal > temp.getVal()) {
                parent = temp;
                temp = temp.getRight();
            } else {
                parent = temp;
                temp = temp.getLeft();
            }
        }
        // here parent will be null only if respective element is already present in tree
        if (parent != null) {
            if (parent.getVal() > newVal) parent.setLeft(newNode);
            else parent.setRight(newNode);
        }
        return A;
    }
}
