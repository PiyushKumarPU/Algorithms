package com.learning.practise.scaler.advance.dsa.bitmanipulation1;

public class ToggleIthBit {

    public static void main(String[] args) {
        System.out.println(solve(4,1));
        System.out.println(solve(5,2));

    }

    public static int solve(int A, int B) {
        return A ^ (1 << B);
    }
}
