package com.learning.leet.code;

import java.util.Stack;

public class MinStackNoSpace {

    private Stack<Long> stack;
    private long min;

    public MinStackNoSpace() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(0L);
            min = x;
        } else {
            // Store the difference between the new value and the current min
            stack.push(x - min);
            if (x < min) {
                min = x;
            }
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        long pop = stack.pop();
        // If the popped value is negative, it means we have to restore the previous min
        if (pop < 0) {
            min = min - pop;
        }
    }

    public int top() {
        long top = stack.peek();
        if (top > 0) {
            return (int) (top + min);
        } else {
            return (int) min;
        }
    }

    public int getMin() {
        return (int) min;
    }
}
