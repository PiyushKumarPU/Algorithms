package com.learning.scaler.advance.module3.stack2.assignment;


import java.util.Stack;

/*
Problem Description
    Given an array of integers A.
    The value of an array is computed as the difference between the maximum element in the array and
    the minimum element in the array A.
    Calculate and return the sum of values of all possible subarrays of A modulo 10^9+7.

Problem Constraints
    1 <= |A| <= 100000
    1 <= A[i] <= 1000000

Input Format
    The first and only argument given is the integer array A.

Output Format
     Returns the sum of values of all possible subarrays of A modulo 109+7.

Example
    Input 1:
         A = [1]
    Input 2:
         A = [4, 7, 3, 8]

Example
    Output 1:
         0
    Output 2:
         26

Example
    Explanation 1:
        Only 1 subarray exists. Its value is 0.
    Explanation 2:
        value ( [4] ) = 4 - 4 = 0
        value ( [7] ) = 7 - 7 = 0
        value ( [3] ) = 3 - 3 = 0
        value ( [8] ) = 8 - 8 = 0
        value ( [4, 7] ) = 7 - 4 = 3
        value ( [7, 3] ) = 7 - 3 = 4
        value ( [3, 8] ) = 8 - 3 = 5
        value ( [4, 7, 3] ) = 7 - 3 = 4
        value ( [7, 3, 8] ) = 8 - 3 = 5
        value ( [4, 7, 3, 8] ) = 8 - 3 = 5
        sum of values % 10^9+7 = 26
* */
public class MaxAndMin {

    public static void main(String[] args) {
        int[] ints = {4, 7, 3, 8};
        System.out.println(solveCarryForward(ints));

    }


    // TLE because TC : O(n^3)
    public static int solveBruteForce(int[] A) {
        int size = A.length, totalSum = 0;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
                for (int k = i; k <= j; k++) {
                    min = Math.min(min, A[k]);
                    max = Math.max(max, A[k]);
                }
                totalSum += (max - min);
                totalSum %= 1000000007;
            }
        }
        return totalSum;
    }

    public static int solveCarryForward(int[] A) {
        int totalSum = 0;
        for (int i = 0; i < A.length; i++) {
            int currentMin = A[i], currentMax = A[i];
            for (int j = i + 1; j < A.length; j++) {
                currentMax = Math.max(A[j], currentMax);
                currentMin = Math.min(A[j], currentMin);
                totalSum += (currentMax - currentMin);
                totalSum %= 1000000007;
            }
        }
        return totalSum;
    }

    // contribution technique
    public static int solve(int[] A) {
        // calculate NGL and NGR
        // calculate NSL and NSR
        int[] ngl = new int[A.length], ngr = new int[A.length], nsl = new int[A.length], nsr = new int[A.length];
        // calculate next greater left and next smaller left
        Stack<Integer> maxStack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            while (!maxStack.isEmpty() && A[maxStack.peek()] <= A[i]) maxStack.pop();
            ngl[i] = maxStack.isEmpty() ? 0 : maxStack.peek();
            maxStack.push(i);

            while (!minStack.isEmpty() && A[minStack.peek()] >= A[i]) minStack.pop();
            nsl[i] = minStack.isEmpty() ? 0 : minStack.peek();
            minStack.push(i);
        }

        // calculate next greater right and next smaller right
        maxStack.clear();
        minStack.clear();
        for (int i = A.length - 1; i >= 0; i--) {
            while (!maxStack.isEmpty() && A[maxStack.peek()] <= A[i]) maxStack.pop();
            ngr[i] = maxStack.isEmpty() ? 0 : maxStack.peek();
            maxStack.push(i);

            while (!minStack.isEmpty() && A[minStack.peek()] >= A[i]) minStack.pop();
            nsr[i] = minStack.isEmpty() ? 0 : minStack.peek();
            minStack.push(i);
        }

        int totalSum = 0;
        for (int i = 0; i < A.length; i++) {
            int noOfMax = Math.abs((i - ngl[i])) * Math.abs((ngr[i] - i));
            int noOfMin = Math.abs((i - nsl[i])) * Math.abs((nsr[i] - i));
            totalSum += A[i] * (noOfMax - noOfMin);
            totalSum %= 1000000007;
        }
        return totalSum;
    }


    // this function calculates next_greater element index
    public void findNextGreaterElement(int[] nge, int n, int[] a) {
        // this function calculates next_greater element index
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) nge[i + 1] = n + 1;
        for (int i = 1; i <= n; i++) {
            if (s.empty()) {
                s.push(i);
            } else {
                while (!s.empty() && a[s.peek()] <= a[i]) {
                    nge[s.peek()] = i;
                    s.pop();
                }
                s.push(i);
            }
        }
    }
    // this function calculates Previous_greater element index
    // this function calculates Previous smaller element index
    // this function calculates Next smaller element index

}

