package com.learning.scaler.advance.module3.queue.lecture;

import com.learning.scaler.advance.module3.queue.assignment.QueueUsingStacks;

import java.util.Stack;

public class QueueUsingStack<T> {

    Stack<T> container, auxSpace;
    int front = 0, rear = -1;

    public QueueUsingStack() {
        this.container = new Stack<>();
        this.auxSpace = new Stack<>();
    }

    public boolean isEmpty() {
        return container.isEmpty() && auxSpace.isEmpty();
    }

    public int size() {
        return isEmpty() ? 0 : container.size() + auxSpace.size();
    }

    public void push(T val) {
        container.push(val);
    }

    public T pop() {
        if (isEmpty()) return null;
        if (auxSpace.isEmpty()) {
            // push everything from container to aux space and return last item
            while (!container.isEmpty()) auxSpace.push(container.pop());
        }
        return auxSpace.pop();
    }

    public T peek() {
        if (isEmpty()) return null;
        if (auxSpace.isEmpty()) {
            // push everything from container to aux space and return last item
            while (!container.isEmpty()) auxSpace.push(container.pop());
        }
        return auxSpace.peek();
    }

    public static void main(String[] args) {

        QueueUsingStack<Integer> queueUsingStack = new QueueUsingStack<>();
        queueUsingStack.push(20);
        System.out.println(queueUsingStack.isEmpty());
        System.out.println(queueUsingStack.peek());
        System.out.println(queueUsingStack.pop());
        System.out.println(queueUsingStack.isEmpty());
        queueUsingStack.push(30);
        System.out.println(queueUsingStack.peek());
        queueUsingStack.push(40);
        System.out.println(queueUsingStack.peek());
    }

}
