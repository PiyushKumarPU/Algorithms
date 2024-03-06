package com.learning.scaler.advance.module3.linkedlist1.additional;

import com.learning.scaler.advance.module3.ListNode;
import com.learning.scaler.advance.module3.ListNodeConstructor;

import java.util.List;

/*
Problem Description
    Reverse a linked list A from position B to C.
    NOTE: Do it in-place and in one-pass.

Problem Constraints
    1 <= |A| <= 10^6
    1 <= B <= C <= |A|

Input Format
    The first argument contains a pointer to the head of the given linked list, A.
    The second arugment contains an integer, B.
    The third argument contains an integer C.

Output Format
    Return a pointer to the head of the modified linked list.

Example Input
    Input 1:
        A = 1 -> 2 -> 3 -> 4 -> 5
        B = 2
        C = 4

    Input 2:
        A = 1 -> 2 -> 3 -> 4 -> 5
        B = 1
        C = 5


Example Output
    Output 1:
        1 -> 4 -> 3 -> 2 -> 5
    Output 2:
        5 -> 4 -> 3 -> 2 -> 1


Example Explanation
    Explanation 1:
        In the first example, we want to reverse the highlighted part of the given linked list : 1 -> 2 -> 3 -> 4 -> 5
        Thus, the output is 1 -> 4 -> 3 -> 2 -> 5
    Explanation 2:
        In the second example, we want to reverse the highlighted part of the given linked list : 1 -> 4 -> 3 -> 2 -> 5
        Thus, the output is 5 -> 4 -> 3 -> 2 -> 1
* */
public class ReverseLinkedListII {

    public static void main(String[] args) {

    }

    public ListNode reverseBetween(ListNode A, int m, int n) {
        int i;
        ListNode node = A;
        ListNode prev = null;
        m--;
        n--;
        for (i = 0; i < m; i++) {
            prev = node;
            node = node.next;
        }
        if (prev != null)
            prev.next = reverseList(node, n - m + 1);
        else
            A = reverseList(node, n - m + 1);
        return A;
    }

    private ListNode reverseList(ListNode A, int count) {
        if (A == null)
            return null;
        ListNode node = A, prev = null, temp;
        while (node != null && count > 0) {
            temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
            count--;
        }
        A.next = node;
        return prev;
    }

}
