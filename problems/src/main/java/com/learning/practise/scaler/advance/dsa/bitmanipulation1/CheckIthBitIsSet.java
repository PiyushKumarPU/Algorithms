package com.learning.practise.scaler.advance.dsa.bitmanipulation1;

/*
 *You are given two integers A and B.
 * Return 1 if B-th bit in A is set
 * Return 0 if B-th bit in A is unset
 * Note:
 *    The bit position is 0-indexed, which means that the least significant bit (LSB) has index 0.
 */
public class CheckIthBitIsSet {

    public static void main(String[] args) {
        System.out.println(solve(4, 1));
        System.out.println(solve(5, 2));
        System.out.println(solve(0, 0));

    }

    public static int solve(int A, int B) {
        return ((A >> B) & 1) > 0 ? 1 : 0;

    }
}
