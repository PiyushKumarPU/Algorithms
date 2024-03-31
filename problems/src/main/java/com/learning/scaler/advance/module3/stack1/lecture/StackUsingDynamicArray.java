package com.learning.scaler.advance.module3.stack1.lecture;

import java.util.ArrayList;

public class StackUsingDynamicArray<T> {


    // stack operations
    // push
    // peek
    // pop
    // isEmpty
    // size

    private ArrayList<T> stack;
    int currentIndex = -1;

    public StackUsingDynamicArray(int capacity) {
        stack = new ArrayList<>(capacity);
    }

    public void push(T val) {
        currentIndex++;
        stack.add(currentIndex, val);
    }

    public T peek() {
        if (currentIndex >= 0)
            return stack.get(currentIndex);
        return null;
    }

    public T pop() {
        if (currentIndex >= 0) {
            return stack.get(currentIndex--);
        }
        return null;
    }

    public boolean isEmpty() {
        return currentIndex < 0;
    }

    public int size() {
        return currentIndex + 1;
    }


}
