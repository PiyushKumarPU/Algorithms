package com.learning.scaler.advance.module3.linkedlist2.lecture;

import com.learning.scaler.advance.module3.ListNode;
import com.learning.scaler.advance.module3.ListNodeConstructor;

import java.util.HashSet;
import java.util.List;

/*
Given head, the head of a linked list, determine if the linked list has a cycle in it.
There is a cycle in a linked list if there is some node in the list that can be reached again by
continuously following the next pointer. Internally, pos is used to denote the index of the node that
tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

Example 1:
    Input: head = [3,2,0,-4], pos = 1
    Output: true
    Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
Example 2:

    Input: head = [1,2], pos = 0
    Output: true
    Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
Example 3:
    Input: head = [1], pos = -1
    Output: false
    Explanation: There is no cycle in the linked list.


Constraints:
    The number of the nodes in the list is in the range [0, 10^4].
    -10^5 <= Node.val <= 10^5
    pos is -1 or a valid index in the linked-list.


Follow up: Can you solve it using O(1) (i.e. constant) memory?
* */
public class FindCycleInLinkedList {


    public static void main(String[] args) {
        ListNode head = ListNodeConstructor.construct(List.of(-21, 10, 17, 8, 4, 26, 5, 35, 33, -7, -16, 27, -12, 6, 29, -12, 5, 9, 20, 14, 14, 2, 13, -24, 21, 23, -21, 5));
        System.out.println(hasCycleConstantSpace(head));

    }


    public boolean hasCycleWithSpace(ListNode head) {
        HashSet<ListNode> visitedSet = new HashSet<>();
        ListNode temp = head;
        while (temp != null) {
            if (visitedSet.contains(temp)) return true;
            visitedSet.add(temp);
            temp = temp.next;
        }
        return false;
    }

    public static boolean hasCycleConstantSpace(ListNode head) {
        if (head == null) return false;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
