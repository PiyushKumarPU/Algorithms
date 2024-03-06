package com.learning.scaler.advance.module3.linkedlist3.additional;


import com.learning.scaler.advance.module3.ListNode;

/*
Problem Description
    Write a program to find the node at which the intersection of two singly linked lists, A and B, begins.
    For example, the following two linked lists:
    A:          a1 → a2
                       ↘
                         c1 → c2 → c3
                       ↗
    B:     b1 → b2 → b3
NOTE:
    If the two linked lists have no intersection at all, return null.
    The linked lists must retain their original structure after the function returns.
    You may assume there are no cycles anywhere in the entire linked structure.
    Your code should preferably run in O(n) time and use only O(1) memory.
    The custom input to be given is different than the one explained in the examples. Please be careful.

Problem Constraints
    0 <= |A|, |B| <= 10^6

Input Format
    The first argument of input contains a pointer to the head of the linked list A.
    The second argument of input contains a pointer to the head of the linked list B.

Output Format
    Return a pointer to the node after which the linked list is intersecting.

Example Input
    Input 1:
         A = [1, 2, 3, 4, 5]
         B = [6, 3, 4, 5]
    Input 2:
         A = [1, 2, 3]
         B = [4, 5]

Example Output
    Output 1:
         [3, 4, 5]
    Output 2:
         []

Example Explanation
    Explanation 1:
         In the first example, the nodes have the same values after 3rd node in A and 2nd node in B. Thus, the linked lists are intersecting after that point.
    Explanation 2:
         In the second example, the nodes don't have the same values, thus we can return None/Null.
* */
public class IntersectionOfLinkedLists {

    public ListNode getIntersectionNode(ListNode A, ListNode B) {
        ListNode lastA, lastB;
        int countA, countB;

        if (A == null || B == null)
            return null;

        countA = countB = 1;

        lastA = A;
        lastB = B;

        while (lastA.next != null) {
            lastA = lastA.next;
            countA++;
        }

        while (lastB.next != null) {
            lastB = lastB.next;
            countB++;
        }

        if (!lastA.equals(lastB))
            return null;

        int diff = Math.abs(countA - countB);

        lastA = A;
        lastB = B;

        if (countA > countB) {
            while (diff-- > 0) {
                lastA = lastA.next;
            }
        } else {
            while (diff-- > 0)
                lastB = lastB.next;
        }

        while (!lastA.equals(lastB)) {
            lastA = lastA.next;
            lastB = lastB.next;
        }

        return lastA;

    }

    public ListNode getIntersectionNodeHelp(ListNode A, ListNode B) {
        if (A == null || B == null) {
            return null;
        }

        ListNode p1 = A;
        ListNode p2 = B;

        while (p1 != p2) {
            p1 = (p1 == null) ? B : p1.next;
            p2 = (p2 == null) ? A : p2.next;
        }

        return p1;
    }
}
