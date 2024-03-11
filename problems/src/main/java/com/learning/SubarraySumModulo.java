package com.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class SubarraySumModulo {

    static final long MOD = 1000000007;

    static long sumOfSubarrayValues(ArrayList<Integer> A) {
        long result = 0;
        Stack<Integer> stack = new Stack<>();
        int n = A.size();

        for (int i = 0; i < n; i++) {
            int currentElement = A.get(i);
            // Calculate the sum of values of subarrays ending at A[i]
            while (!stack.isEmpty() && currentElement >= A.get(stack.peek())) {
                int idx = stack.pop();
                long diff = A.get(idx);
                if (!stack.isEmpty()) {
                    diff -= A.get(stack.peek());
                }
                result = (result + (diff * (i - idx) % MOD)) % MOD;
            }
            stack.push(i);
        }

        // Calculate the sum of remaining elements in the stack
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            long diff = A.get(idx);
            if (!stack.isEmpty()) {
                diff -= A.get(stack.peek());
            }
            result = (result + (diff * (n - idx) % MOD)) % MOD;
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(992387, 932142, 971117, 934674, 988917, 967890, 948508, 970347));
        System.out.println(sumOfSubarrayValues(A)); // Expected output: 1362057
    }
}
