package com.learning.leet.code;

import com.learning.scaler.advance.module3.TreeNode;

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return false;
        return isSymmetric(root.left, root.right);

    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        else if (left == null || right == null) return false;

        return
                (left.val == right.val) &&
                        isSymmetric(left.left, right.right) &&
                        isSymmetric(left.right, right.left);

    }
}
