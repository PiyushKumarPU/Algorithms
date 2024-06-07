package com.learning.leet.code;

import com.learning.scaler.advance.module3.TreeNode;

public class LowestCommonAncestorOfBST {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        if (p.val > q.val) return lowestCommonAncestor(root, q, p);
        if (p.val < root.val && q.val > root.val) return root;
        else if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        else if (p.val > root.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}
