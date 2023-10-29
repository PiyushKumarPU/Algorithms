package com.learning.practise.scaler.advance.dsa.bitmanipulation1;

public class UnsetXBitFromRight {

    public static void main(String[] args) {
        System.out.println(solve(25L,3));
        System.out.println(solve(37L,3));

    }

    public static Long solve(Long A, int B) {
        for (int i = 0; i < B; i++) {
            if ((A & (1L << i)) > 0) A = A ^ (1L << i);
        }
        return A;
    }
}
