package com.learning.practise.scaler.advance.dsa.bitmanipulation1;

/*
 * You are given two integers A and B.
 * Set the A-th bit and B-th bit in 0, and return output in decimal Number System.
 */
public class SetIthBit {

    public static void main(String[] args) {
        System.out.println(solve(3, 5));
        System.out.println(solve(4, 4));
        System.out.println(solve(0, 0));
    }

    public static int solve(int A, int B) {
        //if (A < 1 && B < 1) return 0;
        int result = 0;
        result = result ^ ((A == B) ? (1 << A) : ((1 << B) ^ (1 << A)));
        return result;

    }
}
