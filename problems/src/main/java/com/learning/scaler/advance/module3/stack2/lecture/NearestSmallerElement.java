package com.learning.scaler.advance.module3.stack2.lecture;


import java.util.Arrays;
import java.util.Stack;

/*
Problem Description
    Given an array A, find the nearest smaller element G[i] for every element A[i] in the array such
    that the element has an index smaller than i.
    More formally,
    G[i] for an element A[i] = an element A[j] such that
    j is maximum possible AND
    j < i AND
    A[j] < A[i]
    Elements for which no smaller element exist, consider the next smaller element as -1.

Problem Constraints
    1 <= |A| <= 100000
    -10^9 <= A[i] <= 10^9

Input Format
    The only argument given is integer array A.

Output Format
    Return the integar array G such that G[i] contains the nearest smaller number than A[i]. If no such element occurs G[i] should be -1.

Example
    Input 1:
         A = [4, 5, 2, 10, 8]
    Input 2:
         A = [3, 2, 1]

Example
    Output 1:
         [-1, 4, -1, 2, 2]
    Output 2:
         [-1, -1, -1]

Example
    Explanation 1:
        index 1: No element less than 4 in left of 4, G[1] = -1
        index 2: A[1] is only element less than A[2], G[2] = A[1]
        index 3: No element less than 2 in left of 2, G[3] = -1
        index 4: A[3] is nearest element which is less than A[4], G[4] = A[3]
        index 4: A[3] is nearest element which is less than A[5], G[5] = A[3]
    Explanation 2:
        index 1: No element less than 3 in left of 3, G[1] = -1
        index 2: No element less than 2 in left of 2, G[2] = -1
        index 3: No element less than 1 in left of 1, G[3] = -1
* */
public class NearestSmallerElement {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(prevSmallerIndex(new int[]{4, 5, 2, 10, 8})));
        System.out.println(Arrays.toString(prevSmallerIndexNoClass(new int[]{4, 5, 2, 10, 8})));
        System.out.println(Arrays.toString(prevSmallerIndex(new int[]{3, 2, 1})));
        System.out.println(Arrays.toString(prevSmallerIndexNoClass(new int[]{3, 2, 1})));

    }

    public static int[] prevSmaller(int[] A) {
        if (A == null || A.length == 0) return A;
        int[] result = new int[A.length];
        Stack<Integer> smallerStack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            // pop all greater or equal element from stack
            while (!smallerStack.isEmpty() && smallerStack.peek() >= A[i]) smallerStack.pop();
            result[i] = smallerStack.isEmpty() ? -1 : smallerStack.peek();
            smallerStack.push(A[i]);
        }
        return result;
    }

    public static int[] prevSmallerIndex(int[] A) {
        if (A == null || A.length == 0) return A;
        int[] result = new int[A.length];
        Stack<Pair> smallerStack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            // pop all greater or equal element from stack
            while (!smallerStack.isEmpty() && smallerStack.peek().val >= A[i]) smallerStack.pop();
            result[i] = smallerStack.isEmpty() ? -1 : smallerStack.peek().index;
            smallerStack.push(new Pair(A[i], i));
        }
        return result;
    }

    public static int[] prevSmallerIndexNoClass(int[] A) {
        if (A == null || A.length == 0) return A;
        int[] result = new int[A.length];
        Stack<Integer> smallerStack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            // pop all greater or equal element from stack
            while (!smallerStack.isEmpty() && A[smallerStack.peek()] >= A[i]) smallerStack.pop();
            result[i] = smallerStack.isEmpty() ? -1 : smallerStack.peek();
            smallerStack.push(i);
        }
        return result;
    }
}

class Pair {
    int val;
    int index;

    public Pair(int val, int index) {
        this.val = val;
        this.index = index;
    }
}
