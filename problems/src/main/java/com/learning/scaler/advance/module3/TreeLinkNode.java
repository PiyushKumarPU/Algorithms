package com.learning.scaler.advance.module3;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TreeLinkNode {
    public int val;
    public TreeLinkNode left, right, next;
    public TreeLinkNode(int val){
        this.val = val;
    }
}
