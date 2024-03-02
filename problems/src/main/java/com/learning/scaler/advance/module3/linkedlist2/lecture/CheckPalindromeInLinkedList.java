package com.learning.scaler.advance.module3.linkedlist2.lecture;

import com.learning.scaler.advance.module3.ListNode;
import com.learning.scaler.advance.module3.ListNodeConstructor;

import java.util.ArrayList;
import java.util.List;

public class CheckPalindromeInLinkedList {

    public static void main(String[] args) {
        ListNode A = ListNodeConstructor.construct(List.of(1, 3, 2, 2, 3, 1));
        /*System.out.println(isPalindromeWithoutReverse(A));
        System.out.println(isPalindrome(A));*/
        System.out.println(isPalindromeSuperSolution(A));

    }


    public static boolean isPalindromeWithoutReverse(ListNode A) {
        if (A == null || A.next == null) return true;
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
        ListNode secondHalfReversed = reverseList(ListNodeConstructor.cloneListNode(current));
        temp = A;
        while (secondHalfReversed != null) {
            if (temp.val != secondHalfReversed.val) return false;
            secondHalfReversed = secondHalfReversed.next;
            temp = temp.next;
        }
        return true;
    }

    public static boolean isPalindrome(ListNode A) {
        if (A == null || A.next == null) return true;
        ListNode reversed = reverseList(ListNodeConstructor.cloneListNode(A));
        ListNode temp = A;
        while (temp != null) {
            if (temp.val != reversed.val) return false;
            temp = temp.next;
            reversed = reversed.next;
        }
        return true;
    }

    public static boolean isPalindromeSuperSolution(ListNode A) {
        if (A == null || A.next == null) return true;
        List<ListNode> tempList = new ArrayList<>();
        ListNode temp = A;
        while (temp != null) {
            tempList.add(temp);
            temp = temp.next;
        }
        int size = tempList.size();
        int start = 0, end = size - 1;
        while (start < end) {
            if (tempList.get(start).val != tempList.get(end).val) return false;
            start++;
            end--;
        }
        return true;
    }


    private static ListNode reverseList(ListNode A) {
        if (A == null || A.next == null) return A;
        ListNode current = A;
        ListNode next, prev = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }


}
