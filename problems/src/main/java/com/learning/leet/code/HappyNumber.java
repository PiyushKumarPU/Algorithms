package com.learning.leet.code;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public boolean isHappy(int n) {
        Set<Integer> processed = new HashSet<>();
        while (n != 1) {
            n = calculateDigitSquare(n);
            if (processed.contains(n)) return false;
            processed.add(n);
        }
        return true;
    }

    public boolean isHappyNoSpace(int n) {
        int n1 = n;
        int n2 = n;
        do {
            n1 = calculateDigitSquare(n1);
            n2 = calculateDigitSquare(calculateDigitSquare(n2));
        } while (n1 != n2);

        return n1 == 1;
    }

    private int calculateDigitSquare(int n) {
        int result = 0;
        while (n > 0) {
            int digit = n % 10;
            result += (digit * digit);
            n /= 10;
        }
        return result;
    }
}
