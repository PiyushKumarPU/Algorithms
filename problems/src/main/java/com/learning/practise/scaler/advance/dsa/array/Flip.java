package com.learning.practise.scaler.advance.dsa.array;

import java.util.Arrays;

public class Flip {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(flip("1111111")));
        System.out.println(Arrays.toString(flip("000000")));
        System.out.println(Arrays.toString(flip("00001")));
    }

    public static int[] flip(String A) {
        return com.learning.scaler.advance.module1.array1d.additional.Flip.flip(A);
    }
}
