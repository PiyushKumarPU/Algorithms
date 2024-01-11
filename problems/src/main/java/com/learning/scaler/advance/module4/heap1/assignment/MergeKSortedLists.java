package com.learning.scaler.advance.module4.heap1.assignment;

import com.learning.scaler.advance.module3.ListNode;
import com.learning.scaler.advance.module3.ListNodeConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
Problem Description
    Given a list containing head pointers of N sorted linked lists.
    Merge these given sorted linked lists and return them as one sorted list.

Problem Constraints
    1 <= total number of elements in given linked lists <= 100000

Input Format
    The first and only argument is a list containing N head pointers.

Output Format
    Return a pointer to the head of the sorted linked list after merging all the given linked lists.

Example Input
    Input 1:
         1 -> 10 -> 20
         4 -> 11 -> 13
         3 -> 8 -> 9
    Input 2:
         10 -> 12
         13
         5 -> 6

Example Output
    Output 1:
        1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
    Output 2:
        5 -> 6 -> 10 -> 12 ->13

Example Explanation
    Explanation 1:
         The resulting sorted Linked List formed after merging is 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20.
    Explanation 2:
         The resulting sorted Linked List formed after merging is 5 -> 6 -> 10 -> 12 ->13.
* */
public class MergeKSortedLists {

    public static void main(String[] args) {

        ListNode listNode1 = ListNodeConstructor.construct(List.of(1, 10, 20));
        ListNode listNode2 = ListNodeConstructor.construct(List.of(4, 11, 13));
        ListNode listNode3 = ListNodeConstructor.construct(List.of(3, 8, 9));

        ArrayList<ListNode> a = new ArrayList<>(List.of(listNode1, listNode2, listNode3));

        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();

        ListNode result = mergeKSortedLists.mergeKLists(a);
        result.printAll();

    }

    public ListNode mergeKLists(ArrayList<ListNode> a) {
        int listSize = a.size();
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(listSize, Comparator.comparingInt(o -> o.val));
        for (int i = 0; i < listSize; i++) {
            minHeap.add(a.get(i));
        }
        ListNode root = null, current = null;
        while (!minHeap.isEmpty()) {
            ListNode min = minHeap.poll();
            if (min.next != null)
                minHeap.add(min.next);
            ListNode temp = new ListNode(min.val);
            if (root == null) {
                root = temp;
                current = root;
            } else {
                current.next = temp;
            }
            current = temp;
        }
        return root;
    }
}

class MergeBean {
    public Integer listIndex;
    ListNode listNode;

    public MergeBean(int listIndex, ListNode listNode) {
        this.listIndex = listIndex;
        this.listNode = listNode;
    }
}
