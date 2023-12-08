package com.learning;

import com.learning.scaler.advance.module3.ListNode;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
    }

    static int  lPalin(ListNode A)
    {
        ListNode slow = A;
        int ispalin = 1;
        Stack<Integer> stack = new Stack<Integer>();

        while (slow != null) {
            stack.push(slow.val);
            slow = slow.next;
        }
        while (A != null) {
            int i = stack.pop();
            if (A.val != i) {
                ispalin = 0;
                break;
            }
            A = A.next;
        }
        return ispalin;
    }
}
 