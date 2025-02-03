package com.learning.leet.code;

import com.learning.scaler.advance.module3.ListNode;
import com.learning.scaler.advance.module3.ListNodeConstructor;

import java.util.List;

// https://leetcode.com/problems/add-two-numbers/description/?envType=study-plan-v2&envId=top-interview-150
public class AddTwoNumbers {

    public static void main(String[] args) {

        ListNode l1 = ListNodeConstructor.construct(List.of(9, 9, 9, 9, 9, 9, 9));

        ListNode l2 = ListNodeConstructor.construct(List.of(9, 9, 9, 9));

        ListNode result = addTwoNumbers(l1, l2);
        result.printAll();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode current = temp;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }
        return temp.next;
    }
}
