package com.learning.practise.scaler.advance.dsa.recursion1;

public class Print1ToA {

    public static void main(String[] args) {
        solve(9);
    }

    public static void solve(int A) {
        if (A > 0) {
            solve(A - 1);
            System.out.print(A + " ");
        } else {
            System.out.println();
        }
    }

}
