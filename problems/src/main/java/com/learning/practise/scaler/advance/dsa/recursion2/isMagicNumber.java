package com.learning.practise.scaler.advance.dsa.recursion2;

/*
 * Given a number A, check if it is a magic number or not.
 * A number is said to be a magic number if the sum of its digits is calculated till a single digit recursively
 * by adding the sum of the digits after every addition. If the single digit comes out to be 1,
 * then the number is a magic number.
 * */
public class isMagicNumber {

    public static void main(String[] args) {
        System.out.println(solve(83557));
        System.out.println(solve(1291));
    }

    public static int solve(int A) {
        return sumOfDigit(A) == 1 ? 1 : 0;
    }

    private static int sumOfDigit(int A) {
        if (A > 0 && A < 10) return A;
        else
            return sumOfDigit((A % 10) + sumOfDigit(A / 10));
    }
}
