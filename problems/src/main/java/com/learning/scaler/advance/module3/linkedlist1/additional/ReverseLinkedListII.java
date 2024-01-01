package com.learning.scaler.advance.module3.linkedlist1.additional;

import com.learning.scaler.advance.module3.ListNode;

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

        ListNode fifth = new ListNode(5);
        ListNode fourth = new ListNode(4);
        ListNode third = new ListNode(3);
        ListNode second = new ListNode(2);

        ListNode head = new ListNode(1);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        head.printAll();
        head = reverseBetween(head, 2, 4);
        head.printAll();

    }

    public static ListNode reverseBetween(ListNode A, int B, int C) {
        int nodeToReverse = C - B + 1, start = 1;
        ListNode temp = A;
        while(start < B){
            temp = temp.next;
            start++;
        }
        ListNode revStart = temp.next;
        temp.next = null;


        return A;
    }
}
