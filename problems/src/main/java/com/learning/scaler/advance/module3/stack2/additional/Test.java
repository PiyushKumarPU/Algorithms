package com.learning.scaler.advance.module3.stack2.additional;

import java.util.Arrays;
import java.util.Stack;

public class Test {

    public static void main(String[] args) {
        int[] input = new int[]{6, 4, 8, 3, 9, 11};
        int[] a = new int[input.length + 1];
        System.arraycopy(input, 0, a, 1, input.length);
        System.out.println(Arrays.toString(findNextGreaterElement(a, input.length)));

        System.out.println();
    }

    public static int[] findNextGreaterElement(int[] a, int n) {
        // this function calculates next_greater element index
        Stack<Integer> s = new Stack<>();
        int[] nge = new int[n + 1];
        for (int i = 0; i < n; i++) nge[i + 1] = n + 1;
        for (int i = 1; i <= n; i++) {
            while (!s.empty() && a[s.peek()] <= a[i]) {
                nge[s.peek()] = i;
                s.pop();
            }
            s.push(i);
        }
        return nge;
    }
}
