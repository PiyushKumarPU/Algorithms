package com.learning.scaler.intermediate.problem.solving.assignment;

/*
* Problem Description
Given a number A. Return 1 if A is prime and return 0 if not.

Note :
The value of A can cross the range of Integer.


Problem Constraints
1 <= A <= 109
* */
public class IsPrime {

    public static void main(String[] args) {
        System.out.println(solve(11));
        System.out.println(solve(12));

    }

    public static boolean solve(int A) {
        int factorCount = 0;
        for (int startElement = 1; startElement * startElement <= A; startElement++) {
            if (A % startElement == 0) {
                factorCount += (startElement == (A / startElement)) ? 1 : 2;
                if (factorCount > 2) return false;
            }
        }
        return true;
    }
}
