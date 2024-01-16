package com.learning.scaler.advance.module3.linkedlist2.additional;

import com.learning.scaler.advance.module3.ListNode;
import com.learning.scaler.advance.module3.ListNodeConstructor;

import java.util.List;

/*
Problem Description
    Given a linked list A, swap every two adjacent nodes and return its head.
    NOTE: Your algorithm should use only constant space. You may not modify the values in the list; only nodes themselves can be changed.

Problem Constraints
    1 <= |A| <= 10^6

Input Format
    The first and the only argument of input contains a pointer to the head of the given linked list.

Output Format
    Return a pointer to the head of the modified linked list.

Example Input
    Input 1:
        A = 1 -> 2 -> 3 -> 4
    Input 2:
        A = 7 -> 2 -> 1

Example Output
    Output 1:
        2 -> 1 -> 4 -> 3
    Output 2:
        2 -> 7 -> 1

Example Explanation
    Explanation 1:
        In the first example (1, 2) and (3, 4) are the adjacent nodes. Swapping them will result in 2 -> 1 -> 4 -> 3
    Explanation 2:
        In the second example, 3rd element i.e. 1 does not have an adjacent node, so it won't be swapped.
* */
public class SwapListNodeInPairs {

    public static void main(String[] args) {
        SwapListNodeInPairs pairs = new SwapListNodeInPairs();
        pairs.swapPairs(ListNodeConstructor.construct(List.of(1, 2, 3, 4, 5))).printAll();
        /*pairs.swapPairs(ListNodeConstructor.construct(List.of(1, 2, 3, 4, 5, 6))).printAll();
        pairs.swapPairs(ListNodeConstructor.construct(List.of(1))).printAll();
        pairs.swapPairs(ListNodeConstructor.construct(List.of(1, 2))).printAll();*/

    }

    public ListNode swapPairs(ListNode A) {
        if (A == null || A.next == null) return A;
        ListNode root = A.next, temp = A, prev = null, next = null;
        /*while (temp != null && temp.next != null) {
            next = temp.next.next;

            ListNode secondPair = temp.next;
            temp.next = remaining;
            secondPair.next = temp;
            temp = remaining;
        }*/
        return root;
    }
}
