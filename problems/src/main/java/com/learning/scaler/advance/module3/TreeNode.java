package com.learning.scaler.advance.module3;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val){
        this.val = val;
    }
}
