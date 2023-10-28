package com.learning.scaler.intermediate.problem.solving.additional;

/*
* Problem Description
You are given an integer A. You have to tell whether it is a perfect number or not.

Perfect number is a positive integer which is equal to the sum of its proper positive divisors.

A proper divisor of a natural number is the divisor that is strictly less than the number.

Problem Constraints
1 <= A <= 106
* */
public class PerfectNumber {
    public static void main(String[] args) {
        System.out.println(solve(4));
        System.out.println(solve(6));

    }

    public static int solve(int A) {
        if (A <= 1) return 0;
        int sum = 1;
        for (int index = 2; index * index <= A; index++) {
            if (A % index == 0) {
                sum += (index + A / index);
            }
        }
        return sum == A ? 1 : 0;
    }
}
