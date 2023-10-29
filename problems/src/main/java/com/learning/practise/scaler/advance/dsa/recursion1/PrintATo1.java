package com.learning.practise.scaler.advance.dsa.recursion1;


/*
 * You are given an integer A, print 1 to A using recursion.
 * Note :- After printing all the numbers from 1 to A, print a new line.
 * */
public class PrintATo1 {

    public static void main(String[] args) {
        solve(5);
    }

    public static void solve(int A) {
        if (A < 1) {
            System.out.println();
        } else {
            System.out.print(A + " ");
            solve(A - 1);
        }
    }


}
