package com.learning.leet.code;

import com.learning.scaler.advance.module3.TreeNode;

public class SumOfNodesWithEvenValuedGrandparent {

    int total = 0;
    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) return 0;
        calculateTotal(root);
        return total;
    }

    private void calculateTotal(TreeNode treeNode) {
        if (treeNode == null) return;
        if (treeNode.val % 2 == 0) {
            if (treeNode.left != null) {
                total += treeNode.left.left != null ? treeNode.left.left.val : 0;
                total += treeNode.left.right != null ? treeNode.left.right.val : 0;
            }
            if (treeNode.right != null){
                total += treeNode.right.left != null ? treeNode.right.left.val : 0;
                total += treeNode.right.right != null ? treeNode.right.right.val : 0;
            }
        }
        calculateTotal(treeNode.left);
        calculateTotal(treeNode.right);
    }
}
