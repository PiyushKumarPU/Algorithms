package com.learning.scaler.advance.module3.contest4;

import com.learning.scaler.advance.module3.ListNode;

/*
    Problem Description:
        You are given two linked lists: A and B of sizes N and M respectively, and two integers C and D.Remove linked list A's nodes from the Cth indexed node to the Dth indexed node (0-based indexing), and put the linked list B in their place. Please read the examples given below carefully to better understand the problem.

    Problem Constraints:
        0 <= N <= 10^5
        0 <= M <= 10^5
        0 <= A[i], B[i] <= 10^5
        1 <= C,D <= N- 1
    Input Format:
        First argument A is a linked list.
        Second argument B is a linked list.
        Third argument C is an integer.
        Fourth argument D is an integer.
    Output Format:
        Return the final linked list after inserting linked list B in the linked list A.
    Example Input:
        Input 1:
            A = [0, 1, 2, 3, 4, 5]
            B = [0, 1, 2]
            C = 3
            D = 4
        Input 2:
            A = [0, 1, 2, 3, 4, 5, 6]
            B = [0, 1, 2, 3, 4]
            C = 2
            D = 5
    Example Output:
        Output 1:
            [0, 1, 2, 0, 1, 2, 5]
        Output 2:
            [0, 1, 0, 1, 2, 3, 4, 6]
    Example Explanation:
        Example 1:
            We remove the nodes 3 and 4 and put the entire B in their place.
            Now the list becomes [0, 1, 2] + [0, 1, 2] + [5] = [0, 1, 2, 0, 1, 2, 5]

        Example 2:
            We remove the nodes 2, 3, 4 and 5 and put the entire B in their place.
            Now the list becomes [0, 1] + [0, 1, 2, 3, 4] + [6] = [0, 1, 0, 1, 2, 3, 4, 6]
* */
public class RemoveAndAddLinkedList {

    public static void main(String[] args) {

        ListNode A = new ListNode(0);
        ListNode A1 = new ListNode(1);
        ListNode A2 = new ListNode(2);
        ListNode A3 = new ListNode(3);
        ListNode A4 = new ListNode(4);
        ListNode A5 = new ListNode(5);

        A.next = A1;
        A1.next = A2;
        A2.next = A3;
        A3.next = A4;
        A4.next = A5;

        ListNode B = new ListNode(0);
        ListNode B1 = new ListNode(1);
        ListNode B2 = new ListNode(2);

        B.next = B1;
        B1.next = B2;

        ListNode listNode = solve(A,B,3,4);
        printNode(listNode);

    }

    private static void printNode(ListNode listNode){
        System.out.print(listNode.val);
        listNode = listNode.next;
        while (listNode != null){
            System.out.print("--> "+listNode);
            listNode = listNode.next;
        }
    }

    public static ListNode solve(ListNode A, ListNode B, int C, int D) {
        ListNode t1 = A;
        int jump = 0;
        // Jump C -1 to find the prev node before first node to remove
        while (jump < (C - 1)) {
            t1 = t1.next;
            jump++;
        }
        // jump D times to find last removed node
        ListNode t2 = A;
        jump = 0;
        while (jump < D) {
            jump++;
            t2 = t2.next;
        }
        // linking second LL to first
        t1.next = B;
        // go till end of LL and assign remaining node
        while (t1.next != null) {
            t1 = t1.next;
        }
        t1.next = t2.next;
        return A;
    }
}
