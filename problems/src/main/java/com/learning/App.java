package com.learning;

import java.util.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println(divisorCount(10));
        // System.out.println(divisorCount(3));
        // System.out.println(divisorCount(4));

    }


    private static int divisorCount(Integer number) {
        if (number == 1) return 1;
        int count = 0;
        for (int i = 1; i * i <= number; i++) {
            if (number % i == 0) count += (i == (number / i)) ? 1 : 2;
        }
        return count;
    }


}
