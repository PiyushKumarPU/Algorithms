package com.learning.scaler.advance.module3.linkedlist3.assignment;


import com.learning.scaler.advance.module3.linkedlist3.RandomListNode;

import java.util.HashMap;

/*
Problem Description
    You are given a linked list A
    Each node in the linked list contains two pointers: a next pointer and a random pointer
    The next pointer points to the next node in the list
    The random pointer can point to any node in the list, or it can be NULL
    Your task is to create a deep copy of the linked list A
    The copied list should be a completely separate linked list from the original list, but with the same node values and random pointer connections as the original list
    You should create a new linked list B, where each node in B has the same value as the corresponding node in A
    The next and random pointers of each node in B should point to the corresponding nodes in B (rather than A)

Problem Constraints
    0 <= |A| <= 10^6

Input Format
    The first argument of input contains a pointer to the head of linked list A.

Output Format
    Return a pointer to the head of the required linked list.

Example Input
    Given list
       1 -> 2 -> 3
    with random pointers going from
      1 -> 3
      2 -> 1
      3 -> 1

Example Output
       1 -> 2 -> 3
    with random pointers going from
      1 -> 3
      2 -> 1
      3 -> 1

Example Explanation
    You should return a deep copy of the list. The returned answer should not contain the same
    node as the original list, but a copy of them. The pointers in the returned list should not link to any
    node in the original input list.
* */
public class CopyList {

    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);

        head.next = node2;
        node2.next = node3;
        head.random = node3;
        node2.random = head;
        node3.random = head;

        RandomListNode result = copyRandomList(head);
        System.out.println(result);

    }

    public static RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode result = new RandomListNode(0);
        RandomListNode tempResult = result;
        HashMap<Integer, RandomListNode> valNodeMap = new HashMap<>();
        RandomListNode temp = head;
        while (temp != null) {
            RandomListNode newNode = new RandomListNode(temp.label);
            valNodeMap.put(temp.label, newNode);
            result.next = newNode;
            result = result.next;
            temp = temp.next;
        }

        temp = head;
        result = tempResult.next;
        while (temp != null) {
            result.random = valNodeMap.get(temp.random.label);
            result = result.next;
            temp = temp.next;
        }

        return tempResult.next;
    }
}
