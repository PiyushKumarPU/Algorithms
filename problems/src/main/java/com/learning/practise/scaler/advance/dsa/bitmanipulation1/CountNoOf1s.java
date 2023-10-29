package com.learning.practise.scaler.advance.dsa.bitmanipulation1;

public class CountNoOf1s {

    public static void main(String[] args) {
        System.out.println(numSetBits(11));
        System.out.println(numSetBits(6));
        System.out.println(numSetBits(1));

    }

    public static int numSetBits(int A) {
        int count = 0;
        while (A > 0) {
            if ((A & 1) > 0) count++;
            A = A >> 1;
        }
        return count;
    }
}
