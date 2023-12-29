package com.learning.scaler.advance.module3;

import lombok.Data;
import lombok.NonNull;

@Data
public class TreeNode {
    @NonNull
    int val;
    TreeNode left;
    TreeNode right;
}
