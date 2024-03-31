package com.learning.scaler.advance.module3.stack1.lecture;


import com.learning.scaler.advance.module3.ListNode;

/*
Design a stack that supports increment operations on its elements.

Implement the CustomStack class:

    CustomStack(int maxSize) Initializes the object with maxSize which is the maximum number of
    elements in the stack.
    void push(int x) Adds x to the top of the stack if the stack has not reached the maxSize.
    int pop() Pops and returns the top of the stack or -1 if the stack is empty.
    void inc(int k, int val) Increments the bottom k elements of the stack by val.
    If there are less than k elements in the stack, increment all the elements in the stack.
* */
public class CustomStack {


    public static void main(String[] args) {
        CustomStack stack = new CustomStack(3);
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.increment(5, 100);
        stack.increment(2, 100);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }

    private ListNode head;
    int size, maxSize;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
    }

    public void push(int x) {
        if (size < maxSize) {
            ListNode current = new ListNode(x);
            if (head != null) {
                current.next = head;
            }
            head = current;
            size++;
        }
    }

    public int pop() {
        if (size > 0) {
            int currentVal = head.val;
            size--;
            head = head.next;
            return currentVal;
        }
        return -1;
    }

    public void increment(int k, int val) {
        if (size > 0) {
            int jump = k >= size ? 0 : (size - k);
            ListNode temp = head;
            while (jump > 0 && temp != null) {
                temp = temp.next;
                jump--;
            }
            while (temp != null) {
                temp.val += val;
                temp = temp.next;
            }
        }
    }
}
