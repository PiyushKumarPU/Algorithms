package com.learning.practise.leetcode.linkedlist;

import com.learning.scaler.advance.module3.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;


// https://leetcode.com/problems/merge-k-sorted-lists/submissions/1217835221/
public class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        ListNode result = new ListNode(0);
        ListNode temp = result;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        for(ListNode node : lists) if(node != null )minHeap.add(node);
        while (!minHeap.isEmpty()) {
            ListNode current = minHeap.poll();
            temp.next = current;
            temp = temp.next;
            if(current.next != null)
                minHeap.add(current.next);
        }
        return result.next;
    }
}
