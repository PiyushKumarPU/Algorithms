package com.learning.scaler.advance.module3.tree5.lecture;

import com.learning.scaler.advance.module3.TreeLinkNode;

public class PopulateNextPointerInPerfectBT {


    public void populateNextPointerWithRecursion(TreeLinkNode treeNode) {
        if (treeNode == null) return;
        if (treeNode.left == null && treeNode.right == null) return;
        else if (treeNode.left != null) {
            treeNode.left.next = treeNode.right;
            if (treeNode.next != null)
                treeNode.right.next = treeNode.next.left;
        }
        populateNextPointerWithRecursion(treeNode.left);
        populateNextPointerWithRecursion(treeNode.right);
    }

    public void populateNextPointer(TreeLinkNode treeNode) {
        TreeLinkNode temp = treeNode;
        while (temp.left != null) {
            TreeLinkNode current = temp;
            while (temp != null) {
                temp.left.next = temp.right;
                if (temp.next != null)
                    temp.right.next = temp.next.left;
                temp = temp.next;
            }
            temp = current.left;
        }
    }
}
