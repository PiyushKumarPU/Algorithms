package com.learning.leet.code;


import com.learning.scaler.advance.module3.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// https://leetcode.com/problems/merge-k-sorted-lists/
public class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length < 1) return null;
        ListNode result = new ListNode(0);
        ListNode temp = result;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));
        for (ListNode node : lists) if (node != null) minHeap.add(node);
        while (!minHeap.isEmpty()) {
            ListNode current = minHeap.poll();
            temp.next = new ListNode(current.val);
            temp = temp.next;
            if (current.next != null)
                minHeap.offer(current.next);
        }
        return result.next;
    }

}