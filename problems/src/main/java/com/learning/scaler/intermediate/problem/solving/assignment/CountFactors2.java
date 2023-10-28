package com.learning.scaler.intermediate.problem.solving.assignment;

/*
* Problem Description
Given an integer A, you need to find the count of it's factors.

Factor of a number is the number which divides it perfectly leaving no remainder.

Example : 1, 2, 3, 6 are factors of 6


Problem Constraints
1 <= A <= 109
* */
public class CountFactors2 {

    public static void main(String[] args) {
        System.out.println(solve(10));
    }

    public static int solve(int A) {
        int count = 0;
        for (int index = 1; index * index <= A; index++) {
            if (A % index == 0) {
                count += (index == (A / index)) ? 1 : 2;
            }
        }
        return count;
    }
}
