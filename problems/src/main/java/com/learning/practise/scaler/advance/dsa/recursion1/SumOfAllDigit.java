package com.learning.practise.scaler.advance.dsa.recursion1;

public class SumOfAllDigit {

    public static void main(String[] args) {
        System.out.println(solve(99999999));
    }

    public static int solve(int A) {
        if (A > 0 && A < 10) return A;
        else
            return (A % 10) + solve(A / 10);
    }


}
