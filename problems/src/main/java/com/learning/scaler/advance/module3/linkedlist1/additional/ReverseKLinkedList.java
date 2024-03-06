package com.learning.scaler.advance.module3.linkedlist1.additional;

import com.learning.scaler.advance.module3.ListNode;
import com.learning.scaler.advance.module3.ListNodeConstructor;

import java.util.List;

/*
Problem Description
    Given a singly linked list A and an integer B, reverse the nodes of the list B at a time and
    return the modified linked list.

Problem Constraints
    1 <= |A| <= 10^3
    B always divides A

Input Format
    The first argument of input contains a pointer to the head of the linked list.
    The second argument of input contains the integer, B.

Output Format
    Return a pointer to the head of the modified linked list.

Example Input
    Input 1:
        A = [1, 2, 3, 4, 5, 6]
        B = 2
    Input 2:
        A = [1, 2, 3, 4, 5, 6]
        B = 3


Example Output
    Output 1:
        [2, 1, 4, 3, 6, 5]
    Output 2:
        [3, 2, 1, 6, 5, 4]

Example Explanation
    Explanation 1:
    For the first example, the list can be reversed in groups of 2.
        [[1, 2], [3, 4], [5, 6]]
     After reversing the K-linked list
        [[2, 1], [4, 3], [6, 5]]
    Explanation 2:
    For the second example, the list can be reversed in groups of 3.
        [[1, 2, 3], [4, 5, 6]]
     After reversing the K-linked list
        [[3, 2, 1], [6, 5, 4]]
* */
public class ReverseKLinkedList {

    public static void main(String[] args) {

        List<Integer> inputs = List.of(850, 3137, 5924, 538, 8654, 5070, 8451, 3420, 1916, 6276, 1145, 6841, 4240, 8385, 8413, 27, 6828, 4671, 2526, 5631, 571, 5363, 2349, 1055, 4746, 6500, 6152, 9019, 3348, 6291, 8586, 1211, 869, 9448, 996, 7167, 2504, 5423, 7730, 6032, 6891, 9829, 8550, 4511, 8658, 3726, 8575, 7209, 4944, 1271, 9684, 3678, 1686, 2289, 203, 521, 6659, 5077, 6726, 6733, 785, 4987, 9060, 6479, 9142, 5277, 8276, 9216, 4997, 9125, 2568, 3117, 9716, 4063, 1085, 4592, 5765, 8802, 9545, 7848, 2837, 7571, 3438, 9074, 9020, 8696, 2754, 3697, 7431, 1810, 4114, 8777, 6232, 1438, 4668);

        ReverseKLinkedList list = new ReverseKLinkedList();
        list.reverseList(ListNodeConstructor.construct(inputs), 5).printAll();
    }

    public ListNode reverseList(ListNode A, int B) {
        if (A == null || A.next == null || B < 1) return A;
        int size = 0;
        ListNode temp = A;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        int iterationCount = size / B + (size % B > 0 ? 1 : 0);
        A = reverseListWithNodeCount(A, B);
        ListNode prevEnd = A;
        for (int index = 1; index < iterationCount; index++) {
            int jumpCount = B - 1;
            while (jumpCount > 0 && prevEnd != null) {
                prevEnd = prevEnd.next;
                jumpCount--;
            }
            if (prevEnd != null) {
                prevEnd.next = reverseListWithNodeCount(prevEnd.next, B);
                prevEnd = prevEnd.next;
            }
        }
        return A;
    }

    private ListNode reverseListWithNodeCount(ListNode A, int count) {
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
