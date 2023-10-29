package com.learning.practise.scaler.advance.dsa.bitmanipulation1;


/*
 * You are given two integers A and B.
 *If B-th bit in A is set, make it unset.
 *If B-th bit in A is unset, leave as it is.
 *Return the updated A value.

 *Note:
 *    The bit position is 0-indexed, which means that the least significant bit (LSB) has index 0.
 */
public class UnsetIthBit {

    public static void main(String[] args) {
        System.out.println(solve(4,1));
        System.out.println(solve(5,2));

    }

    public static int solve(int A, int B) {
        if ((A & (1 << B)) > 0) A = A ^ (1 << B);
        return A;

    }
}
