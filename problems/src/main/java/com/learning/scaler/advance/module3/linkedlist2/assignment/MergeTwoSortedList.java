package com.learning.scaler.advance.module3.linkedlist2.assignment;

import com.learning.scaler.advance.module3.ListNode;
import com.learning.scaler.advance.module3.ListNodeConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
Problem Description
    Merge two sorted linked lists, A and B, and return it as a new list.
    The new list should be made by splicing together the nodes of the first two lists and should also be
    sorted.

Problem Constraints
    0 <= |A|, |B| <= 105

Input Format
    The first argument of input contains a pointer to the head of linked list A.
    The second argument of input contains a pointer to the head of linked list B.

Output Format
    Return a pointer to the head of the merged linked list.

Example Input
    Input 1:
        A = 5 -> 8 -> 20
        B = 4 -> 11 -> 15
    Input 2:
         A = 1 -> 2 -> 3
         B = Null
Example Output
    Output 1:
        4 -> 5 -> 8 -> 11 -> 15 -> 20
    Output 2:
        1 -> 2 -> 3

Example Explanation
    Explanation 1:
        Merging A and B will result in 4 -> 5 -> 8 -> 11 -> 15 -> 20
    Explanation 2:
        We don't need to merge as B is empty.
* */
public class MergeTwoSortedList {

    public static void main(String[] args) {
        mergeTwoLists(ListNodeConstructor.construct(List.of(5, 8, 20)),
                ListNodeConstructor.construct(List.of(4, 11, 15))).printAll();


    }


    // TODO : Implement using merge sort
    public static ListNode mergeTwoLists(ListNode A, ListNode B) {
        if (A == null && B == null) return null;
        else if (A == null) return B;
        else if (B == null) return A;
        ListNode root = null;
        ListNode current = null;
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        minHeap.add(new Pair(A.val, A));
        minHeap.add(new Pair(B.val, B));
        while (!minHeap.isEmpty()) {
            Pair currentPoll = minHeap.poll();
            ListNode next = currentPoll.next.next;
            if (next != null) {
                minHeap.add(new Pair(next.val, next));
            }

            if (root == null) {
                root = new ListNode(currentPoll.val);
                current = root;
            } else {
                current.next = new ListNode(currentPoll.val);
                current = current.next;
            }
        }
        return root;
    }
}

class Pair {
    int val;
    ListNode next;

    public Pair(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
