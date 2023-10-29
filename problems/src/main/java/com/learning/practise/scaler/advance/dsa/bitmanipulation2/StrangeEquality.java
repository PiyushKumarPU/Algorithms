package com.learning.practise.scaler.advance.dsa.bitmanipulation2;

public class StrangeEquality {

    public static void main(String[] args) {
        System.out.println(solve(5));
    }

    public static int solve(int A) {
        int x = 0, y;
        for (int start = A - 1; start > 0; start--) {
            if ((A & start) == 0) {
                x = start;
                break;
            }
        }
        for (int start = A + 1; ; start++) {
            if ((A & start) == 0) {
                y = start;
                break;
            }
        }
        return x ^ y;
    }
}
