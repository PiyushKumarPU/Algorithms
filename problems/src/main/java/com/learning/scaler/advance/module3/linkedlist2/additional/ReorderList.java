package com.learning.scaler.advance.module3.linkedlist2.additional;

import com.learning.scaler.advance.module3.ListNode;
import com.learning.scaler.advance.module3.ListNodeConstructor;

import java.util.List;
import java.util.Objects;

/*
Problem Description
    Given a singly linked list A
        A: A0 → A1 → … → An-1 → An
    reorder it to:
        A0 → An → A1 → An-1 → A2 → An-2 → …
    You must do this in-place without altering the nodes' values.

Problem Constraints
    1 <= |A| <= 10^6

Input Format
    The first and the only argument of input contains a pointer to the head of the linked list A.

Output Format
    Return a pointer to the head of the modified linked list.

Example Input
    Input 1:
        A = [1, 2, 3, 4, 5]
    Input 2:
        A = [1, 2, 3, 4]

Example Output
    Output 1:
        [1, 5, 2, 4, 3]
    Output 2:
        [1, 4, 2, 3]

Example Explanation
    Explanation 1:
        The array will be arranged to [A0, An, A1, An-1, A2].
    Explanation 2:
        The array will be arranged to [A0, An, A1, An-1, A2].
* */
public class ReorderList {

    public static void main(String[] args) {
        ListNode A = ListNodeConstructor.construct(List.of(1, 2, 3, 4));
        ListNode B = ListNodeConstructor.construct(List.of(1, 2, 3, 4, 5));
        Objects.requireNonNull(reorderList(A)).printAll();
        Objects.requireNonNull(reorderList(B)).printAll();
    }

    public static ListNode reorderList(ListNode A) {
        if (A == null || A.next == null) return A;

        int size = 0;
        ListNode temp = A;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        int secondHalf = (size + 1) / 2;
        ListNode current = A;
        int jumpCount = secondHalf;
        while (jumpCount > 0) {
            current = current.next;
            jumpCount--;
        }
        ListNode secondHalfReversed = ListNodeConstructor.reverseList(current, false);
        ListNode result = new ListNode(A.val);
        ListNode resultTemp = result;
        A = A.next;
        result.next = new ListNode(secondHalfReversed.val);
        result = result.next;
        secondHalfReversed = secondHalfReversed.next;
        while (secondHalfReversed != null && A != null) {
            result.next = new ListNode(A.val);
            result = result.next;
            result.next = new ListNode(secondHalfReversed.val);
            result = result.next;
            secondHalfReversed = secondHalfReversed.next;
            A = A.next;
        }
        if (A != null && size % 2 != 0) {
            A.next = null;
            result.next = A;
        }
        return resultTemp;
    }

    public ListNode reorderListScaler(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return head;

        ListNode slow = head, fast = head;
        while (slow != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        assert slow != null;
        ListNode mid = slow.next;
        slow.next = null;

        ListNode secondHalfReversed = reverseLinkedList(mid);
        return head = mergeTwoLists(head, secondHalfReversed);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode head = l1; // head of the list to return
        l1 = l1.next;
        ListNode p = head; // pointer to form new list
        // A boolean to track which list we need to extract from.
        // We alternate between first and second list.
        boolean curListNum = true;
        while (l1 != null && l2 != null) {
            if (curListNum == false) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
            if (curListNum) curListNum = false;
            else curListNum = true;
        }
        // add the rest of the tail, done!
        if (l1 != null) {
            p.next = l1;
        } else {
            p.next = l2;
        }
        return head;
    }

    ListNode reverseLinkedList(ListNode head) {
        if (head.next == null) return head;
        ListNode cur = head, nextNode = head.next, tmp;
        while (nextNode != null) {
            tmp = nextNode.next;
            nextNode.next = cur;
            cur = nextNode;
            nextNode = tmp;
        }
        head.next = nextNode;
        return cur;
    }

}
