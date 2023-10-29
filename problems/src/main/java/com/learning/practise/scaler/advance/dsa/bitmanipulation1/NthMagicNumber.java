package com.learning.practise.scaler.advance.dsa.bitmanipulation1;

public class NthMagicNumber {

    public static void main(String[] args) {
        System.out.println(solve(3));
        System.out.println(solve(7));
        System.out.println(solve(10));

    }

    public static int solve(int A) {
        int val = 0, i = 1, base = 5;
        while (A > 0) {
            if ((A & 1) > 0) val += (int) Math.pow(base, i);
            i++;
            A = A >> 1;
        }
        return val;
    }
}
