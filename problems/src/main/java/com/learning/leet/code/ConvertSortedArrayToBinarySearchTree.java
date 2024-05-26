package com.learning.leet.code;

import com.learning.scaler.advance.module3.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        return constructNode(nums, 0, nums.length - 1);
    }

    private TreeNode constructNode(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = (end + start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = constructNode(nums, start, mid - 1);
        root.right = constructNode(nums, mid + 1, end);
        return root;
    }
}
