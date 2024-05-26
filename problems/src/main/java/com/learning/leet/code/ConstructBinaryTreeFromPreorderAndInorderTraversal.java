package com.learning.leet.code;

import com.learning.scaler.advance.module3.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 | inorder == null || inorder.length == 0) return null;
        Map<Integer, Integer> indexValMap = new HashMap<>();
        int index = 0;
        for (int i : inorder) indexValMap.put(i, index++);
        return buildTree(preorder, indexValMap, 0, inorder.length - 1, 0, preorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, Map<Integer, Integer> valIndexMap, int inStart, int inEnd,
                               int preStart, int preEnd) {
        if (inStart > inEnd) return null;
        int rootNode = preorder[preStart];
        int rootIndex = valIndexMap.getOrDefault(rootNode, -1);
        if (rootIndex < 0) return null;
        int eleCount = rootIndex - inStart;

        TreeNode root = new TreeNode(rootNode);
        root.left = buildTree(preorder, valIndexMap, inStart, rootIndex - 1, preStart + 1, preStart + eleCount);
        root.right = buildTree(preorder, valIndexMap, rootIndex + 1, inEnd, preStart + eleCount + 1, preEnd);
        return root;
    }
}
