package com.learning.scaler.advance.module3.queue.lecture;


public class QueueUsingLinkedList<T> {

    Node<T> front, rear;
    int rearIndex = -1, frontIndex = 0;

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return isEmpty() ? 0 : rearIndex - frontIndex + 1;
    }

    public T peek() {
        return isEmpty() ? null : front.data;
    }

    public T dequeue() {
        if (isEmpty()) return null;
        T val = front.data;
        frontIndex++;
        front = front.next;
        return val;
    }

    public void enqueue(T val) {
        Node<T> newNode = new Node<>(val);
        if (front == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = rear.next;
        }
        rearIndex++;
    }

    public static void main(String[] args) {
        QueueUsingLinkedList<Integer> queue = new QueueUsingLinkedList<>();
        queue.enqueue(3);
        queue.enqueue(5);
        queue.enqueue(8);
        System.out.println(queue.dequeue());
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}

class Node<T> {
    public T data;
    public Node<T> next;

    public Node(T data) {
        this.data = data;
    }
}
