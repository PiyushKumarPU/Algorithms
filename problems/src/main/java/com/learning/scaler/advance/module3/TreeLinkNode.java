package com.learning.scaler.advance.module3;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TreeLinkNode {
    @NonNull
    int val;
    TreeLinkNode left, right, next;
}
