package com.learning.scaler.advance.module3.stack1.lecture;

public class StackTest {

    public static void main(String[] args) {
        StackUsingDynamicArray<Integer> stack =
                new StackUsingDynamicArray<>(5);

        stack.push(13);
        stack.push(22);
        stack.push(33);
        while (!stack.isEmpty()) {
            System.out.println("Size " + stack.size());
            System.out.println("Element at top " + stack.peek());
            System.out.println("Current Element " + stack.pop());
        }


        System.out.println();
        StackUsingLinkedList list = new StackUsingLinkedList();
        list.push(24);
        list.push(35);
        list.push(36);
        while (!list.isEmpty()) {
            System.out.println("Size " + list.size());
            System.out.println("Element at top " + list.peek());
            System.out.println("Current Element " + list.pop());
        }
    }
}
