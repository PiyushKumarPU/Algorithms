package com.learning.scaler.advance.module3.queue.lecture;

import java.util.ArrayList;

public class QueueUsingDynamicArray<T> {

    private final ArrayList<T> data;
    private int front = 0, rear = -1;

    public QueueUsingDynamicArray() {
        this.data = new ArrayList<>();
    }

    public QueueUsingDynamicArray(int initialCapacity) {
        this.data = new ArrayList<>(initialCapacity);
    }

    public int size() {
        return isEmpty() ? 0 : rear - front + 1;
    }

    public boolean isEmpty() {
        return front > rear;
    }

    public T peek() {
        return isEmpty() ? null : data.get(front);
    }

    public void enqueue(T element) {
        data.add(element);
        rear++;
    }

    public T dequeue() {
        return isEmpty() ? null : data.get(front++);
    }

    public static void main(String[] args) {
        QueueUsingDynamicArray<Integer> queue = new QueueUsingDynamicArray<>();
        queue.enqueue(3);
        queue.enqueue(5);
        queue.enqueue(8);
        System.out.println(queue.dequeue());
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());

    }
}