class MaxAndMinScaler {


    // scaler
    int[] a;

    public void findNextGreaterElement(int[] Next_greater_element, int n) {
        // this function calculates next_greater element index
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) Next_greater_element[i + 1] = n + 1;
        for (int i = 1; i <= n; i++) {
            if (s.empty()) {
                s.push(i);
            } else {
                while (!s.empty() && a[s.peek()] <= a[i]) {
                    Next_greater_element[s.peek()] = i;
                    s.pop();
                }
                s.push(i);
            }
        }
    }

    public void findPreviousGreaterElement(int[] Previous_greater_element, int n) {
        // this function calculates Previous_greater element index
        Stack<Integer> s = new Stack<Integer>();
        for (int i = n; i > 0; i--) {
            if (s.empty()) {
                s.push(i);
            } else {
                while (!s.empty() && a[i] > a[s.peek()]) {
                    Previous_greater_element[s.peek()] = i;
                    s.pop();
                }
                s.push(i);
            }
        }
    }

    public void findPreviousSmallerElement(int[] Previous_smaller_element, int n) {
        // this function calculates Previous smaller element index
        Stack<Integer> s = new Stack<Integer>();
        for (int i = n; i > 0; i--) {
            if (s.empty()) {
                s.push(i);
            } else {
                while (!s.empty() && a[i] <= a[s.peek()]) {
                    Previous_smaller_element[s.peek()] = i;
                    s.pop();
                }
                s.push(i);
            }
        }
    }

    public void findNextSmallerElement(int[] Next_smaller_element, int n) {
        // function function calculates Next smaller element index
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0; i < n; i++) Next_smaller_element[i + 1] = n + 1;
        for (int i = 1; i <= n; i++) {
            if (s.empty()) {
                s.push(i);
            } else {
                while (!s.empty() && a[i] < a[s.peek()]) {
                    Next_smaller_element[s.peek()] = i;
                    s.pop();
                }
                s.push(i);
            }
        }
    }

    public int solve1(int[] A) {
        int n = A.length, mod = 1000 * 1000 * 1000 + 7;
        a = new int[n + 1];
        int[] Next_greater_element = new int[n + 1];
        int[] Previous_greater_element = new int[n + 1];
        int[] Previous_smaller_element = new int[n + 1];
        int[] Next_smaller_element = new int[n + 1];
        System.arraycopy(A, 0, a, 1, n);

        findNextGreaterElement(Next_greater_element, n);
        findPreviousGreaterElement(Previous_greater_element, n);
        findPreviousSmallerElement(Previous_smaller_element, n);
        findNextSmallerElement(Next_smaller_element, n);

        long ans = 0;
        for (int i = 1; i <= n; i++) {
            long right = Next_greater_element[i] - i;
            long left = i - Previous_greater_element[i];
            ans += (((left * right) % mod) * a[i]) % mod;
            ans %= mod;
            left = i - Previous_smaller_element[i];
            right = Next_smaller_element[i] - i;
            ans -= (((left * right) % mod) * a[i]) % mod;
            ans += mod;
            ans %= mod;
        }
        return (int) ans;
    }
}
