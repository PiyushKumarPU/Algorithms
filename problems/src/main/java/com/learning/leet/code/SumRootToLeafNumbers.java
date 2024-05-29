package com.learning.leet.code;

import com.learning.scaler.advance.module3.TreeNode;
import com.sun.source.tree.Tree;

public class SumRootToLeafNumbers {

    int totalSum = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        sumNumbers(root, 0);
        return totalSum;
    }

    private void sumNumbers(TreeNode root, int currentVal) {
        if (root == null) return;
        currentVal = currentVal * 10 + root.val;
        if (root.left == null && root.right == null) totalSum += currentVal;
        else {
            if (root.left != null)
                sumNumbers(root.left, currentVal);
            if (root.right != null)
                sumNumbers(root.right, currentVal);
        }
    }
}
